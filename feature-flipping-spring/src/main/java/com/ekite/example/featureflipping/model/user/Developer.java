package com.ekite.example.featureflipping.model.user;

import com.ekite.example.featureflipping.model.feature.Feature;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Developer {

    private int id;
    private String name;
    private String role;
    private boolean canDrinkBeer;
    @JsonIgnore
    private List<Feature> criteria;

    public Developer(int id, String name, String role) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.canDrinkBeer = false;
        this.criteria = new ArrayList<>();
    }

}
