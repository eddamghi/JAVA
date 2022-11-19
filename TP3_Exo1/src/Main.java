import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        ContactsFolder contactsFolder = new ContactsFolder("C:\\Users\\lux\\OneDrive - usmba.ac.ma\\S3\\JAVA\\Homwork_3\\TP3_Exo1\\src\\Contacts");
        int service;
        displayContacts(contactsFolder);
        do {
            printMenu();
            service = getService();
            switch (service) {
                case 1:
                    searchContact(contactsFolder);
                    break;
                case 2:
                    addNewContact(contactsFolder);
                    break;
                case 3:
                    removeContact(contactsFolder);
                    break;
                case 4:
                    changePhoneNumber(contactsFolder);
                    break;
                case 5:
                    displayContacts(contactsFolder);
                    break;
                default:
                    return;
            }
        } while (true);

    }

    private static void changePhoneNumber(ContactsFolder contactsFolder) {
        Scanner _name = new Scanner(System.in);
        Scanner _newPhoneNumber = new Scanner(System.in);
        System.out.println("Name of contact you want to change: ");
        String name = _name.nextLine();
        System.out.println("New phone number : ");
        String newPhoneNumber = _newPhoneNumber.nextLine();
        contactsFolder.changePhoneNumber(name, newPhoneNumber);
    }

    private static void removeContact(ContactsFolder contactsFolder) {
        Scanner _name = new Scanner(System.in);
        System.out.println("Name of contact you want to remove: ");
        String name = _name.nextLine();
        contactsFolder.removeContactByName(name);
    }

    private static void addNewContact(ContactsFolder contactsFolder)  {
        Scanner _name = new Scanner(System.in);
        Scanner _PhoneNumber = new Scanner(System.in);
        System.out.println("Name of contact you want to add: ");
        String name = _name.nextLine();
        System.out.println("Phone Number : ");
        String PhoneNumber = _PhoneNumber.nextLine();
        contactsFolder.addContact(name, PhoneNumber);
    }

    private static void searchContact(ContactsFolder contactsFolder) {
        Scanner _name = new Scanner(System.in);
        System.out.println("Name of the contact you look for: ");
        String name = _name.nextLine();
        for (Contact c : contactsFolder.getContacts()) {
            if (name.equals(c.getFullName()))
                System.out.println("|\t " + c.getFullName() + " \t| " + c.getPhoneNumber() + "\t|");
        }
    }

    private static void printMenu() {
        System.out.println("\t\t| Menu |\t");
        System.out.println("1 | get Phone Number    |");
        System.out.println("2 | add new contact     |");
        System.out.println("3 | Delete an contact   |");
        System.out.println("4 | Change phone Number |");
        System.out.println("5 | Show contacts       |");
        System.out.println("6 | Exit                |");
    }
    private static int getService() {

        Scanner input = new Scanner(System.in);
        System.out.println("Type the Service you want :");
        return input.nextInt();
    }
    private static void displayContacts(ContactsFolder contactsFolder){
        for (Contact c : contactsFolder.getContacts()) {
            System.out.println("|\t\t  Name  \t\t" + "|\tPhone Number\t|" );
            System.out.println("|\t " + c.getFullName() + " \t| " + c.getPhoneNumber() + "\t|");
            System.out.println("--------------------------------------------");

        }
    }
}