package br.com.tech.keycloak.rest.controller;

import br.com.tech.keycloak.dto.CountryPersist;
import br.com.tech.keycloak.dto.response.CountryResponse;
import br.com.tech.keycloak.entities.Country;
import br.com.tech.keycloak.mapper.CountryMapper;
import br.com.tech.keycloak.service.CountryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@AllArgsConstructor
@RequestMapping(value = "/api/countries")
@RestController
public class CountryController {

    private final CountryService countryService;

    @PostMapping
    public ResponseEntity<CountryResponse> save(@Valid @RequestBody CountryPersist countryPersist){
        Country country = CountryMapper.mapper.persistToEntity(countryPersist);
        country = countryService.save(country);
        return ResponseEntity.ok(CountryMapper.mapper.entityToResponse(country));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CountryResponse> find(@PathVariable("id") Long id){
        Country country = countryService.find(id);
        return ResponseEntity.ok(CountryMapper.mapper.entityToResponse(country));
    }


}
