package com.kanishkkikaksha.studentdata.example;

public class CountOne {
    public static void main(String[] args) {
        int[] nums = {11, 12, 13, 14, 15};

        String numString = "";

        for (int num : nums) {
            numString += String.valueOf(num);
        }

        System.out.println(numString);

        String[] numChars = numString.split("");

        int count = 0;
        for (String character : numChars) {
            if(character.equals("1")){
                count++;
            }
        }

        System.out.println(count);
    }
}
