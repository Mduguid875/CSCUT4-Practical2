import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.lang.Number;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.*;
import java.util.*;

/**
 * CSCU9T4 Java strings and files exercise.
 *
 */
public class FilesInOut {

    public static void main(String[] args) {
        // Initializing String for input and formatted files
        String inputFile = "input.txt";
        String outputFile = "formatted.txt";
        boolean isUpperCase = false;

        // Parsing the command line
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-u")) {
                isUpperCase = true;
            } else if (inputFile == null) {
                inputFile = args[i];
            } else if (outputFile == null) {
                outputFile = args[i];
            }
        }

        // Arguements are checked for correct areguements
        if (inputFile == null || outputFile == null) {
            System.err.println("Usage: java FilesInOut [-u] inputfile outputfile");
            System.exit(1);
        }

        // Input files processed and written onto the output
        try (Scanner sc = new Scanner(new File(inputFile));
             PrintWriter writer = new PrintWriter(outputFile)) {

            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                if (!line.isEmpty()) {
                    String[] parts = line.split(" ");
                    String formatName = formatName(parts[0]) + " " + formatName(parts[1]);
                    String formatDate = formatDate(parts[2]);
                    if (isUpperCase) {
                        writer.println(formatName.toUpperCase() + " " + formatDate);
                    } else {
                        writer.println(formatName + " " + formatDate);
                    }
                }
            }

        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
    }


    /**
     * Format a date from "ddmmyyyy" to "dd/mm yyyy".
     *
     * @param date Date to be formatted.
     * @return Formatted date.
     */
    public static String formatDate(String date) {
        return date.substring(0, 2) + "/" + date.substring(2, 4) + " " + date.substring(4);
    }

    /**
     * Formats the title case.
     *
     * @param name Name to be formatted.
     * @return Formatted name.
     */
    public static String formatName(String name) {
        return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();

    } // main

} // FilesInOut

