package com.epam.mjc.nio;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class FileReader {

    public Profile getDataFromFile(File file) {
        try (Stream<String> fileLines = Files.lines(file.toPath())) {
            List<String> linesList = fileLines.collect(Collectors.toList());

            String name = linesList.get(0)
                    .replace("Name: ", "");

            int age = Integer.parseInt(linesList.get(1)
                    .replace("Age: ", ""));

            String email = linesList.get(2)
                    .replace("Email: ", "");

            long phoneNumber = Long.parseLong(linesList.get(3)
                    .replace("Phone: ", ""));

            return new Profile(name, age, email, phoneNumber);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
