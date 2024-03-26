package org.example.userservice2.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RetrieveUserDetailResponse {
    private final String id;
    private final String pw;

    // return 하는 클래스는 serialize를 하기때문에 getter가 있어야한다
}
