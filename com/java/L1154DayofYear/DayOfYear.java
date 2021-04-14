package com.java.L1154DayofYear;

public class DayOfYear {
    public int dayOfTheYear(String date){
        int[] arr = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5,7));
        int day = Integer.parseInt(date.substring(8));

        for(int i = 0; i < month - 1; i++){
            day += arr[i];
        }

        return isLeapYear(year) ? ++day:day;
    }

    private boolean isLeapYear(int year){
        if(year % 4 == 0 && year % 100 != 0){
            return true;
        }
        else if(year % 100 == 0 && year % 400 == 0)
            return true;
        return false;
    }

    public static void main(String[] args) {
        String date = "2016-02-29";
        System.out.println(new DayOfYear().dayOfTheYear(date));
    }
}
