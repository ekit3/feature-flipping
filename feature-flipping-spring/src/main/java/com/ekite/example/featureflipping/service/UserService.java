package com.ekite.example.featureflipping.service;

import com.ekite.example.featureflipping.model.user.Developer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private FeatureFlippingService featureFlippingService;

    public List<Developer> getUsers() {
        return featureFlippingService.getUsers();
    }

}
