package org.example.userservice2.service;

import org.example.userservice2.dto.RetrieveUserDetailResponse;

public interface UserService {
    RetrieveUserDetailResponse retrieveUserDetail(String userId);
}
