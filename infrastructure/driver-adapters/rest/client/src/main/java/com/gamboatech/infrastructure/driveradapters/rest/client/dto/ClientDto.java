package com.gamboatech.infrastructure.driveradapters.rest.client.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientDto {
    private Long id;
    private String name;
    private String gender;
    private Integer age;
    private String identificationNumber;
    private String address;
    private String phoneNumber;
    private String password;
    private Boolean status;
    private String clientId;
}
