package com.corecard.file_level.utils.firstOperations;

public class OperationsLinesTwo {

    public static String firstPartSplit(String line){
        return line.substring(0, 12);
    }

    public static String accountTokenSplit(String line){
        return line.substring(12, 29);
    }


    public static int findEndPosition(String line){
        return line.indexOf(" ", 29);
    }

    public static String secondNumberSplit(String line, int secondNumberPositionFinal){
        return line.substring(29, secondNumberPositionFinal);
    }


    public static String nameTokenSplit(String line, int secondNumberPositionFinal){
        return line.substring(secondNumberPositionFinal, line.length() - 16);
    }

    public static String finalNumberSplit(String line){
        return line.substring(line.length() - 16, line.length());
    }

    public static String leftPad(String input, int length, char padChar) {
        input = transformNullInput(input);
        return String.format("%" + length + "s", input).replace(' ', padChar);
    }

    public static String rightPad(String input, int length, char padChar) {
        input = transformNullInput(input);
        if (input.length() > length) return input.substring(0, length);
        return String.format("%-" + length + "s", input).replace(' ', padChar);
    }

    private static String transformNullInput(String input){
        if (input == null) {
            input = "";
        } else if (input.equals("null")) {
            input = "";
        }
        return input;
    }

    public static String substringFromFirstNonSpace(String line, int startPosition) {
        if (line == null || startPosition >= line.length()) {
            return "";
        }

        int index = startPosition;
        while (index < line.length() && line.charAt(index) == ' ') {
            index++;
        }

        return line.substring(index);
    }

    public static String substringUntilFirstSpaceTwo(String line, int startPosition) {

        int index = startPosition;
        while (index < line.length() && line.charAt(index) != ' ') {
            index++;
        }

        return line.substring(0,index);
    }

    public static int positionUntilFirstSpaceTwo(String line, int startPosition) {

        int index = startPosition;
        while (index < line.length() && line.charAt(index) != ' ') {
            index++;
        }

        return index;
    }


}
