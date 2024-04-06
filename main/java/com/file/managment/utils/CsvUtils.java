package com.file.managment.utils;

import com.file.managment.main.Breed;
import com.file.managment.main.Cat;

import java.io.*;

import java.util.*;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;

public class CsvUtils {
    final private static String FILE_PATH = "src/main/resources/cats.csv";
    final private static String OWNER_FILE_PATH = "src/main/resources/cats.csv/owner.csv";

    public void writeCsv() {

        try (Scanner scanner = new Scanner(System.in);
             FileWriter fileWriter = new FileWriter(FILE_PATH);

             CSVWriter writer = new CSVWriter(fileWriter)) {
            System.out.println("Enter ID:");
            int id = scanner.nextInt();
            System.out.println("Enter age:");
            int age = scanner.nextInt();
            System.out.println("Enter name:");
            String name = scanner.next();
            System.out.println("Enter color:");
            String color = scanner.next();
            System.out.println("Enter weight:");
            int weight = scanner.nextInt();
            Breed.CatBreed breed = Breed.CatBreed.valueOf(scanner.next());

            Cat cat = new Cat(id, age, name, color, weight, breed);


            // Writing data into CSV file
            String[] headers = {"id", "name", "color", "weight", "breed"};
            String[] data = {String.valueOf(id), name, color,
                    String.valueOf(weight)};

            writer.writeNext(headers);
            writer.writeNext(data);

            System.out.println("Data entered");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    public void readCsv() throws IOException {

        BufferedReader reader = null;
        String line = "";
        try {
            reader = new BufferedReader(new FileReader(FILE_PATH));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                for (String index : row) {
                    System.out.println(index);
                }
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            reader.close();
        }
    }

    public void removeLine(int rowNumber) throws IOException, CsvException {

        CSVReader reader2 = new CSVReader(new FileReader(FILE_PATH));
        List<String[]> allElements = reader2.readAll();
        allElements.remove(rowNumber);
        FileWriter sw = new FileWriter(FILE_PATH);
        CSVWriter writer = new CSVWriter(sw);
        writer.writeAll(allElements);
        writer.close();

    }

}
