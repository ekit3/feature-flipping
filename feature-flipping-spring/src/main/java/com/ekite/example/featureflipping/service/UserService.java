package com.ekite.example.featureflipping.service;

import com.ekite.example.featureflipping.model.user.Developer;
import com.ekite.example.featureflipping.model.user.NoviceDeveloper;
import com.ekite.example.featureflipping.model.user.TechLeadDeveloper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    public List<Developer> getUsers() {
        List<Developer> developers = new ArrayList<>();
        developers.add(new NoviceDeveloper());
        developers.add(new TechLeadDeveloper());
        return developers;
    }

}
