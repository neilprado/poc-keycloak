package br.com.tech.keycloak.service;

import br.com.tech.keycloak.entities.Country;
import br.com.tech.keycloak.repository.CountryRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;



@Service
@AllArgsConstructor
public class CountryService {

    private final CountryRepository countryRepository;

    public Country save(Country country){
        return null;
    }

    public Page<Country> list(Pageable pageable){
        return countryRepository.findAll(pageable);
    }

    public Country find(Long id){
        return null;
    }

    public Country update(Long id, Country country){
        return null;
    }

    public Country saveAll(){
        return null;
    }
}
