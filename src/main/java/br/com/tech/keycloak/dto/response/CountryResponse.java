package br.com.tech.keycloak.dto.response;

import lombok.Data;

@Data
public class CountryResponse {

    private Long id;

    private String name;

    private String flag;
}
