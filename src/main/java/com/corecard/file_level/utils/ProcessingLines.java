package com.corecard.file_level.utils;

import com.corecard.file_level.model.*;
import org.apache.logging.log4j.util.Strings;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.corecard.file_level.utils.firstOperations.OperationsLinesOne.*;
import static com.corecard.file_level.utils.firstOperations.OperationsLinesTwo.positionUntilFirstSpaceTwo;
import static com.corecard.file_level.utils.firstOperations.OperationsLinesTwo.substringUntilFirstSpaceTwo;

public class ProcessingLines {

    public static List<String> readingLines(Path file1) throws IOException {
        return Files.lines(file1)
                .map(String::valueOf)
                .collect(Collectors.toList());
    }

    public static Structure splitingLines(List<String> file1) {
        String primaryNumber = Strings.EMPTY;
        String accountTokenEncrypted = Strings.EMPTY;
        int secondNumberPositionFinal = 0;
        String secondNumber = Strings.EMPTY;
        String nameToken = Strings.EMPTY;
        String finalNumber = Strings.EMPTY;
        String resultChain = Strings.EMPTY;
        int firstSpace = 0;

        ArrayList<String> primaryNumberList = new ArrayList<>();
        ArrayList<String> accountTokenEncryptedList = new ArrayList<>();
        ArrayList<String> secondNumberList = new ArrayList<>();
        ArrayList<String> nameTokenList = new ArrayList<>();
        ArrayList<String> finalNumberList = new ArrayList<>();

        for (int x=1; x<=4; x++) {
            primaryNumber = primarySplit(file1.get(x));
            System.out.println("primaryNumber: "  + "line " + x + ": " + primaryNumber);
            accountTokenEncrypted = accountTokenSplit(file1.get(x));
            System.out.println("accountTokenEncrypted: "  + "line " + x + ": " + accountTokenEncrypted);
            secondNumberPositionFinal = findEndPosition(file1.get(x));
            secondNumber = secondNumberSplit(file1.get(x), secondNumberPositionFinal);
            secondNumber = rightPad(secondNumber, secondNumber.length()+11, '*');
            System.out.println("secondNumber: "  + "line " + x + ": " + secondNumber);
            firstSpace = substringUntilFirstSpace(file1.get(x), 0);
            resultChain = substringFromFirstNonSpace(file1.get(x), firstSpace);

            nameToken = nameTokenSplit(file1.get(x), secondNumberPositionFinal);
            System.out.println("nameToken: "  + "line " + x + ": " + nameToken);
            finalNumber = finalNumberSplit(file1.get(x));
            System.out.println("finalNumber " + "line " + x + ": " + finalNumber);

            primaryNumberList.add(primaryNumber);
            accountTokenEncryptedList.add(accountTokenEncrypted);
            secondNumberList.add(secondNumber);
            nameTokenList.add(nameToken);
            finalNumberList.add(finalNumber);

        }

        LineBody lineBody = LineBody.builder()
                .primaryNumber(primaryNumberList)
                .accountTokenEncrypted(accountTokenEncryptedList)
                .secondNumber(secondNumberList)
                .nameToken(nameTokenList)
                .finalNumber(finalNumberList)
                .build();

        return Structure.builder()
                .lineBody(lineBody).build();

    }

    public static Structure splitInTwoTheLines(List<String> file1) {
        String primaryPart = Strings.EMPTY;
        String secondPart = Strings.EMPTY;
        int middlePartPositionFinal = 0;

        ArrayList<String> primaryPartList = new ArrayList<>();
        ArrayList<String> secondPartList = new ArrayList<>();


        for (int x=1; x<=4; x++) {
            primaryPart = substringUntilFirstSpaceTwo(file1.get(x), 0);
            System.out.println("primaryPart: "  + "line " + x + ": " + primaryPart);
            middlePartPositionFinal = positionUntilFirstSpaceTwo(file1.get(x), 0);
            secondPart = file1.get(x).substring(middlePartPositionFinal, file1.get(x).length());
            System.out.println("secondPart: "  + "line " + x + ": " + secondPart);

            primaryPartList.add(primaryPart);
            secondPartList.add(secondPart);

        }

        LineSplitedBody lineSplitedBody = LineSplitedBody.builder()
                .primaryPart(primaryPartList)
                .secondPart(secondPartList)
                .build();

        Structure structure = Structure.builder()
                .lineSplitedBody(lineSplitedBody).build();

        System.out.println(structure.toString());

        return structure;

    }

}
