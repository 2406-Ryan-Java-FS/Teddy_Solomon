package com.revature.services;

import com.revature.models.Actor;
import com.revature.repositories.ActorRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest(classes = com.revature.app.SpringMovieAppApplication.class)
public class ActorServiceTests {

    @Autowired
    ActorService as;

    @MockBean
    ActorRepo ar;

    @Test
    void addActor() {
        Actor a = new Actor(0, "Tom Cruise", (short) 55, 60000000);

        Mockito.when(ar.save(a)).thenReturn(new Actor(1, "Tom Cruise", (short) 55, 60000000));
        a = as.addActor(a);

        Assertions.assertEquals(1, a.getId());
        Assertions.assertEquals("Tom Cruise", a.getName());
    }

    @Test
    void deleteActor() {
        Actor a = new Actor(1, "Tom Cruise", (short) 55, 60000000);

        Mockito.doNothing().when(ar).deleteById(a.getId());

        boolean result = as.deleteActor(a.getId());
        Assertions.assertTrue(result);
    }

    @Test
    void deleteBadActor() {
        Actor a = new Actor(0, "Tom Cruise", (short) 55, 60000000);

        Mockito.doThrow(IllegalArgumentException.class).when(ar).deleteById(a.getId());

        boolean result = as.deleteActor(a.getId());
        Assertions.assertFalse(result);
    }

}
