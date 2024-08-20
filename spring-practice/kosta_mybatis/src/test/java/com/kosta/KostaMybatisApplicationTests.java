package com.kosta;

import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.beans.HasPropertyWithValue.hasProperty;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.kosta.dto.Community;

@SpringBootTest // 애플리케이션 통합 테스트
@AutoConfigureMockMvc // MockMvc 자동 구성하여 컨트롤러를 테스트할 때 사용
class KostaMybatisApplicationTests {

	@Autowired
	protected MockMvc mockMvc; // HTTP를 모방해서 테스트

	@Autowired
	private WebApplicationContext context; // 스프링 설정과 빈을 관리하는 컨텍스트

	@BeforeEach
	public void mockMvcSetUp() {
		// 각 테스트 실행 전에 MockMvc 인스턴스를 웹 애플리케이션 컨텍스트로 초기화
		this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@DisplayName("커뮤니티 리스트 테스트")
	@Test
	public void communityListTest() throws Exception {
		// 테스트할 URL 경로
		final String url = "/community/list";
		// MockMvc를 사용해 해당 url로 GET 요청을 수행
		final ResultActions result = mockMvc.perform(MockMvcRequestBuilders.get(url).accept(MediaType.TEXT_HTML));

		result.andExpect(status().isOk()) // 응답 상태가 HTTP 200 OK인지 확인
				// 반한된 뷰의 이름이 "community/communitylist"인지 확인
				.andExpect(view().name("community/communitylist"))
				// 모델에 "list"라는 속성이 존재하는지 확인
				.andExpect(model().attributeExists("list"))
				// list 모델이 List 타입인지 확인
				.andExpect(model().attribute("list", instanceOf(List.class)))
				// list 내부 구성 요소가 Community DTO로 구성되어있는지 확인
				.andExpect(model().attribute("list", everyItem(instanceOf(Community.class))))
				// list 내부 구성요소의 Community DTO에 title 값이 null이 아니고 빈 문자열도 아닌지 확인
				.andExpect(model().attribute("list", everyItem(hasProperty("title", notNullValue()))))
				// 응답 콘텐츠 타입 확인
				.andExpect(content().contentType("text/html;charset=UTF-8"));
	}

}
