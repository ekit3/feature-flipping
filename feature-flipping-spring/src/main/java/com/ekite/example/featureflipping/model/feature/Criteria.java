package com.ekite.example.featureflipping.model.feature;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Criteria {
    private boolean canRead;
    private boolean canEdit;
}
