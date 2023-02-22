package aman.irshad.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;
    // User first name should not be null or empty
    @NotEmpty
    private String firstName;
    // User last name should not be null or empty
    @NotEmpty
    private String lastName;
    // User Email should not be null or empty
    // Email address should be valid
    @NotEmpty
    @Email
    private String email;
}
