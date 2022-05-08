package com.jsoi.good.controller;

import com.jsoi.good.domain.PlaceVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PlaceController {
    private final Logger logger = LoggerFactory.getLogger("LoggerController 의 로그");

    @PostMapping("newPlace.do")
    @ResponseBody
    public String registerPlace(PlaceForm vo) {
        logger.info("Register place logging");
        PlaceForm placeForm = PlaceForm.builder()
                .placeName(vo.getPlaceName())
                .placeDes(vo.getPlaceDes())
                .placeLat(vo.getPlaceLat())
                .placeLong(vo.getPlaceLong())
                .placeMemo(vo.getPlaceMemo()).build();
        logger.info(placeForm.toString());
        return placeForm.toString();
    }
}
