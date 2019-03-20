package ReservationSystem.Client;

import java.util.ArrayList;
import java.util.List;

/**
 * ClientControl class to Set and Get single Client data
 * And work with that Data
 */
public class ClientControl {
    private List<Client> clientList = new ArrayList<>();
    private int clientId = 0;

    /**
     * Method to create new Clients
     *
     * @param clientName    - Client Name
     * @param clientSurname - Client Surname
     */
    public void createNewClient(String clientName, String clientSurname) {
        clientId++;
        Client client = new Client(clientId, clientName, clientSurname);
        clientList.add(client);
    }

    /**
     * Method to "Print all Clients"
     */
    public void showAllClients() {
        for (Client client : clientList) {
            System.out.println(client);
        }
    }

    /**
     * Method to find Clients by their ID
     *
     * @param clientId - ID number of Client
     * @return client-object
     */
    public Client getClientById(int clientId) {
        for (Client client : clientList) {
            if (client.getClientId() == clientId) {
                return client;
            }
        }
        return null;
    }
}
