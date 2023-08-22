package bg.softuni.mobilele.model.dto;

import bg.softuni.mobilele.model.validation.FieldMatch;
import bg.softuni.mobilele.model.validation.UniqueUserEmail;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
@FieldMatch(
        first = "password",
        second = "confirmPassword",
        message = "passwords do not match"  )
public class UserRegisterDto {

    @NotEmpty
    @Size(min = 2,max = 20)
    private String firstName;

    @NotEmpty
    @Size(min = 2,max = 20)
    private String lastName;

    @NotEmpty
    @Email(message = "User email should be valid")
    @UniqueUserEmail(message = "User email should be unique.")
    private String email;

    @NotEmpty
    @Size(min = 5)
    private String password;

    private String confirmPassword;

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
