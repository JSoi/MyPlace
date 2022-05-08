package com.jsoi.good.controller;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PlaceForm {
    private final String placeName;
    private final String placeDes;
    private final String placeLat;
    private final String placeLong;
    private final String placeMemo;

    @Builder
    public PlaceForm(String placeName, String placeDes, String placeLat, String placeLong, String placeMemo) {
        this.placeName = placeName;
        this.placeDes = placeDes;
        this.placeLat = placeLat;
        this.placeLong = placeLong;
        this.placeMemo = placeMemo;
    }
}
