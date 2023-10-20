package server.api.insurance.user.dto;

import lombok.*;
import server.api.insurance.user.entity.User;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private Long id;
    private String name;
    private int age;

    public static UserResponse of(User user){
        return UserResponse.builder()
                .name(user.getName())
                .age(user.getAge())
                .build();
    }
}
