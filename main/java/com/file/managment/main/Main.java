package com.file.managment.main;


import com.file.managment.utils.CsvUtils;
import com.file.managment.utils.JsonUtils;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException, CsvException {
        JsonUtils jsonUtils = new JsonUtils();
        CsvUtils csvUtils = new CsvUtils();
        Scanner scanner = new Scanner(System.in);

        boolean isTrue = true;
        do {
            System.out.println("Welcome =)");
            System.out.println("Here is list of commands for u:");
            System.out.println("1.csv-read\n2.csv-write\n3.csv-remove\n4.json-read\n5.json-write\n6.json-remove");
            String command = scanner.next();
            switch (command) {
                case "1" :
                case"csv-read":
                    csvUtils.readCsv();
                    break;
                case "2":
                case"csv-write":
                    csvUtils.writeCsv();
                    break;
                case "3":
                case"csv-remove":
                    int rowLine = scanner.nextInt();
                    csvUtils.removeLine(rowLine);
                    break;
                case "4":
                case"json-read":
                    jsonUtils.readJson();
                    break;
                case "5":
                case"json-write":
                    jsonUtils.writeJson();
                    break;
//                case 6:
//                    jsonUtils.
//                    break;
//
                default:
                    command = "Invalid command";
                    break;
            }
        }
        while(isTrue);

    }
}
