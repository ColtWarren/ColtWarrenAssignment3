package com.coderscampus;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileService {
    public String[] readUserData(String filePath) throws IOException {
        int lineCount = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while (br.readLine() != null) lineCount++;
        }

        String[] lines = new String[lineCount];
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            for (int i = 0; i < lineCount; i++) {
                lines[i] = br.readLine();
            }
        }
        return lines;
    }
}
