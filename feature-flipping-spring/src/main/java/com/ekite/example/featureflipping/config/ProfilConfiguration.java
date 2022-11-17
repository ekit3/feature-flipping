package com.ekite.example.featureflipping.config;

import com.ekite.example.featureflipping.model.profil.DevelopmentProfil;
import com.ekite.example.featureflipping.model.profil.ProductionProfil;
import com.ekite.example.featureflipping.model.profil.Profil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class ProfilConfiguration {

    @Bean
    @Profile("env-prod")
    public ProductionProfil productionVersion() {
        return new ProductionProfil();
    }

    @Bean
    @Profile("!env-prod")
    public DevelopmentProfil developementVersion() {
        return new DevelopmentProfil();
    }
}
