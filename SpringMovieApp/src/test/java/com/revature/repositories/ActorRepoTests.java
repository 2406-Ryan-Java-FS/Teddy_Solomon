package com.revature.repositories;

import com.revature.models.Actor;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

@SpringBootTest(classes = com.revature.app.SpringMovieAppApplication.class)
@Transactional
public class ActorRepoTests {

    @Autowired
    public ActorRepo ar;

    @Test
    public void getAllActors() {
        List<Actor> actorList = ar.findAll();
        System.out.println(actorList);
        Assertions.assertFalse(actorList.isEmpty());
    }

    @Test
    @Rollback
    public void addActor() {
        Actor a = new Actor(0, "Natalie Portman", (short) 35, 30000000);
        a = ar.save(a);
        System.out.println(a);
        Assertions.assertNotEquals(0, a.getId());
    }
}
