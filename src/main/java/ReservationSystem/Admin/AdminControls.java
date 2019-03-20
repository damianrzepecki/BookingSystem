package ReservationSystem.Admin;

import ReservationSystem.Calendar.Hours;

import java.time.DayOfWeek;
import java.util.*;

/**
 * AdminControl class to Set and Get single Admin data
 * And work with that Data
 */
public class AdminControls {
    private List<Admin> adminList = new ArrayList<>();
    private int adminId = 0;
    private Hours hours = new Hours();

    /**
     * Creates new Admin user with (adminID+1)
     *
     * @param adminName    - Admins name
     * @param adminSurname - Admins surname
     */
    public void createNewAdmin(String adminName, String adminSurname) {
        adminId++;
        Admin admin = new Admin(adminId, adminName, adminSurname);
        adminList.add(admin);
    }

    /**
     * "Prints" all created Admins
     */
    public void showAllAdmins() {
        for (Admin admin : adminList) {
            System.out.println(admin);
        }
    }

    /**
     * Method to add working hours to each doctor at given day
     *
     * @param adminId   ID - of the Admin
     * @param dayOfWeek - day of week determined by main (int)
     * @param hourStart - Starting hours taken from Hour class(Map in there binds int to String (example 1 = "08:00")
     * @param hourEnd   - Ending hours taken from Hour class(Map in there binds int to String (example 1 = "08:00")
     */
    //TODO - Determine if adding hours from outside the range
    // example Monday 08:00-10:00 added 09:00-10:30)
    // should add 1030 to list or ask if this is intentional (permanent)
    public void addDayToAdmin(int adminId, int dayOfWeek, int hourStart, int hourEnd) {
        if (hourStart <= hourEnd) { //if statement added to prevent adding hours in wrong order
            Objects.requireNonNull(
                    findAdminByID(adminId)).setMapOfDayAndHours(
                    DayOfWeek.of(dayOfWeek), setListOfHours(hourStart, hourEnd));
        }
    }

    /**
     * Method to create List containing hours (String)
     *
     * @param hourStart Starting Hour
     * @param hourEnd   - Ending hour
     * @return list of hours
     */
    private List setListOfHours(int hourStart, int hourEnd) {
        List<String> listOfHours = new ArrayList<>();
        for (int i = hourStart; i <= hourEnd; i++) {
            listOfHours.add(hours.getHourString(i));
        }
        return listOfHours;
    }

    /**
     * Method to find Admin By Id
     *
     * @param adminId - given Admin ID
     * @return admin from Admin class
     */
    public Admin findAdminByID(int adminId) {
        for (Admin admin : adminList) {
            if (admin.getAdminId() == adminId) {
                return admin;
            }
        }
        return null;
    }

    /**
     * Method to replace whole hours in a given day
     * TODO - What will happen if that day wont exist - should it be concerned as a problem
     *
     * @param adminId   - Admin ID
     * @param dayOfWeek - Day of week in (int)
     * @param hourStart - Starting hours int - to String
     * @param hourEnd   - Ending hours int - to String
     */
    public void replaceWorkingHoursInGivenDay(int adminId, int dayOfWeek, int hourStart, int hourEnd) {
        if (hourStart <= hourEnd) {
            removeHoursFromGivenDay(adminId, dayOfWeek);
            addDayToAdmin(adminId, dayOfWeek, hourStart, hourEnd);
        }
    }

    /**
     * Method to leave empty day TODO-determine if it should remove even the day itself
     *
     * @param adminId   - Admin ID
     * @param dayOfWeek - Day of Week in (int)
     */
    private void removeHoursFromGivenDay(int adminId, int dayOfWeek) {
        Objects.requireNonNull(findAdminByID(adminId)).getMapOfDayAndHours().get(DayOfWeek.of(dayOfWeek)).clear();
    }

    /**
     * Method that shows Name+Surname od an Admin and days+hours
     * TODO - determine if it shouldn't return A list like "MONDAY: first hour - last hour" not a full hour map
     *
     * @param adminId - Given Admin ID
     */
    public void showAdminWorkingDaysHours(int adminId) {
        System.out.print(
                Objects.requireNonNull(findAdminByID(adminId)).getAdminName() + " " +
                        Objects.requireNonNull(findAdminByID(adminId)).getAdminSurname() + " Pacuje w:");
        System.out.println(Objects.requireNonNull(findAdminByID(adminId)).getMapOfDayAndHours());
    }

    /**
     * Method to show what doctors works in a given Day of Week
     *
     * @param dayOfWeek - Day of Week
     */
    public void showWhatAdminsWorkInAGivenDay(int dayOfWeek) {
        System.out.println("W " + DayOfWeek.of(dayOfWeek));
        for (Admin admin : adminList) {
            if (admin.getMapOfDayAndHours().containsKey(DayOfWeek.of(dayOfWeek))) {
                System.out.println("Pracuje " + admin.getAdminName() + " " + admin.getAdminSurname());
            } else System.out.println("Nikt nie pracuje");
        }
    }

    /**
     * Method created for the ReservationSystem class to get the String value of hours from Hours Class
     *
     * @param hourSlot int value of Hours
     * @return String Value of Hours
     */
    public String whatHourIsIt(int hourSlot) {
        return hours.getHourString(hourSlot);
    }
}