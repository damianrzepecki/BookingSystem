package ReservationSystem.Client;

/**
 * Client class to hold all Client info privately
 */
public class Client {
    private int clientId;
    private String clientName;
    private String clientSurname;

    /**
     * Method to "Print" Client info
     */
    @Override
    public String toString() {
        return "Client{" +
                "clientId=" + clientId +
                ", clientName='" + clientName + '\'' +
                ", clientSurname='" + clientSurname + '\'' +
                '}';
    }

    /**
     * Client constructor
     *
     * @param clientId      - Id generated Automatically
     * @param clientName    - Client Name
     * @param clientSurname - Client Surname
     */
    //TODO - DETERMINE What more information is needed e.g.-phone number, email, some short note
    Client(int clientId, String clientName, String clientSurname) {
        this.clientId = clientId;
        this.clientName = clientName;
        this.clientSurname = clientSurname;
    }

    /**
     * Get Client`s ID
     *
     * @return ClientID
     */
    public int getClientId() {
        return clientId;
    }

    /**
     * Get Client`s Name
     *
     * @return Client Name
     */
    public String getClientName() {
        return clientName;
    }

    /**
     * Get Client`s Surname
     *
     * @return Client Surname
     */
    public String getClientSurname() {
        return clientSurname;
    }
}

