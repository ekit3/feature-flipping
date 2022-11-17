package com.ekite.example.featureflipping.model.feature;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TechnicalStory extends Feature {

    public TechnicalStory(String id, List<Criteria> criteria) {
        this.id = id;
        this.criteria = criteria;
    }
}
