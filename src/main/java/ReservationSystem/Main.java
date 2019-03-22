package ReservationSystem;

import ReservationSystem.Admin.AdminControls;
import ReservationSystem.Calendar.ReservationSystem;
import ReservationSystem.Client.ClientControl;

public class Main {
    public static void main(String[] args) {
        AdminControls adminControls = new AdminControls();
        adminControls.createNewAdmin("Admin1Name", "Admin1Surname");
        adminControls.createNewAdmin("Admin2Name", "Admin2Surname");
        adminControls.showAllAdmins();
        System.out.println("========================");
        ClientControl clientControl = new ClientControl();
        clientControl.createNewClient("Client1Name", "Client1Surname");
        clientControl.createNewClient("Client2Name", "Client2Surname");
        clientControl.showAllClients();
        System.out.println("========================");
        adminControls.addDayToAdmin(1, 1, 1, 1);
        adminControls.addDayToAdmin(1, 1, 1, 5);
        adminControls.addDayToAdmin(1, 2, 1, 2);
        adminControls.addDayToAdmin(2, 1, 1, 2);
        adminControls.addDayToAdmin(2, 2, 1, 2);
        adminControls.showAllAdmins();
        System.out.println("========================");
        adminControls.replaceWorkingHoursInGivenDay(1, 1, 6, 9);
        adminControls.showAllAdmins();
        System.out.println("========================");
        adminControls.showAdminWorkingDaysHours(1);
        System.out.println("========================");
        adminControls.showWhatAdminsWorkInAGivenDay(1);
        adminControls.showWhatAdminsWorkInAGivenDay(5);
        System.out.println("========================");
        ReservationSystem reservationSystem = new ReservationSystem(adminControls,clientControl);
        reservationSystem.addClientToAdminSlot(1,1,2019,3,18,6);
        reservationSystem.addClientToAdminSlot(2,1,2019,3,18,7);
        reservationSystem.addClientToAdminSlot(1,1,2019,3,18,8);
        reservationSystem.addClientToAdminSlot(1,1,2019,3,18,9);
        reservationSystem.getReservationSystemMap();
        System.out.println("========================");
        clientControl.showAllClients();
    }

}