package com.epam.training.javajunior.home_work1;

public class BitHandlerUtils {

    private BitHandlerUtils() {
    }

    private static final int LONG_BITS = 64;
    private static final int INT_BITS = 32;

    public static int binaryToDecimal(String binaryString) {
        if (binaryString == null || binaryString.isEmpty()) {
            throw new IllegalArgumentException("binaryString can not be null or empty");
        }
        int length = binaryString.length();
        if (length > INT_BITS) {
            throw new NumberFormatException("binaryString length: "
                    + length + " greater than " + INT_BITS);
        }
        for (int i = 0; i < length; i++) {
            if (binaryString.charAt(i) != '0' && binaryString.charAt(i) != '1') {
                throw new NumberFormatException("binaryString can not contain char: " + binaryString.charAt(i));
            }
        }
        int decimal = 0;
        boolean negative = (length == INT_BITS && binaryString.charAt(0) == '1');
        for (int i = 0; i < length; i++) {
            int bit;
            if (negative) {
                bit = Character.getNumericValue(binaryString.charAt((length - 1) - i) == '0' ? '1' : '0');
            } else {
                bit = Character.getNumericValue(binaryString.charAt((length - 1) - i));
            }
            decimal += bit * Math.pow(2, i);
        }
        return negative ? -(decimal + 1) : decimal;
    }

    public static int changeSign(int variable) {
        return (~variable) + 1;
    }

    public static int countUsedBits(char value) {
        return countPositiveValueBits(value);
    }

    public static int countUsedBits(short value) {
        int bits = 0;
        if (value < 0) {
            value ^= Short.MIN_VALUE;
            bits++;
        }
        return bits + countPositiveValueBits(value);
    }

    public static int countUsedBits(int value) {
        int bits = 0;
        if (value < 0) {
            value ^= Integer.MIN_VALUE;
            bits++;
        }
        return bits + countPositiveValueBits(value);
    }

    public static int countUsedBits(long value) {
        int bits = 0;
        if (value < 0) {
            value ^= Long.MIN_VALUE;
            bits++;
        }
        return bits + countPositiveValueBits(value);
    }

    private static int countPositiveValueBits(long num) {
        if (num == 0) {
            return 0;
        }
        for (int i = 1; i <= LONG_BITS; i++) {
            if ((num >>= 1) == 0) {
                return i;
            }
        }
        return -1;
    }

    public static int greaterCommonDivisor(int firstNum, int secondNum) {
        while (firstNum != secondNum) {
            if (firstNum > secondNum) {
                firstNum = subtract(firstNum, secondNum);
            } else {
                secondNum = subtract(secondNum, firstNum);
            }
        }
        return firstNum;
    }

    private static int subtract(int x, int y) {
        while (y != 0) {
            int borrow = (~x) & y;
            x = x ^ y;
            y = borrow << 1;
        }
        return x;
    }

    //bitIndex - starting from 0 to 31
    //bitSetTo true - 1, false - 0
    public static int setBit(int variable, int pos, boolean bitSetTo) {
        if (pos >= INT_BITS) {
            throw new IllegalArgumentException("bitIndex must bee less than " + INT_BITS);
        }
        int mask = 1;
        for (int i = 0; i < pos; i++) {
            mask <<= 1;
        }
        if (bitSetTo) {
            return variable | mask;
        } else {
            return variable & ~mask;
        }
    }
}
