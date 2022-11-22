package io.goorm.ddic.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class Car {
    @Id
    @GeneratedValue
    private int id;
    private String chargingPlace;
    private String latitude;
    private String longitude;


}
