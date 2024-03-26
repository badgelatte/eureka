package org.example.userservice2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)   // 그래서 이렇게 설정하면 400으로 던질 수 있다
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String userId) {
        super(String.format("아이디 존재하지 않는다",userId));
        // advice로 에러 잡으면 200으로 가고 advice가 안 잡으면 500으로간다

    }
}
