package ReservationSystem.Admin;

import java.time.DayOfWeek;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Admin class to hold all Admin info privately
 */
public class Admin {
    private int adminId;
    private String adminName;
    private String adminSurname;
    private String adminLogin;
    private String adminPassword;
    private Map<DayOfWeek, List> mapOfDayAndHours = new HashMap<>();

    /**
     * Empty Admin constructor
     */
    public Admin() {
    }

    /**
     * Admin constructor
     *
     * @param adminId      - Admin ID - generated automatically
     * @param adminName    - Admin Name
     * @param adminSurname - Admin Surname
     */
    Admin(int adminId, String adminName, String adminSurname) {
        this.adminId = adminId;
        this.adminName = adminName;
        this.adminSurname = adminSurname;
    }

    /**
     * Admin constructor (FULL)
     *
     * @param adminId       - Admin ID - generated automatically
     * @param adminName     - Admin Name
     * @param adminSurname  - Admin Surname
     * @param adminLogin    - Login TODO - determine what login should look like
     * @param adminPassword Password TODO - determine the password rules
     */
    //TODO - ADD Privileges - SuperAdmin - Admin
    public Admin(int adminId, String adminName, String adminSurname, String adminLogin, String adminPassword) {
        this.adminId = adminId;
        this.adminName = adminName;
        this.adminSurname = adminSurname;
        this.adminLogin = adminLogin;
        this.adminPassword = adminPassword;
    }

    /**
     * Method to "Print" Admin info
     */
    @Override
    public String toString() {
        return "Admin={" +
                "adminId=" + adminId +
                ", adminName='" + adminName + '\'' +
                ", adminSurname='" + adminSurname + '\'' +
                ", adminLogin='" + adminLogin + '\'' +
                ", adminPassword='" + adminPassword + '\'' +
                "} WorkingDaysAndHours=" + mapOfDayAndHours + '\''
                ;
    }

    /**
     * Method to get Admin ID
     * * @return Admin ID
     */
    public int getAdminId() {
        return adminId;
    }

    /**
     * Method to get Admin Name
     *
     * @return Admin Name
     */
    public String getAdminName() {
        return adminName;
    }

    /**
     * Method to get Admin Surname
     *
     * @return Admin Surname
     */
    public String getAdminSurname() {
        return adminSurname;
    }

    /**
     * Method to get Admin Login
     *
     * @return Admin Login
     */

    public String getAdminLogin() {
        return adminLogin;
    }

    /**
     * Method to set Admin Login
     */
    public void setAdminLogin(String adminLogin) {
        this.adminLogin = adminLogin;
    }

    /**
     * Method to set Admin Password
     */
    public String getAdminPassword() {
        return adminPassword;
    }

    /**
     * Method to set Admin Password
     */
    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    /**
     * Method to get Admin Map of Day+Hours
     *
     * @return Admin Map of Day+Hours
     */
    //TODO is this needed?
    public Map<DayOfWeek, List> getMapOfDayAndHours() {
        return mapOfDayAndHours;
    }

    /**
     * Method to create a Map of Days And Hours
     *
     * @param dayOfWeek key - e.g. MONDAY
     * @param Hours     values e.g. "08:00","08:30"
     */
    public void setMapOfDayAndHours(DayOfWeek dayOfWeek, List Hours) {
        mapOfDayAndHours.put(dayOfWeek, Hours);
    }
}