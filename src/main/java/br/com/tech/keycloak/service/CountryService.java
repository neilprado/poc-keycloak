package br.com.tech.keycloak.service;

import br.com.tech.keycloak.entities.Country;
import br.com.tech.keycloak.mapper.CountryMapper;
import br.com.tech.keycloak.repository.CountryRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static br.com.tech.keycloak.utils.ExceptionCodes.COUNTRY_NOT_FOUND;


@Service
@AllArgsConstructor
public class CountryService {

    private final CountryRepository countryRepository;

    public Country save(Country country){
        return countryRepository.save(country);
    }

    public Page<Country> list(Pageable pageable){
        return countryRepository.findAll(pageable);
    }

    public Country find(Long id){
        return countryRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, COUNTRY_NOT_FOUND));
    }
    public Country update(Long id, Country country){
        Country toSaveCountry = find(id);
        toSaveCountry = CountryMapper.mapper.toUpdate(toSaveCountry, country);
        return countryRepository.save(toSaveCountry);
    }
}
