package ReservationSystem.Client;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {

    private int clientId = 100;
    private String clientName = "ClientName";
    private String clientSurname = "ClientSurname";
    private Client client = new Client(clientId, clientName, clientSurname);

    @Test
    void getClientId() {
        int expected = clientId;
        assertEquals(client.getClientId(), expected);
    }

    @Test
    void getClientName() {
        String expected = clientName;
        assertEquals(client.getClientName(), expected);
    }

    @Test
    void getClientSurname() {
        String expected = clientSurname;
        assertEquals(client.getClientSurname(), expected);
    }

    @Test
    void isToStringWorking() {
        String expected = "Client{" +
                "clientId=" + clientId +
                ", clientName='" + clientName + '\'' +
                ", clientSurname='" + clientSurname + '\'' +
                '}';
        assertEquals(expected, client.toString());
    }
}
