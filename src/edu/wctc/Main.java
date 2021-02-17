package edu.wctc;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Main {


    private static Scanner keyboard = new Scanner(System.in);
    private static PaintCalculator paintCalculator = new PaintCalculator();
    public static void main(String[] args) {

        int userResponse = 0;
        boolean end = false;
        do{
            printMenu();
            System.out.print("Enter Choice #: ");
            userResponse = keyboard.nextInt();
            switch (userResponse){
                case 1:
                    createRoom();
                    break;
                case 2:
                    System.out.println(paintCalculator.toString());
                    break;
                case 3:
                    readFile();
                    break;
                case 4:
                    writeFile();
                    break;
                case 5:
                    end = true;

                    break;
            }
        }while(!end);
    }

    private static void printMenu(){
        System.out.println("-------Menu-------");
        System.out.println("[1]Add room");
        System.out.println("[2]View rooms");
        System.out.println("[3]Read rooms from file");
        System.out.println("[4]Write rooms to file");
        System.out.println("[5]Exit Program\n");
    }

    private static double promptForDimension(String dimensionName){
        System.out.println("Please input the " + dimensionName + ": ");
        return keyboard.nextDouble();

    }

    private static void createRoom(){
        paintCalculator.addRoom(
                promptForDimension("length"),
                promptForDimension("width"),
                promptForDimension("height"));
    }

    private static void readFile(){

            try{
                FileInputStream in = new FileInputStream("rooms.obj");
                ObjectInputStream iin = new ObjectInputStream(in);
                paintCalculator = (PaintCalculator)iin.readObject();
                System.out.println("\nFile Read Successfully\n");

                iin.close();
            }
            catch(IOException | ClassNotFoundException i){
                System.out.println("\nNo rooms added yet\n");
            }
    }

    private static void writeFile(){
        try{

            FileOutputStream os = new FileOutputStream("rooms.obj");
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(paintCalculator);
            System.out.println("\nFile Write Successful\n");


            oos.close();
        }
        catch(IOException error){
            System.out.println("\nCould not write to file\n");
        }

    }
}
