package com.ekite.example.featureflipping.model.feature;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserStory extends Feature {
    public UserStory(String id, List<Criteria> criteria) {
        this.id = id;
        this.criteria = criteria;
    }
}
