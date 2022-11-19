import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface BusinessClient {
    public Client addClient(Client client) throws IOException;
    public List<Client> getAllClients() throws ClassNotFoundException, IOException;
    public Client findClientById(long id);
    public void removeClientById(long id);
    public void saveAllClients() throws IOException;
}
