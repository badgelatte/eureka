package org.example.userservice2.controller;

import lombok.RequiredArgsConstructor;
import org.example.userservice2.dto.RetrieveUserDetailResponse;
import org.example.userservice2.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor    // final 혹은 @NotNull을 가진 필드만을 생성자로 만든다
public class UserController {

    private final UserService userService;

    @GetMapping("/{userId}/detail")
    public ResponseEntity<RetrieveUserDetailResponse> retrieveUserDetail(@PathVariable String userId) {
        RetrieveUserDetailResponse response = userService.retrieveUserDetail(userId);

        return ResponseEntity.ok(response);
    }
}
