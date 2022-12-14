package com.ekite.example.featureflipping.model.feature;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Feature {
    protected String id;
    protected List<Criteria> criteria;
}
