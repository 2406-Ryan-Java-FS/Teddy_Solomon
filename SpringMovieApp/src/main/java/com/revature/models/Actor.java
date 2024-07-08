package com.revature.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name="actors")
public class Actor {

    @Id // makes this a primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="a_id", updatable = false)
    private int id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(columnDefinition = "smallint CHECK (age>=0)")
    private short age;

    private int worth;

    public Actor() {
    }

    public Actor(int id, String name, short age, int worth) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.worth = worth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public short getAge() {
        return age;
    }

    public void setAge(short age) {
        this.age = age;
    }

    public int getWorth() {
        return worth;
    }

    public void setWorth(int worth) {
        this.worth = worth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Actor actor = (Actor) o;
        return id == actor.id && age == actor.age && worth == actor.worth && Objects.equals(name, actor.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, worth);
    }

    @Override
    public String toString() {
        return "Actor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", worth=" + worth +
                '}';
    }
}
