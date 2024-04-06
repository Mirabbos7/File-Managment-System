package com.file.managment.utils;


import java.io.*;
import java.util.Scanner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.file.managment.main.Breed;
import com.file.managment.main.Dog;
import com.google.gson.*;


public class JsonUtils {
    static private final String FILE_PATH = "src/main/resources/dogs.json";

    public void writeJson() {

        try (Scanner scanner = new Scanner(System.in);
             FileWriter fileWriter = new FileWriter(FILE_PATH, false)) {

            System.out.println("Enter id:");
            int id = scanner.nextInt();

            System.out.println("Enter name:");
            String name = scanner.next();

            System.out.println("Enter color:");
            String color = scanner.next();

            System.out.println("Enter weight(double):");
            String weight = scanner.next();

            System.out.println("Enter breed:");
            Breed.DogBreed breed = Breed.DogBreed.valueOf(scanner.next().toUpperCase());

            System.out.println("Enter owner id: ");
            int PersonID = scanner.nextInt();

            System.out.println("Enter owner name: ");
            String PersonName = scanner.next();

            // Create JSON object and add properties
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("id", id);
            jsonObject.addProperty("name", name);
            jsonObject.addProperty("color", color);
            jsonObject.addProperty("weight", weight);
            jsonObject.addProperty("breed", breed.toString());

            //Create JSON object and properties for Owner
            JsonObject jsonObject1 = new JsonObject();
            jsonObject1.addProperty("owner ID: ", PersonID);
            jsonObject1.addProperty("owner Name: ", PersonName);

            JsonArray jsonArray = new JsonArray();
            jsonArray.add(jsonObject);
            jsonArray.add(jsonObject1);

            // Write JSON object to file
            fileWriter.write(jsonObject.toString());
            fileWriter.write(jsonObject1.toString());
            System.out.println("JSON object written to file successfully.");
        } catch (IOException | IllegalArgumentException | IllegalStateException e) {
            e.printStackTrace();
        }
    }
    public void readJson() {
        ObjectMapper mapper = new ObjectMapper();
        try{
            Dog dog = mapper.readValue(new File(FILE_PATH), Dog.class);
            System.out.println(dog);
        } catch (Exception e){
            System.out.println("Error occurred" + e.toString());
        }
    }
}