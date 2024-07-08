package com.revature.services;

import com.revature.models.Actor;
import com.revature.repositories.ActorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorServiceImpl implements ActorService {

    @Autowired
    ActorRepo ar;

    @Override
    public Actor addActor(Actor a) {
        return ar.save(a);
    }

    @Override
    public Actor getActor(int id) {
        return ar.findById(id).orElseGet(Actor::new);
    }

    @Override
    public List<Actor> getAllActors() {
        return ar.findAll();
    }

    @Override
    public Actor updateActor(Actor change) {
        return ar.save(change);
    }

    @Override
    public boolean deleteActor(int id) {
        try {
            Actor a = getActor(id);
            if (a.getId() != 0) {
                ar.deleteById(id);
                return true;
            }
        } catch(IllegalArgumentException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Actor> getActor(String name) {
        return ar.findByName(name);
    }

    @Override
    public List<Actor> getActor(short age, int worth) {
        return ar.findByAgeAndWorth(age, worth);
    }
}
