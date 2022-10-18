package com.ekite.example.featureflipping.config;

import com.ekite.example.featureflipping.model.profil.ProductionProfil;
import com.ekite.example.featureflipping.model.profil.Profil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class ProfilConfiguration {

    @Bean
    @Profile("production-version")
    public Profil productionVersion() {
        return new ProductionProfil();
    }

    @Bean
    @Profile("development-version")
    public Profil developementVersion() {
        return new ProductionProfil();
    }
}
