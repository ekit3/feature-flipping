package com.ekite.example.featureflipping.controller;

import com.ekite.example.featureflipping.model.feature.Feature;
import com.ekite.example.featureflipping.service.FeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("features")
public class FeatureController {

    @Autowired
    private FeatureService featureService;

    @GetMapping("/{name}")
    public List<Feature> getAllFeaturesByUser(@PathVariable(value = "name") String name) {
        if(name != null) {
            return featureService.getAllFeaturesByUser(name);
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/{name}/{idFeature}")
    public Feature getFeatureByUserAndIdFeature(@PathVariable(value = "name") final String name,
                                                @PathVariable(value = "idFeature") final String idFeature) {
        if(name != null && idFeature != null) {
            return featureService.getFeatureByUserAndIdFeature(name, idFeature);
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }
}
