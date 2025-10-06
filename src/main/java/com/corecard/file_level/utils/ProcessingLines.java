package com.corecard.file_level.utils;

import com.corecard.file_level.model.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class ProcessingLines {

    public static List<String> readingLines(Path file1) throws IOException {
        return Files.lines(file1)
                .map(String::valueOf)
                .collect(Collectors.toList());
    }

    public static Structure splitingLines(List<String> file1) {

        String primaryNumber = file1.get(1).substring(0, 12);

        System.out.println("primaryNumber: " + primaryNumber);

        String accountTokenEncrypted = file1.get(1).substring(12, 29);

        System.out.println("accountTokenEncrypted: " + accountTokenEncrypted);

        int secondNumberPositionFinal = file1.get(1).indexOf(" ", 29);
        String secondNumber = file1.get(1).substring(29, secondNumberPositionFinal);

        System.out.println("secondNumber: " + secondNumber);

        String nameToken = file1.get(1).substring(39, file1.get(1).length() - 16);

        System.out.println("nameToken: " + nameToken);

        String finalNumber = file1.get(1).substring(file1.get(0).length() - 20, file1.get(1).length());

        System.out.println("finalNumber: " + finalNumber);

        LineA2 lineA2 = LineA2.builder()
                .primaryNumber(primaryNumber)
                .accountTokenEncrypted(accountTokenEncrypted)
                .secondNumber(secondNumber)
                .nameToken(nameToken)
                .finalNumber(finalNumber)
                .build();

        return Structure.builder()
                .lineA2(lineA2).build();

    }
}
