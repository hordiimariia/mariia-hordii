package com.epam.rd.autotasks;

import java.util.Scanner;

public class Average {
    public static int average(String numLine){
        int sum = 0;
        int average;
        String[] splitArray = numLine.split(" ");
        int[] numbersArr = new int[splitArray.length];

        for (int i = 0; i < splitArray.length; i++){
            numbersArr[i] = Integer.parseInt(splitArray[i]);
            sum+=numbersArr[i];
        }
        average = sum/(numbersArr.length-1);
        return average;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Use Scanner methods to read input
        String numbersLine = scanner.nextLine();
        System.out.println(average(numbersLine));
    }

}