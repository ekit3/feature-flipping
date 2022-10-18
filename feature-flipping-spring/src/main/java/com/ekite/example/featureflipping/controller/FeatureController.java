package com.ekite.example.featureflipping.controller;

import com.ekite.example.featureflipping.model.feature.Feature;
import com.ekite.example.featureflipping.service.FeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("features")
public class FeatureController {

    @Autowired
    private FeatureService featureService;

    @GetMapping("{idUser}")
    public List<Feature> getAllFeaturesByUser(final Integer idUser) {
        if(idUser != null) {
            return featureService.getAllFeaturesByUser(idUser);
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("{idUser/idFeature}")
    public List<Feature> getFeatureByUserAndIdFeature(final Integer idUser, final Integer idFeature) {
        if(idUser != null && idFeature != null) {
            return featureService.getFeatureByUserAndIdFeature(idUser, idFeature);
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }
}
