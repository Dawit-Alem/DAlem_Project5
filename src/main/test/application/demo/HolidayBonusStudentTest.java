package application.demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HolidayBonusStudentTest {

    @Test
    void calculateHolidayBonus() {
        double[][] sales = {
                {100, 200, 300},   // Total: 600 (Highest)
                {50, 50},          // Total: 100 (Lowest)
                {150, 150, 150}    // Total: 450 (Other)
        };

        double[] expected = {1000, 500, 200};
        double[] actual = HolidayBonus.calculateHolidayBonus(sales, 1000, 500, 200);

        assertArrayEquals(expected, actual, "Holiday bonuses are not calculated correctly");
    }

    @Test
    void calculateTotalHolidayBonus() {
        double[][] sales = {
                {100, 200, 300},   // Total: 600 (Highest)
                {50, 50},          // Total: 100 (Lowest)
                {150, 150, 150}    // Total: 450 (Other)
        };

        double expected = 1000 + 500 + 200; // Sum of bonuses
        double actual = HolidayBonus.calculateTotalHolidayBonus(sales, 1000, 500, 200);

        assertEquals(expected, actual, "Total holiday bonuses are not calculated correctly");
    }

    @Test
    void testCalculateTotalHolidayBonus() {
        double[][] sales = {
                {100, 200, 300},
                {50, 50},
                {150, 150, 150}
        };

        // Test with default bonus values
        double expected = 1000 + 500 + 200;
        double actual = HolidayBonus.calculateTotalHolidayBonus(sales);

        assertEquals(expected, actual, "Total holiday bonuses with default values are not calculated correctly");
    }

    @Test
    void testCalculateHolidayBonus() {
        double[][] sales = {
                {300, 300},   // Total: 600 (Highest)
                {100, 100},   // Total: 200 (Lowest)
                {200, 200}    // Total: 400 (Other)
        };

        // Test with default bonus values
        double[] expected = {1000, 500, 200};
        double[] actual = HolidayBonus.calculateHolidayBonus(sales);

        assertArrayEquals(expected, actual, "Holiday bonuses with default values are not calculated correctly");
    }

    @Test
    void calculateHolidayBonusEdgeCases() {
        // Empty sales array
        double[][] emptySales = {};
        double[] expectedEmpty = {};
        assertArrayEquals(expectedEmpty, HolidayBonus.calculateHolidayBonus(emptySales, 1000, 500, 200),
                "Bonus for empty array should be empty");

        // One row sales array
        double[][] singleRowSales = {{100, 200, 300}};
        double[] expectedSingleRow = {1000}; // Highest and only row
        assertArrayEquals(expectedSingleRow, HolidayBonus.calculateHolidayBonus(singleRowSales, 1000, 500, 200),
                "Bonus for single row should be highest bonus");
    }
}
