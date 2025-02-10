package br.com.brunocontentedev.auth.dto.request;



import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record UserRegisterDTO(

        @NotNull(message = "Email is required")
        @NotBlank(message = "Email is required")
        @Email(message = "Email is invalid")
        String email,

        @NotBlank(message = "Password is required")
        @NotNull(message = "Password is required")
        @Pattern(
                regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$",
                message = "Password must contain at least one uppercase letter, one number, one special character and have at least 8 characters"
        )
        String password,

        @NotBlank(message = "First name is required")
        @NotNull(message = "First name is required")
        String firstName,

        @NotBlank(message = "Last name is required")
        @NotNull(message = "Last name is required")
        String lastName
       ) {
}
