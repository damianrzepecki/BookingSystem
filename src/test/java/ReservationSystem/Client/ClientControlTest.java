package ReservationSystem.Client;

import org.junit.Rule;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientControlTest {
    private ClientControl clientControl = new ClientControl();

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Test
    void isClientCreated() {
        clientControl.createNewClient("ClienName", "ClientSurname");
        clientControl.createNewClient("ClienName2", "ClientSurname2");
        int expected = 2;
        assertEquals(expected, clientControl.getClientList().size());
    }

    @Test
    void getClientById() {
        clientControl.createNewClient("ClienName", "ClientSurname");
        clientControl.createNewClient("ClienName2", "ClientSurname2");
        assertEquals(clientControl.getClientList().get(0), clientControl.getClientById(1));
    }

    //NO idea how to test that XD or should it even be tested
    @Test
    void showAllClients(Client client) {
        clientControl.createNewClient("ClienName", "ClientSurname");
        clientControl.createNewClient("ClienName", "ClientSurname");
        assertTrue(clientControl.);

    }

    @Test
    void ClientListEmpty() {
        assertTrue(clientControl.getClientList().isEmpty());
    }

    @Test
    void ClientListNotEmpty() {
        clientControl.createNewClient("ClienName", "ClientSurname");
        assertFalse(clientControl.getClientList().isEmpty());
    }
}