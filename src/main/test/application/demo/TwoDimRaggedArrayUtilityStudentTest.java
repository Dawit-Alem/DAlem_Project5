package application.demo;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class TwoDimRaggedArrayUtilityStudentTest {

    @Test
    void getAverage() {
        double[][] array = {
                {1.0, 2.0, 3.0},
                {4.0, 5.0},
                {6.0}
        };
        assertEquals(3.5, TwoDimRaggedArrayUtility.getAverage(array), 0.001);
    }

    @Test
    void getColumnTotal() {
        double[][] array = {
                {1.0, 2.0, 3.0},
                {4.0, 5.0},
                {6.0}
        };
        assertEquals(11.0, TwoDimRaggedArrayUtility.getColumnTotal(array, 0), 0.001);
    }

    @Test
    void getHighestInArray() {
        double[][] array = {
                {1.0, 2.0, 3.0},
                {4.0, 5.0},
                {6.0}
        };
        assertEquals(6.0, TwoDimRaggedArrayUtility.getHighestInArray(array), 0.001);
    }

    @Test
    void getHighestInColumn() {
        double[][] array = {
                {1.0, 2.0, 3.0},
                {4.0, 5.0},
                {6.0}
        };
        assertEquals(6.0, TwoDimRaggedArrayUtility.getHighestInColumn(array, 0), 0.001);
    }

    @Test
    void getHighestInColumnIndex() {
        double[][] array = {
                {1.0, 2.0, 3.0},
                {4.0, 5.0},
                {6.0}
        };
        assertEquals(2, TwoDimRaggedArrayUtility.getHighestInColumnIndex(array, 0));
    }

    @Test
    void getHighestInRow() {
        double[][] array = {
                {1.0, 2.0, 3.0},
                {4.0, 5.0},
                {6.0}
        };
        assertEquals(5.0, TwoDimRaggedArrayUtility.getHighestInRow(array, 1), 0.001);
    }

    @Test
    void getHighestInRowIndex() {
        double[][] array = {
                {1.0, 2.0, 3.0},
                {4.0, 5.0},
                {6.0}
        };
        assertEquals(1, TwoDimRaggedArrayUtility.getHighestInRowIndex(array, 1));
    }

    @Test
    void getLowestInArray() {
        double[][] array = {
                {1.0, 2.0, 3.0},
                {4.0, 5.0},
                {6.0}
        };
        assertEquals(1.0, TwoDimRaggedArrayUtility.getLowestInArray(array), 0.001);
    }

    @Test
    void getLowestInColumn() {
        double[][] array = {
                {1.0, 2.0, 3.0},
                {4.0, 5.0},
                {6.0}
        };
        assertEquals(1.0, TwoDimRaggedArrayUtility.getLowestInColumn(array, 0), 0.001);
    }

    @Test
    void getLowestInColumnIndex() {
        double[][] array = {
                {1.0, 2.0, 3.0},
                {4.0, 5.0},
                {6.0}
        };
        assertEquals(0, TwoDimRaggedArrayUtility.getLowestInColumnIndex(array, 0));
    }

    @Test
    void getLowestInRow() {
        double[][] array = {
                {1.0, 2.0, 3.0},
                {4.0, 5.0},
                {6.0}
        };
        assertEquals(4.0, TwoDimRaggedArrayUtility.getLowestInRow(array, 1), 0.001);
    }

    @Test
    void getLowestInRowIndex() {
        double[][] array = {
                {1.0, 2.0, 3.0},
                {4.0, 5.0},
                {6.0}
        };
        assertEquals(0, TwoDimRaggedArrayUtility.getLowestInRowIndex(array, 1));
    }

    @Test
    void getRowTotal() {
        double[][] array = {
                {1.0, 2.0, 3.0},
                {4.0, 5.0},
                {6.0}
        };
        assertEquals(9.0, TwoDimRaggedArrayUtility.getRowTotal(array, 1), 0.001);
    }

    @Test
    void getTotal() {
        double[][] array = {
                {1.0, 2.0, 3.0},
                {4.0, 5.0},
                {6.0}
        };
        assertEquals(21.0, TwoDimRaggedArrayUtility.getTotal(array), 0.001);
    }

    @Test
    void readFile() throws IOException {
        File file = new File("testfile.txt");
        file.createNewFile();
        TwoDimRaggedArrayUtility.writeToFile(new double[][]{{1.0, 2.0}, {3.0}}, file);
        double[][] result = TwoDimRaggedArrayUtility.readFile(file);
        assertArrayEquals(new double[][]{{1.0, 2.0}, {3.0}}, result);
        file.delete();
    }

    @Test
    void writeToFile() throws IOException {
        File file = new File("testfile.txt");
        TwoDimRaggedArrayUtility.writeToFile(new double[][]{{1.0, 2.0}, {3.0}}, file);
        assertTrue(file.exists());
        double[][] result = TwoDimRaggedArrayUtility.readFile(file);
        assertArrayEquals(new double[][]{{1.0, 2.0}, {3.0}}, result);
        file.delete();
    }
}
