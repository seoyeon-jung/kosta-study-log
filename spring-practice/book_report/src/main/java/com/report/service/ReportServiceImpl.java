package com.report.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.report.domain.ReportDTO;
import com.report.domain.Role;
import com.report.entity.Book;
import com.report.entity.Report;
import com.report.entity.User;
import com.report.repository.BookRepository;
import com.report.repository.ReportRepository;
import com.report.repository.UserRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {
	private final ReportRepository reportRepository;
	private final BookRepository bookRepository;
	private final UserRepository userRepository;

	@Override
	public List<Report> findAllReport() {
		return reportRepository.findAll();
	}

	@Transactional
	@Override
	public Report save(Report report, User user, Book book) {
		// 만약 Book table에 동일한 책이 존재한다면 저장하지 않음
		List<Book> existingBooks = bookRepository.findByBookTitleAndAuthor(book.getBookTitle(), book.getAuthor());
		Book existingBook;

		if (existingBooks.isEmpty()) {
			// 기존 책이 없는 경우
			existingBook = bookRepository.save(book);
		} else {
			existingBook = existingBooks.get(0);
		}

		report.setUser(user);
		report.setBook(existingBook);

		// 포인트 증가
		user.addPoints(5);
		userRepository.save(user);

		return reportRepository.save(report);
	}

	@Override
	public ReportDTO findById(Long id) throws Exception {
		Report report = reportRepository.findById(id).orElseThrow(() -> new Exception("ID가 존재하지 않습니다."));

		return ReportDTO.builder().id(report.getId()).title(report.getTitle()).content(report.getContent())
				.book(report.getBook()).user(report.getUser()).createdAt(report.getCreatedAt())
				.updatedAt(report.getUpdatedAt()).build();
	}

	@Override
	public void deleteById(Long id, User user) throws Exception {
		Report report = reportRepository.findById(id).orElseThrow(() -> new Exception("ID가 존재하지 않습니다."));
		String creator = report.getUser().getUsername();
		Role userRole = user.getRole();

		// 작성한 사람이거나, 관리자(ADMIN)인 경우 삭제 가능
		if (user.getUsername().equals(creator) || userRole == Role.ADMIN) {
			reportRepository.deleteById(id);
		} else {
			throw new Exception("본인이 작성한 글만 삭제할 수 있습니다.");
		}

	}

	@Override
	public Report update(Report report, User user, Book book) throws Exception {
		Report originReport = reportRepository.findById(report.getId())
				.orElseThrow(() -> new Exception("ID가 존재하지 않습니다."));
		String creator = originReport.getUser().getUsername();

		if (!user.getUsername().equals(creator)) {
			throw new Exception("본인이 작성한 글만 수정할 수 있습니다.");
		}

		Book originBook = bookRepository.findById(originReport.getBook().getId())
				.orElseThrow(() -> new Exception("책이 존재하지 않습니다."));

		// Book 객체 업데이트
		originBook.setBookTitle(book.getBookTitle());
		originBook.setAuthor(book.getAuthor());
		originBook.setPublisher(book.getPublisher());
		originBook.setGenre(book.getGenre());
		originBook.setUpdatedAt(LocalDateTime.now());

		bookRepository.save(originBook); // 새로운 Book 저장

		// Report 객체의 Book 업데이트
		report.setBook(originBook);

		// Report 객체 업데이트
		originReport.setTitle(report.getTitle());
		originReport.setContent(report.getContent());
		originReport.setUpdatedAt(LocalDateTime.now());

		return reportRepository.save(originReport);
	}

	@Override
	public List<Report> search(String keyword) {
		return reportRepository.findByTitleContainingOrContentContaining(keyword, keyword);

	}
}
