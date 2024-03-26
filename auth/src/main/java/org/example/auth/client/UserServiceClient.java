package org.example.auth.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

// controller 처럼 쓰면 된다
@FeignClient("user-service2")   // spring cloud가 모두 user-service2를 사용한다
public interface UserServiceClient {    // jpa처럼 interface로 선언만하고 사용할 수 있다

    @GetMapping("/users/{userId}/detail")
    Map<String, Object> retrieveUserDetail(@PathVariable String userId);    // 요렇게 쓰면 요청한다
}
