package com.ekite.example.featureflipping.service;

import com.ekite.example.featureflipping.model.feature.Feature;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeatureService {

    public List<Feature> getAllFeaturesByUser(final int id) {
        //FIXME todo selon le user savoir ce qu'on renvoie
        return null;
    }

    public List<Feature> getFeatureByUserAndIdFeature(Integer idUser, Integer idFeature) {
        //FIXME todo selon le user et la feature savoir ce qu'on renvoie
        return null;
    }
}
