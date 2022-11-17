package com.ekite.example.featureflipping.service;

import com.ekite.example.featureflipping.model.feature.Feature;
import com.ekite.example.featureflipping.model.user.Developer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class FeatureService {

    @Autowired
    private FeatureFlippingService featureFlippingService;

    public List<Feature> getAllFeaturesByUser(final String name) {
        List<Developer> users = featureFlippingService.getUsers();
        return users.stream()
                .filter(user -> name.equals(user.getName()))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND))
                .getCriteria();
    }

    public Feature getFeatureByUserAndIdFeature(String name, String idFeature) {
        return getAllFeaturesByUser(name).stream()
                .filter(feature -> idFeature.equals(feature.getId()))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
