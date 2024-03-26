package org.example.userservice2.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.userservice2.domain.User;
import org.example.userservice2.dto.RetrieveUserDetailResponse;
import org.example.userservice2.exception.UserNotFoundException;
import org.example.userservice2.repository.UserRepository;
import org.example.userservice2.service.UserService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service    // annotation service를 제외한 이 클래스는 pojo 객체라 한다
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public RetrieveUserDetailResponse retrieveUserDetail(String userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));
        String id = user.getId();
        String pw = user.getPw();
        return new RetrieveUserDetailResponse(id, pw);
    }
}
