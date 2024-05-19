package org.example;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

//Easy
public class Main {
    public static void main(String[] args) {
        try {
            FileInputStream FileInputStream = new FileInputStream("src/main/resources/yeats-poem.txt");

            //We're going to stream the file to the scanner
            Scanner scanner = new Scanner(System.in);
            String input;

            //Goes until there's no more lines
            while(scanner.hasNextLine()){
                input = scanner.nextLine();
                System.out.println(input);
            }

            scanner.close();
        }
        catch (FileNotFoundException ex) {
            System.out.println("File not found.");
        }

    }
}

//Not as Easy
public class Main {
    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader("src/main/resources/yeats-poem.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            //We're going to stream the file to the scanner
            Scanner scanner = new Scanner(System.in);
            String input;

            //Goes until there's no more lines
            while(scanner.hasNextLine()){
                input = scanner.nextLine();
                System.out.println(input);
            }

            scanner.close();
        }
        catch (FileNotFoundException ex) {
            System.out.println("File not found.");
        }

    }
}