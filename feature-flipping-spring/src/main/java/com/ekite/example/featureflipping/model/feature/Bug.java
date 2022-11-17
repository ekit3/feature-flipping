package com.ekite.example.featureflipping.model.feature;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Bug extends Feature {
    public Bug(String id, List<Criteria> criteria) {
        this.id = id;
        this.criteria = criteria;
    }
}
