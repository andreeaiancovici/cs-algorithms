package arrays.mergeintervals;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.Assert.*;

/**
 * Question:
 * Given an array of intervals representing ‘N’ appointments,
 * find out if a person can attend all the appointments.
 * ---
 * Time Complexity: O(n * log(n))
 * Space Complexity: O(n)
 */
public class ConflictingAppointments {

    public static void main(String[] args) {
        assertFalse(canAttendAllAppointments(new int[][]{{1, 4}, {2, 5}, {7, 9}}));
        assertTrue(canAttendAllAppointments(new int[][]{{6, 7}, {2, 4}, {8, 12}}));
        assertFalse(canAttendAllAppointments(new int[][]{{4, 5}, {2, 3}, {3, 6}}));
    }

    private static boolean canAttendAllAppointments(int[][] appointments) {
        if (appointments == null || appointments.length == 0) return false;

        Arrays.sort(appointments, Comparator.comparing((appointment) -> appointment[0]));

        for (int i = 1; i < appointments.length; i++) {
            if (appointments[i][0] < appointments[i - 1][1]) return false;
        }

        return true;
    }
}
