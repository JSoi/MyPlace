package com.jsoi.good.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class PlaceVO {
    // Read-Only 속성을 가진 값 오브젝트
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long placeSerial;
    private String placeName;
    private Long userSerial;
    private String placeDes;
    private String placeLat;
    private String placeLong;
    private String placeMemo;
}
