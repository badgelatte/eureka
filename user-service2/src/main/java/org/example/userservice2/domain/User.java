package org.example.userservice2.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 우리는 못쓰되 json은 써야하니까 protected로 막는다
@Getter
public class User {
    @Id
    private String id;
    private String pw;
    private String name;
    private LocalDateTime joinDate;

    public User(String userId, String userPw, String userName) {

        id = userId;
        pw = userPw;
        name = userName;
    }


    public static User createUser(String userId, String userPw, String userName) {
        return new User(userId,userPw, userName);
    }
}
