package br.com.tech.keycloak.dto;

import lombok.Data;

import javax.validation.constraints.Size;

@Data
public class CountryUpdate {

    @Size(max = 30)
    private String name;

    @Size(max = 200)
    private String flag;
}
