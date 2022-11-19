

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
@NoArgsConstructor
public class BusinessClientImpl implements BusinessClient {
    private List<Client> clients = new ArrayList<>();
    private File path;

    public BusinessClientImpl(String path) throws IOException, ClassNotFoundException {
        this.path = new File(path);
        getAllClients();

    }
    @Override
    public Client addClient(Client client) throws IOException {
        clients.add(client);
        saveAllClients();
        return client;
    }

    @Override
    public List<Client> getAllClients() throws ClassNotFoundException, IOException {
//        List<Client> clients;
        ObjectInputStream clientReader = new ObjectInputStream(new FileInputStream(path.getPath()));
        clients = (List<Client>) clientReader.readObject();
        clientReader.close();
        return clients;
    }
    @Override
    public Client findClientById(long id) {
        for (Client client : clients) {
            if(client.getId() == id)
                return client;
        }
        return null;
    }

    @Override
    public void removeClientById(long id) {
        clients.removeIf(client -> client.getId() == id);
    }

    @Override
    public void saveAllClients() throws IOException {
        ObjectOutputStream clientWriter = new ObjectOutputStream(new FileOutputStream(path));
        clientWriter.writeObject(clients);
        clientWriter.close();
    }
}
