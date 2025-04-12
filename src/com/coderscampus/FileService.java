package com.coderscampus;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileService {

    public String[] read(String filePath)  {
        int lineCount = 0;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            while (bufferedReader.readLine() != null) lineCount++;
        } catch (IOException e) {
            System.out.println("There was an error counting lines in " + filePath + " : " + e.getMessage());
        }

        String[] lines = new String[lineCount];
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            for (int i = 0; i < lineCount; i++) {
                lines[i] = bufferedReader.readLine();
            }
        } catch (IOException e) {
            System.out.println("There was an error reading lines in " + filePath + " : " + e.getMessage());
            throw new RuntimeException(e);
        }
        return lines;
    }
}
