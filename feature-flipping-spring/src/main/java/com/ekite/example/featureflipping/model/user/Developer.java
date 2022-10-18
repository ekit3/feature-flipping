package com.ekite.example.featureflipping.model.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Developer {

    private int id;
    private String name;
    private String role;
    private boolean canDrinkBeer;

    public Developer(int id, String name, String role) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.canDrinkBeer = false;
    }

}
