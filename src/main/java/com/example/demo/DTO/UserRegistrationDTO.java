package com.example.demo.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UserRegistrationDTO {

    @NotBlank(message = "Username is required!")
    @Size(min= 3, message = "Username must have atleast 3 characters!")
    @Size(max= 20, message = "Username can have have atmost 20 characters!")
    private String userName;

    @Size(min= 3, message = "Password must have atleast 3 characters!")
    private String password;

    @Email(message = "Email is not in valid format!")
    @NotBlank(message = "Email is required!")
    private String email;

    @NotBlank(message = "Phone number is required!")
    @Size(min = 10, max = 10, message = "Phone number must have 10 characters!")
    @Pattern(regexp="^[0-9]*$", message = "Phone number must contain only digits")
    private String phone;

    public @NotBlank(message = "Username is required!") @Size(min = 3, message = "Username must have atleast 3 characters!") @Size(max = 20, message = "Username can have have atmost 20 characters!") String getUserName() {
        return userName;
    }

    public void setUserName(@NotBlank(message = "Username is required!") @Size(min = 3, message = "Username must have atleast 3 characters!") @Size(max = 20, message = "Username can have have atmost 20 characters!") String userName) {
        this.userName = userName;
    }

    public @Email(message = "Email is not in valid format!") @NotBlank(message = "Email is required!") String getEmail() {
        return email;
    }

    public void setEmail(@Email(message = "Email is not in valid format!") @NotBlank(message = "Email is required!") String email) {
        this.email = email;
    }

    public @NotBlank(message = "Phone number is required!") @Size(min = 10, max = 10, message = "Phone number must have 10 characters!") @Pattern(regexp = "^[0-9]*$", message = "Phone number must contain only digits") String getPhone() {
        return phone;
    }

    public void setPhone(@NotBlank(message = "Phone number is required!") @Size(min = 10, max = 10, message = "Phone number must have 10 characters!") @Pattern(regexp = "^[0-9]*$", message = "Phone number must contain only digits") String phone) {
        this.phone = phone;
    }

    public @Size(min = 3, message = "Password must have atleast 3 characters!") String getPassword() {
        return password;
    }

    public void setPassword(@Size(min = 3, message = "Password must have atleast 3 characters!") String password) {
        this.password = password;
    }
}
