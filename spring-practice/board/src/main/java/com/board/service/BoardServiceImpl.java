package com.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.dto.BoardDTO;
import com.board.mapper.BoardMapper;

// 비즈니스 로직을 처리하는 서비스 클래스임을 나타내는 annotaion
@Service
public class BoardServiceImpl implements BoardService {
	@Autowired // Mapper 자동 주입
	private BoardMapper boardMapper;

	@Override
	public List<BoardDTO> selectBoardList() throws Exception {
		// 사용자 요청을 처리하기 위한 비즈니스 로직 구현 (리스트 가져오기)
		List<BoardDTO> boardList = boardMapper.selectBoardList();
		return boardList;
	}

}
