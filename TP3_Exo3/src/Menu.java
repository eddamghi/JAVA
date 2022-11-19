import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Menu {
    public static void displayClients(BusinessClientImpl clientFile) throws IOException, ClassNotFoundException {
        for (Client client : clientFile.getAllClients()) {
            System.out.println("|\t" + client.getId() + "|\t" + client.getFirstName() + "|\t" + client.getLastName() + "|\t" + client.getAddress() + "|\t" + client.getPhoneNumber() + "|\t" + client.getEmail());
        }
    }

    public static List<Client> getAllClients(BusinessClientImpl clientFile) throws IOException, ClassNotFoundException {
        return clientFile.getAllClients();
    }

    public static void addNewClient(BusinessClientImpl clientFile) throws IOException {
        Scanner _id = new Scanner(System.in);
        Scanner _firstName = new Scanner(System.in);
        Scanner _lastName = new Scanner(System.in);
        Scanner _address = new Scanner(System.in);
        Scanner _phoneNumber = new Scanner(System.in);
        Scanner _email = new Scanner(System.in);
        System.out.println("Id of the client you want to add: ");
        long id = _id.nextLong();
        System.out.println("FirstName of the client you want to add: ");
        String firstName = _firstName.nextLine();
        System.out.println("LastName of the client you want to add: ");
        String lastName = _lastName.nextLine();
        System.out.println("Address of the client you want to add: ");
        String address = _address.nextLine();
        System.out.println("PhoneNumber of the client you want to add: ");
        String phoneNumber = _phoneNumber.nextLine();
        System.out.println("Email of the client you want to add: ");
        String email = _email.nextLine();
        Client client = new Client(id, firstName, lastName, address, phoneNumber, email);
        clientFile.addClient(client);

    }

    public static void removeClient(BusinessClientImpl clientFile) throws IOException, ClassNotFoundException {
        Scanner _id = new Scanner(System.in);
        System.out.println("Id of the client you want to remove: ");
        long id = _id.nextLong();
        for (Client client : clientFile.getAllClients()) {
            if (client.getId() == id)
                clientFile.removeClientById(id);
        }
    }

    public static void saveModifications(BusinessClientImpl clientFile) throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("Do you want to save your modifications ");
        boolean answer = input.nextBoolean();
        if (answer) {
            clientFile.saveAllClients();
        }
    }

    public static void printMenu() {
        System.out.println("\t\t| Menu |\t");
        System.out.println("1 | display clients      |");
        System.out.println("2 | get client           |");
        System.out.println("3 | add New Client       |");
        System.out.println("4 | remove Client        |");
        System.out.println("5 | Save clients         |");
        System.out.println("6 | Exit                 |");
    }

    public static void printServices(BusinessClientImpl clientFile) throws IOException, ClassNotFoundException {
        int service;
        do {
            printMenu();
            service = Menu.getService();
            switch (service) {
                case 1:
                    displayClients(clientFile);
                    break;
                case 2:
                    getClientById(clientFile);
                    break;
                case 3:
                    addNewClient(clientFile);

                    break;
                case 4:
                    removeClient(clientFile);
                    break;
                case 5:
                    saveModifications(clientFile);
                    break;
                default:
                    return;
            }
        } while (true);
    }

    private static void getClientById(BusinessClientImpl clientFile) {
    }

    private static int getService() {
        Scanner input = new Scanner(System.in);
        System.out.println("Type the Service you want :");
        return input.nextInt();
    }
}