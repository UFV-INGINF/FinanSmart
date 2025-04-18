package org.vaadin.example;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserDetails {

    @NotBlank
    private String firstName;

    @NotBlank
    private String userName;

    @NotBlank
    @Email
    private String email;

    @Size(min = 8, max = 64, message = "Password must be 8-64 char long")
    private String password;

    public String getFirstName() {return firstName;}

    public void setFirstName(String firstName) {this.firstName = firstName;}

    public String getUserName() {return userName;}

    public void setUserName(String userName) {this.userName = userName;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}

    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password;}

}
