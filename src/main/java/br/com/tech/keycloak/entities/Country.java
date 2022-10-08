package br.com.tech.keycloak.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "TB_COUNTRY")
@Data
public class Country {

    @Id
    private Long id;

    private String name;

    private String flag;
}
