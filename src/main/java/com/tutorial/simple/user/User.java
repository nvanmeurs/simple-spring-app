package com.tutorial.simple.user;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
public class User {
    @Id
    private String id;

    @NotBlank(message="Name is a mandatory field")
    @Size(min=5, max=128, message="Name should have at least 5 characters, and no more than 128 characters")
    private String name;

    @NotNull(message="Birth date is a mandatory field")
    @Past(message="Birth date can not be in the future")
    private Date birthDate;
}