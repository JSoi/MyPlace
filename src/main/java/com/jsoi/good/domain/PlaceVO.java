package com.jsoi.good.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@ToString
@NoArgsConstructor
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
    @Builder
    public PlaceVO(String placeName, String placeDes, String placeLat, String placeLong, String placeMemo) {
        this.placeName = placeName;
        this.placeDes = placeDes;
        this.placeLat = placeLat;
        this.placeLong = placeLong;
        this.placeMemo = placeMemo;
    }
}
