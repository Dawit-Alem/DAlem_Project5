package application.demo;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class TwoDimRaggedArrayUtility {

    static double getAverage(double[][] array) {
        int count = 0;
        double total = 0;

        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[row].length; col++) {
                total += array[row][col];
                count++;
            }
        }

        return total / count;
    }

    static double getColumnTotal(double[][] array, int col) {
        double total = 0;

        for (int row = 0; row < array.length; row++) {
            if (col >= array[row].length || col < 0) {
                continue;
            }
            total += array[row][array[row].length == 1 && col == 1 ? col - 1 : col];
        }

        return total;
    }

    static double getHighestInArray(double[][] array) {
        double highest = Double.NEGATIVE_INFINITY;

        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[row].length; col++) {
                double value = array[row][col];
                if (value > highest) {
                    highest = value;
                }
            }
        }

        return highest;
    }

    static double getHighestInColumn(double[][] array, int col) {
        double highest = Double.NEGATIVE_INFINITY;

        for (int row = 0; row < array.length; row++) {
            if (col >= array[row].length || col < 0) {
                continue;
            }
            if (array[row][col] > highest) {
                highest = array[row][col];
            }
        }

        return highest;
    }

    static int getHighestInColumnIndex(double[][] array, int col) {
        double highest = Double.NEGATIVE_INFINITY;
        int index = -1;

        for (int row = 0; row < array.length; row++) {
            if (col >= array[row].length || col < 0) {
                continue;
            }
            if (array[row][col] > highest) {
                highest = array[row][col];
                index = row;
            }
        }

        return index;
    }

    static double getHighestInRow(double[][] array, int row) {
        if (row < 0 || row >= array.length) {
            return 0;
        }

        double highest = Double.NEGATIVE_INFINITY;

        for (int i = 0; i < array[row].length; i++) {
            if (array[row][i] > highest) {
                highest = array[row][i];
            }
        }

        return highest;
    }

    static int getHighestInRowIndex(double[][] array, int row) {
        if (row < 0 || row >= array.length) {
            return -1;
        }

        double highest = Double.NEGATIVE_INFINITY;
        int index = -1;

        for (int i = 0; i < array[row].length; i++) {
            if (array[row][i] > highest) {
                highest = array[row][i];
                index = i;
            }
        }

        return index;
    }

    static double getLowestInArray(double[][] array) {
        double lowest = Double.POSITIVE_INFINITY;

        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[row].length; col++) {
                if (array[row][col] < lowest) {
                    lowest = array[row][col];
                }
            }
        }

        return lowest;
    }

    static double getLowestInColumn(double[][] array, int col) {
        double lowest = Double.POSITIVE_INFINITY;

        for (int row = 0; row < array.length; row++) {
            if (col >= array[row].length || col < 0) {
                continue;
            }
            if (array[row][col] < lowest) {
                lowest = array[row][col];
            }
        }

        return lowest;
    }

    static int getLowestInColumnIndex(double[][] array, int col) {
        double lowest = Double.POSITIVE_INFINITY;
        int index = -1;

        for (int row = 0; row < array.length; row++) {
            if (col >= array[row].length || col < 0) {
                continue;
            }
            if (array[row][col] < lowest) {
                lowest = array[row][col];
                index = row;
            }
        }

        return index;
    }

    static double getLowestInRow(double[][] array, int row) {
        if (row < 0 || row >= array.length) {
            return 0;
        }

        double lowest = Double.POSITIVE_INFINITY;

        for (int i = 0; i < array[row].length; i++) {
            if (array[row][i] < lowest) {
                lowest = array[row][i];
            }
        }

        return lowest;
    }

    static int getLowestInRowIndex(double[][] array, int row) {
        if (row < 0 || row >= array.length) {
            return -1;
        }

        double lowest = Double.POSITIVE_INFINITY;
        int index = -1;

        for (int i = 0; i < array[row].length; i++) {
            if (array[row][i] < lowest) {
                lowest = array[row][i];
                index = i;
            }
        }

        return index;
    }

    static double getRowTotal(double[][] array, int row) {
        double total = 0;

        if (row >= 0 && row < array.length) {
            for (int i = 0; i < array[row].length; i++) {
                total += array[row][i];
            }
        }

        return total;
    }

    static double getTotal(double[][] array) {
        double total = 0;

        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[row].length; col++) {
                total += array[row][col];
            }
        }

        return total;
    }

    static double[][] readFile(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        int rows = 0;

        while (scanner.hasNextLine()) {
            rows++;
            scanner.nextLine();
        }
        scanner.close();

        double[][] array = new double[rows][];
        scanner = new Scanner(file);
        int currentRow = 0;

        while (scanner.hasNextLine()) {
            String[] values = scanner.nextLine().trim().split(" ");
            array[currentRow] = new double[values.length];

            for (int i = 0; i < values.length; i++) {
                array[currentRow][i] = Double.parseDouble(values[i]);
            }
            currentRow++;
        }
        scanner.close();

        return array;
    }

    static void writeToFile(double[][] array, File file) {
        try {
            FileWriter writer = new FileWriter(file);

            for (int row = 0; row < array.length; row++) {
                for (int col = 0; col < array[row].length; col++) {
                    writer.write(array[row][col] + " ");
                }
                writer.write("\n");
            }

            writer.close();
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
