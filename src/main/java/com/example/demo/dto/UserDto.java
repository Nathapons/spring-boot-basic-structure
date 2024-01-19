package com.example.demo.dto;

import com.example.demo.entity.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Data
@Component
public class UserDto{
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String id;

    @JsonProperty(value = "first_name", access = JsonProperty.Access.READ_WRITE)
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("age")
    private int age;

    public UserDto toDto(User user) {
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.age = user.getAge();

        return this;
    }

    public User toEntity() {
        User user = new User();

        user.setFirstName(this.firstName);
        user.setLastName(this.lastName);
        user.setAge(this.age);

        return user;
    }
}
