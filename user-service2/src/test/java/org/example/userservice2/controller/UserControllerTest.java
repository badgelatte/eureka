package org.example.userservice2.controller;

import org.example.userservice2.dto.RetrieveUserDetailResponse;
import org.example.userservice2.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


// 단위 테스트
@WebMvcTest(UserController.class)
class UserControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    UserService userService;


    @Test
    @DisplayName("유저 디테일 요청 테스트")
    void retrieveUserDetailTest() throws Exception {   // retrieve와 get은 같은 거다
        // given - test위해 필요한 기반
        // when - 언제
        // GET /users/{userId}/detail

        // then -어떤 결과가 나왔음 하는건가
        // 200 JSON id, pw



        String testId = "testId";
        String testPw = "testPw";

        //스터딩해야한다
        RetrieveUserDetailResponse response = new RetrieveUserDetailResponse(testId, testPw);
        given(userService.retrieveUserDetail(any())).willReturn(response);


        mockMvc.perform(get("/users/{userId}/detail",testId))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(testId))  // $ = json body의 첨부터 시작하는 부분을 말한다
                .andExpect(jsonPath("$.pw").value(testPw));
    }
}
