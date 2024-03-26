package org.example.userservice2.service.impl;

import org.example.userservice2.dto.RetrieveUserDetailResponse;
import org.example.userservice2.service.UserService;
import org.springframework.stereotype.Service;

@Service    // annotation service를 제외한 이 클래스는 pojo 객체라 한다
public class UserServiceImpl implements UserService {
    @Override
    public RetrieveUserDetailResponse retrieveUserDetail(String userId) {
        return null;
    }
}
