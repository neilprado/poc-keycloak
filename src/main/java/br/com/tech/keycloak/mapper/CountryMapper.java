package br.com.tech.keycloak.mapper;

import br.com.tech.keycloak.dto.CountryPersist;
import br.com.tech.keycloak.dto.CountryUpdate;
import br.com.tech.keycloak.dto.response.CountryResponse;
import br.com.tech.keycloak.entities.Country;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Mapper(componentModel = "spring")
public interface CountryMapper {

    CountryMapper mapper = Mappers.getMapper(CountryMapper.class);

     Country persistToEntity(CountryPersist countryPersist);

     CountryResponse entityToResponse(Country country);


     default Page<CountryResponse> PageEntityToPageResponse(Page<Country> countries){
         return this::entityToResponse;
     }

     @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
     Country toUpdate(@MappingTarget Country country, CountryUpdate countryUpdate);
}
