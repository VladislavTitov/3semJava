/**
 * Created by Vladislav on 08.12.2016.
 */
public interface ServerCallback {

    int numberOfClients();

    void removeClient(ClientThread client);

}
