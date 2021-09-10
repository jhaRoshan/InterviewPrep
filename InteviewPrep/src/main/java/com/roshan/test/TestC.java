package com.roshan.test;

public class TestC {

    public static void main(String[] args){

        int i = Integer.parseInt("1001", 2);
        System.out.println(i);

    }

    public static String convertToBase62(long binary){
        // variable to store the output of the
        // binaryToDecimal() method
        int decimalNumber = binaryToDecimal(binary , 10);

        // converting the integer to the desired
        // hex string using toHexString() method
        String hexNumber
                = Integer.toHexString(decimalNumber);

        // converting the string to uppercase
        // for uniformity
        hexNumber = hexNumber.toUpperCase();

        // returning the final hex string
        return hexNumber;
    }

    static int binaryToDecimal(long binary , int base)
    {

        // variable to store the converted
        // binary number
        int decimalNumber = 0, i = 0;

        // loop to extract the digits of the binary
        while (binary > 0) {

            // extracting the digits by getting
            // remainder on dividing by 10 and
            // multiplying by increasing integral
            // powers of 2
            decimalNumber
                    += Math.pow(2, i++) * (binary % 10);

            // updating the binary by eliminating
            // the last digit on division by 10
            binary /= 10;
        }

        // returning the decimal number
        return decimalNumber;
    }
}
