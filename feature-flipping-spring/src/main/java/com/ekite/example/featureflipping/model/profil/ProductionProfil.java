package com.ekite.example.featureflipping.model.profil;

import com.ekite.example.featureflipping.model.feature.*;
import com.ekite.example.featureflipping.model.user.TechLeadDeveloper;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Component
@Profile("env-dev")
public class ProductionProfil extends Profil {
    private TechLeadDeveloper techLeadDeveloper = new TechLeadDeveloper();

    public ProductionProfil() {
        List<Feature> featuresTechLead = new ArrayList<>();
        featuresTechLead.add(new Bug("bug",setAllCriteria()));
        featuresTechLead.add(new TechnicalStory("ts",setAllCriteria()));
        featuresTechLead.add(new UserStory("us", setAllCriteria()));
        techLeadDeveloper.setCriteria(featuresTechLead);
    }

    private List<Criteria> setAllCriteria() {
        return List.of(Criteria.builder()
                .canEdit(true).canRead(true).build());
    }
}
