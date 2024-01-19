package com.example.demo.dto;

import com.example.demo.service.UserService;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Component
public class AddressDto {

    private UserService userService;

    @JsonProperty(required = true)
    private String street;

    @JsonProperty(required = true)
    private String city;

    @JsonProperty(required = true)
    private String zipCode;

    @JsonProperty(required = true, access = JsonProperty.Access.WRITE_ONLY)
    private Long user;

}
