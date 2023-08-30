package bg.softuni.battleships.model.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserRegistrationDTO {

  @NotBlank
  @Size(min = 3,max = 10)
  private String username;

  @NotBlank
  @Size(min = 5,max = 20)
  private String fullName;
  @Email
  @NotBlank
  private String email;
  @NotBlank
  @Size(min = 3)
  private String password;

  @NotBlank
  private String confirmPassword;

  public String getUsername() {
    return username;
  }

  public UserRegistrationDTO setUsername(String username) {
    this.username = username;
    return this;
  }

  public String getFullName() {
    return fullName;
  }

  public UserRegistrationDTO setFullName(String fullName) {
    this.fullName = fullName;
    return this;
  }

  public String getEmail() {
    return email;
  }

  public UserRegistrationDTO setEmail(String email) {
    this.email = email;
    return this;
  }

  public String getPassword() {
    return password;
  }

  public UserRegistrationDTO setPassword(String password) {
    this.password = password;
    return this;
  }

  public String getConfirmPassword() {
    return confirmPassword;
  }

  public UserRegistrationDTO setConfirmPassword(String confirmPassword) {
    this.confirmPassword = confirmPassword;
    return this;
  }

  @Override
  public String toString() {
    return "UserRegistrationDTO{" +
            "username='" + username + '\'' +
            ", fullName='" + fullName + '\'' +
            ", email='" + email + '\'' +
            ", password='" + password + '\'' +
            ", confirmPassword='" + confirmPassword + '\'' +
            '}';
  }
}
