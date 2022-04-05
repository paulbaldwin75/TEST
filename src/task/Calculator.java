package task;

import java.util.Scanner;

public class Calculator {
    static Scanner console = new Scanner(System.in);
    static String initialString;


    public static void main(String[] args) {
        initialString = console.nextLine();
        String[] parsedString = initialString.toUpperCase().split(" ");

        boolean firstRoman = Roman.isRoman(parsedString[0]);
        boolean isSecondRoman = Roman.isRoman(parsedString[2]);
        boolean isBothRoman = firstRoman && isSecondRoman;

        if ((firstRoman) && (!isSecondRoman) || (!firstRoman) && (isSecondRoman)) {
            throw new IllegalArgumentException();
        }
        if (isBothRoman) {
            parsedString[0] = String.valueOf(Roman.romanToArabic(parsedString[0]));
            parsedString[2] = String.valueOf(Roman.romanToArabic(parsedString[2]));
        }
        String result = calculate(parsedString);
        if (isBothRoman) {
            result = Roman.arabicToRoman(Integer.parseInt(result));
        }

        System.out.println(result);
    }

    private static String calculate(String[] parsedString) {

        if (parsedString.length != 3) {
            throw new IllegalArgumentException();
        }

        int firstValue = Integer.parseInt(parsedString[0]);
        int secondValue = Integer.parseInt(parsedString[2]);
        if (((firstValue < 1) || (firstValue > 10)) || ((secondValue < 1) || (secondValue > 10))) {
            throw new IllegalArgumentException();
        }

        int result;
        String operator = parsedString[1];

        switch (operator) {
            case ("+"):
                result = firstValue + secondValue;
                break;
            case ("-"):
                result = firstValue - secondValue;
                break;
            case ("*"):
                result = firstValue * secondValue;
                break;
            case ("/"):
                result = firstValue / secondValue;
                break;
            default:
                throw new IllegalArgumentException();
        }
        return String.valueOf(result);
    }
}


