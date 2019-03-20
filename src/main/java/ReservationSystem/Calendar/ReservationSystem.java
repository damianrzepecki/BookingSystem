package ReservationSystem.Calendar;

import ReservationSystem.Admin.Admin;
import ReservationSystem.Admin.AdminControls;
import ReservationSystem.Client.ClientControl;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 * class for the Reservation System where all the magic happens
 * (mainly a map of Name_Surname_Day_Hour as a value and client Name_Surname as A Key
 */
public class ReservationSystem {
    private AdminControls adminControls;
    private ClientControl clientControl;
    private Map<String, String> reservationSystemMap = new HashMap<>();


    /**
     * Method to "Print" the reservation Map key=value
     */
    public void getReservationSystemMap() {
        reservationSystemMap.entrySet().forEach(System.out::println);
    }

    /**
     * Constructor to "control" Admins and Clients
     *
     * @param adminControls - admin control class
     * @param clientControl - client control class
     */
    public ReservationSystem(AdminControls adminControls, ClientControl clientControl) {
        this.adminControls = adminControls;
        this.clientControl = clientControl;
    }

    /**
     * Method to create reservation Map
     *
     * @param clientId -Client ID
     * @param adminId  - Doctor ID
     * @param year     - year of the reservation
     * @param month    - month of the reservation
     * @param day      - day of the reservation
     * @param hourSlot - hour slot (int)
     *                 <p>
     *                 TODO - when there will be a GUI ideally this should work like a calendar with a drop down menu
     */
    public void addClientToAdminSlot(int clientId, int adminId, int year, int month, int day, int hourSlot) {
        if (checkIfAdminWorksThatDayAtThatHour(adminId, year, month, day, hourSlot)) {
            reservationSystemMap.put(reservationSystemMapKey(adminId, year, month, day, hourSlot), reservationSystemMapValue(clientId));
        }
    }

    /**
     * Method to check if the slot of the reservation is taken or is it free
     * TODO - sout - message if its already occupied (popup??)
     *
     * @param adminId  - Admin ID
     * @param year     - Year
     * @param month    - Month
     * @param day      - Day
     * @param hourSlot - hour Slot
     * @return boolean - true if its available
     */
    private boolean checkIfAdminWorksThatDayAtThatHour(int adminId, int year, int month, int day, int hourSlot) {
        return adminControls.findAdminByID(adminId).getMapOfDayAndHours().get(LocalDate.of(year, month, day).getDayOfWeek()).contains(adminControls.whatHourIsIt(hourSlot));
    }

    /**
     * Method to create a Key for our Map
     *
     * @param adminId  - Admin ID
     * @param year     - Year
     * @param month    - Month
     * @param day      - Day
     * @param hourSlot - hour Slot
     * @return - (String) created key
     */
    private String reservationSystemMapKey(int adminId, int year, int month, int day, int hourSlot) {
        Admin admin = adminControls.findAdminByID(adminId);
        return admin.getAdminName() + " "
                + admin.getAdminSurname() + " " +
                LocalDate.of(year, month, day).getDayOfWeek() + " " +
                adminControls.whatHourIsIt(hourSlot);
    }

    /**
     * Method to create Value for reservation map
     *
     * @param clientId - clients ID
     * @return (String) created value
     */
    private String reservationSystemMapValue(int clientId) {
        return clientControl.getClientById(clientId).getClientName() + " "
                + clientControl.getClientById(clientId).getClientSurname();
    }
}
//TODO - S/ Show reservation of Single Admin / Remove Reservation / Change Reservation Date/Day/Hour // Show reservations of all admins