package com.file.managment.main;

public class Dog {
    private int id;
    private String name;
    private Breed.DogBreed DogBreed;
    private String color;
    private double weight;
    public Dog(){}
    public Dog(int id, String name, String color, double weight, Breed.DogBreed DogBreed) {
        this.id = id;
        this.name = name;
        this.DogBreed = DogBreed;
        this.color = color;
        this.weight = weight;
    }
}
