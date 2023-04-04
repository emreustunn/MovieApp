package com.bilgeadam.dto.response;

import com.bilgeadam.repository.entity.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponseDto {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private UserType userType;
}
