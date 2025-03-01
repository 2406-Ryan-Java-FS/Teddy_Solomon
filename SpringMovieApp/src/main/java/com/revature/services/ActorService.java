package com.revature.services;

import com.revature.models.Actor;

import java.util.List;

public interface ActorService {

    //Trivial Services
    public Actor addActor(Actor a);
    public Actor getActor(int id);
    public List<Actor> getAllActors();
    public Actor updateActor(Actor change);
    public boolean deleteActor(int id);

    //Can have other, more interesting services
    public List<Actor> getActor(String name);

    //More to come
    public List<Actor> getActor(short age, int worth);

}
