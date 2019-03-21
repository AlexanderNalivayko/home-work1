package com.epam.training.javajunior.home_work1;

import java.util.Scanner;

import static com.epam.training.javajunior.home_work1.BitHandlerUtils.*;

public class Runner {
    public static void main(String[] args) {

        //1
        String binaryString = getBinaryStringFromConsole();
        print("binary number", binaryString, "int", binaryToDecimal(binaryString));

        //2
        int positiveInt = 48;
        int negativeInt = -123;

        print("number", positiveInt, "changed sign number", changeSign(positiveInt));
        print("number", negativeInt, "changed sign number", changeSign(negativeInt));

        //3
        char charNumber = 11;
        short positiveShort = 43;
        short negativeShort = -31000;
        long positiveLong = 85489498498L;
        long negativeLong = -984869486468L;

        print("number", (short) charNumber, "bits needed to store value", countUsedBits(charNumber));
        print("number", positiveShort, "bits needed to store value", countUsedBits(positiveShort));
        print("number", negativeShort, "bits needed to store value", countUsedBits(negativeShort));
        print("number", positiveInt, "bits needed to store value", countUsedBits(positiveInt));
        print("number", negativeInt, "bits needed to store value", countUsedBits(negativeInt));
        print("number", positiveLong, "bits needed to store value", countUsedBits(positiveLong));
        print("number", negativeLong, "bits needed to store value", countUsedBits(negativeLong));

        //4
        int firstNum = 21;
        int secondNum = 27;
        int thirdNum = 34;
        int fourthNum = 17;

        print("numbers", firstNum + ", " + secondNum, "gcd", greaterCommonDivisor(firstNum, secondNum));
        print("numbers", thirdNum + ", " + fourthNum, "gcd", greaterCommonDivisor(thirdNum, fourthNum));

        //5
        print("before bit set", 1, "after bit set", setBit(1, 3, true));
        print("before bit set", -1, "after bit set", setBit(-1, 31, false));
    }

    public static <T> void print(T firstNumName, T firstNum, T secondNumName, T SecondNum) {
        System.out.printf("%s: %s | %s: %s%n", firstNumName, firstNum, secondNumName, SecondNum);
    }

    public static String getBinaryStringFromConsole() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Please enter bits, and press 'Enter':");
            return scanner.nextLine();
        }
    }
}
