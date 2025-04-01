/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package toxmlconverter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Anton
 */
public class Application {

    
    public static void main(String[] args) throws FileNotFoundException, IOException, URISyntaxException {
        
        /*
        String fileIn="C:/Develop/ToXmlConverter/data/in_2.txt";
        String fileOu="c:/Develop/ToXmlConverter/data/out.xml";

        FileConverterService service = new FileConverterService(FileFormat.XML);
        service.convert(fileIn, fileOu); 
        
         */
        ui();
        
        
    }
    
    public static void ui() throws URISyntaxException, IOException{
    
        
        String defaultIn = System.getProperty("user.dir")+"/data/in_1.txt";
        String defaultOut = System.getProperty("user.dir")+"/data/out";
        
   
        Scanner scanner = new Scanner(System.in);

        // Step 1: file path
        System.out.println("Enter the file path to convert (default: " + defaultIn + "):");
        String filePath = scanner.nextLine();
        
        // Set the default file path if the user does not enter one
        if (filePath.trim().isEmpty()) {
            filePath = defaultIn;
        }
        System.out.println("You chose the file: " + filePath);

        // Step 2: Ask the user to choose the file format
        System.out.println("Choose the file format to convert to:");
        System.out.println("1. XML");
        System.out.println("2. JSON");

        int choice = scanner.nextInt();
        FileFormat fileFormat = null;

        switch (choice) {
            case 1:
                fileFormat = FileFormat.XML;
                break;
            case 2:
                fileFormat = FileFormat.JSON;
                break;
            default:
                System.out.println("Invalid choice. Defaulting to XML.");
                fileFormat = FileFormat.XML;
        }

        System.out.println("You chose to convert to " + fileFormat);

        // Step 3: continu?
        scanner.nextLine();
        System.out.println("Do you want to continue? (y/n):");
        String continueChoice = scanner.nextLine();

        if (continueChoice.equalsIgnoreCase("y")) {
            // Proceed with conversion (logic to be implemented)
            System.out.println("Starting the conversion...");
            
            
            FileConverterService service = new FileConverterService(fileFormat);
            service.convert(defaultIn, defaultOut);
            
            
            System.out.println("Conversion completed!");
            System.out.println("OUT: " +  defaultOut+ "." + fileFormat.toString());
            
            
        } else {
            System.out.println("Operation aborted. Exiting...");
        }

        scanner.close();
    
 
    }
    

    
}
