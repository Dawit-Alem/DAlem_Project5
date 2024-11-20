package application.demo;

/*
 Class: CMSC 203 CRN 22824
 Program: Assignment #5
 Instructor: Prof. Ahmed Tarek
 Summary of Description: Sales Report
 Due Date: 11/19/2024
 Integrity Pledge: I pledge that I have completed the programming assignment independently.
 I have not copied the code from a student or any source.
 Student’s Name: Dawit Alem
 */

public class HolidayBonus {
    public static double[] calculateHolidayBonus(double[][] a, double h, double l, double o) {
        double[] result = new double[a.length];
        double lowest = -1;
        int lowestIndex = -1;
        double highest = -1;
        int highestIndex = -1;

        for (int r = 0; r < a.length; r++) {
            double total = 0;

            for (int c = 0; c < a[r].length; c++) {
                total += a[r][c];
            }

            if (lowest == -1 || total < lowest) {
                lowest = total;
                lowestIndex = r;
            }
            if (highest == -1 || highest < total) {
                highest = total;
                highestIndex = r;
            }
        }
        for (int r = 0; r < a.length; r++) {
            if (r == lowestIndex) {
                result[r] = l;
                continue;
            }
            if (r == highestIndex) {
                result[r] = h;
                continue;
            }

            result[r] = o;
        }

        return result;
    }

    public static double calculateTotalHolidayBonus(double[][] a, double h, double l, double o) {
        double total = 0;
        double[] bonus = HolidayBonus.calculateHolidayBonus(a, h, l, 0);

        for (int i = 0; i < bonus.length; i++) {
            total += bonus[i];
        }

        return total;
    }

    public static double calculateTotalHolidayBonus(double[][] sales) {
        return calculateTotalHolidayBonus(sales, 1000, 500, 200); // Default bonus values
    }

    public static double[] calculateHolidayBonus(double[][] sales) {
        return calculateHolidayBonus(sales, 1000, 500, 200);
    }

}

