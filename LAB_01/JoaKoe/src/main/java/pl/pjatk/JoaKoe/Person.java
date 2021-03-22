package pl.pjatk.JoaKoe;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;


public class Person {
    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    Human human;

    public Person(Human human){

    }

    public void PrzedstawSie() {

        System.out.println("Nazywam się: " + getName());

    }

}
