package org.example.userservice2.service;


import org.assertj.core.api.Assertions;
import org.example.userservice2.domain.User;
import org.example.userservice2.dto.RetrieveUserDetailResponse;
import org.example.userservice2.repository.UserRepository;
import org.example.userservice2.service.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;


class UserServiceTest {
    @InjectMocks // dependency를 주입받기 위해 사용
    UserServiceImpl userService;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Mock
    UserRepository userRepository;

//    위가 귀찮으면 이거 하나 쓰든가
//    @BeforeEach
//    void setUp(){
//        UserServiceImpl userService;
//
//    }

    @Test
    @DisplayName("유저 디테일 서비스 테스트")
    void retrieveUserDetailTest() {
        //given
        //when userService.retrieveUserDetail(userId);
        //then RetrieveUserDetailResponse response;

        // given
        String userId ="userId";
        String userPw ="userPw";

        String userName = "userName";
        User user = User.createUser(userId, userPw, userName);
        given(userRepository.findById(any())).willReturn(Optional.of(user));

        // when
        RetrieveUserDetailResponse response = userService.retrieveUserDetail(userId);

        // then
        Assertions.assertThat(response.getId()).isEqualTo(userId);
        Assertions.assertThat(response.getPw()).isEqualTo(userPw);
    }
}
