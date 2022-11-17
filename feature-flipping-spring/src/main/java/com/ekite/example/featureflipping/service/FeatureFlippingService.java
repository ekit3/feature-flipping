package com.ekite.example.featureflipping.service;

import com.ekite.example.featureflipping.config.ProfilConfiguration;
import com.ekite.example.featureflipping.model.profil.DevelopmentProfil;
import com.ekite.example.featureflipping.model.profil.ProductionProfil;
import com.ekite.example.featureflipping.model.user.Developer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class FeatureFlippingService {

    @Autowired
    ProfilConfiguration profilConfiguration;

    @Autowired
    private Environment environment;

    public List<Developer> getUsers() {
        List<Developer> developers = new ArrayList<>();
        List<String> profiles = Arrays.stream(environment.getActiveProfiles()).toList();
        if(profiles.contains("env-dev")) {
            DevelopmentProfil profil = this.profilConfiguration.developementVersion();
            developers.add(profil.getTechLeadDeveloper());
            developers.add(profil.getNoviceDeveloper());
        } else {
            ProductionProfil profil = this.profilConfiguration.productionVersion();
            developers.add(profil.getTechLeadDeveloper());
        }
        return developers;
    }

}
