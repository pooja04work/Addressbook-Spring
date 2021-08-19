package com.org.AddressbookSpringApp.model;

import com.org.AddressbookSpringApp.dto.AddressbookDTO;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Getter@Setter
@Entity
@Data
public class AddressbookData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String firstName;
    private String lastName;
    private String city;
    private String state;
    private String emailId;
    private int zip;
    private long phoneNumber;
}