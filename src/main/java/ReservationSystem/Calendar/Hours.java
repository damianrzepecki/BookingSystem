package ReservationSystem.Calendar;

import java.util.HashMap;
import java.util.Map;

/**
 * Hours Class to that Holds Map of Ints and their values (String) hours
 */
public class Hours {

    /**
     * Map of Ints and (String) Hours
     */
    //TODO Determine if there is no better way of adding hours at specific range,
    // and if not is the 30 minutes enough or  should it be 15 minutes
    private static Map<Integer, String> hoursIntToString;

    static {
        hoursIntToString = new HashMap<>();
        hoursIntToString.put(1, "8:00");
        hoursIntToString.put(2, "8:30");
        hoursIntToString.put(3, "9:00");
        hoursIntToString.put(4, "9:30");
        hoursIntToString.put(5, "10:00");
        hoursIntToString.put(6, "10:30");
        hoursIntToString.put(7, "11:00");
        hoursIntToString.put(8, "11:30");
        hoursIntToString.put(9, "12:00");
        hoursIntToString.put(10, "12:30");
        hoursIntToString.put(11, "13:00");
        hoursIntToString.put(12, "13:30");
        hoursIntToString.put(13, "14:00");
        hoursIntToString.put(14, "14:30");
        hoursIntToString.put(15, "15:00");
        hoursIntToString.put(16, "15:30");
        hoursIntToString.put(17, "16:00");
    }

    /**
     * Method to pick (String) Hour from given int
     *
     * @param x int key to pick String Value
     * @return String value e.g.
     */
    public String getHourString(int x) {
        if (hoursIntToString.containsKey(x)) {
            return hoursIntToString.get(x);
        }
        return null;
    }
}