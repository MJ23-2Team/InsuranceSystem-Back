package server.api.insurance.user.dto;

import lombok.*;
import server.api.insurance.user.entity.User;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id;
    private String name;
    private int age;

    public static UserDTO of(User user){
        return UserDTO.builder()
                .name(user.getName())
                .age(user.getAge())
                .build();
    }
}
