package com.org.AddressbookSpringApp.dto;

import lombok.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@ToString
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressbookDTO {

    public int id;
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "person FirstName is Invalid")
    @NotNull(message = "First name should not be Empty")
    public String firstName;

    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "person LastName is Invalid")
    @NotNull(message = "Last Name should not be Empty")
    public String lastName;

    @NotNull(message = "City should not be Empty")
    public String city;

    @NotNull(message = "State should not be Empty")
    public String state;

    @Pattern(regexp = "^[a-zA-Z0-9]{1,}[.a-zA-Z0-9]*@[a-zA-Z0-9]{1,}((.){1}+)([a-z]{1,3}+)(.[a-z]{2})*$", message = "Email is invalid")
    @NotNull(message = "Email should not be Empty")
    public String emailId;

    //    @Size(min = 6, max = 6, message = "Zip must be 10 digit")
//    @NotNull(message = "Zip should not be Empty")
    public int zip;

    //    @Size(min = 10, max = 10, message = "Enter 10 digit valid Phone number")
//    @NotNull(message = "Phone Number should not be Empty")
    public long phoneNumber;
}