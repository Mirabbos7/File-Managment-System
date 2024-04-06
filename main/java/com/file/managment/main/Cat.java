package com.file.managment.main;

public class Cat {
    private int age;
    private int id;
    private String color;
    private String name;
    private double weight;
    private Breed.CatBreed breed;

    public Cat(int id,int age, String name, String color, double weight, Breed.CatBreed breed) {
        this.id = id;
        this.age = age;
        this.color = color;
        this.name = name;
        this.weight = weight;
        this.breed = breed;
    }

    public Cat() {
        age = 0;
        color = "black";
        weight = 0;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "id=" + id +
                ", color='" + color + '\'' +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", breed=" + breed +
                '}';
    }
}