package com.example.finalproject.person.model;

import com.example.finalproject.person.dto.UserResponse;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "employees")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    public UserResponse mapToDto(){
        return new UserResponse(this.id,this.firstName,this.lastName,this.email);
    }

    public Employee(String firstName, String lastName , String email){
        this.firstName=firstName;
        this.lastName=lastName;
        this.email=email;
    }

}
