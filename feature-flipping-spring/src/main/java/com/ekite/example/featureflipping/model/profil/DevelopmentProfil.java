package com.ekite.example.featureflipping.model.profil;

import com.ekite.example.featureflipping.model.feature.*;
import com.ekite.example.featureflipping.model.user.NoviceDeveloper;
import com.ekite.example.featureflipping.model.user.TechLeadDeveloper;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Component
@Profile("env-dev")
public class DevelopmentProfil extends Profil {
    private TechLeadDeveloper techLeadDeveloper = new TechLeadDeveloper();
    private NoviceDeveloper noviceDeveloper = new NoviceDeveloper();

    public DevelopmentProfil() {
        List<Feature> featuresTechLead = new ArrayList<>();
        featuresTechLead.add(new Bug("bug",setAllCriteriaNovice()));
        featuresTechLead.add(new TechnicalStory("ts",setAllCriteria()));
        featuresTechLead.add(new UserStory("us", setAllCriteria()));
        List<Feature> featuresNovice = new ArrayList<>();
        featuresNovice.add(new Bug("bug",setAllCriteriaNovice()));
        featuresNovice.add(new TechnicalStory("ts",setAllCriteriaNovice()));
        featuresNovice.add(new UserStory("us", setAllCriteriaNovice()));
        techLeadDeveloper.setCriteria(featuresTechLead);
        noviceDeveloper.setCriteria(featuresNovice);
    }

    private List<Criteria> setAllCriteria() {
        return List.of(Criteria.builder()
                .canEdit(true).canRead(true).build());
    }

    private List<Criteria> setAllCriteriaNovice() {
        return List.of(Criteria.builder()
                .canEdit(false).canRead(true).build());
    }
}
