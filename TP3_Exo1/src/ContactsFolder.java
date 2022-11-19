import lombok.Getter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class ContactsFolder {
    @Getter private final List<Contact> contacts = new ArrayList<>();
    @Getter private final File path;

    public ContactsFolder(String path) throws IOException {
        this.path = new File(path);
        if(!(this.path.exists())){
            this.path.mkdirs();
            return;
        }
        File[] contactsFile = this.path.listFiles();
        assert contactsFile != null;
        for (File cf: contactsFile)  {
            var fileName = cf.getName();
            if (fileName.endsWith(".txt")) {
                var contactName = fileName.substring(0, fileName.length() - 4);
                var contactPhoneNumber = Files.readString(cf.toPath());
                addContact(contactName, contactPhoneNumber);
            }
         }
    }

    public void addContact(String name, String phoneNumber) {
        Contact contact = new Contact(name, phoneNumber);
        if (contacts.contains(contact)) { return; }
        try {
            FileWriter contactWriter = new FileWriter(name + ".txt");
            contactWriter.write(phoneNumber);
            contactWriter.close();
        }
        catch(IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        contacts.add(contact);
    }
    public void removeContactByName(String name){
        contacts.removeIf(c -> name.equals(c.getFullName()));
    }
    public Contact getContactByName(String name) {
        for (Contact c : contacts) {
            if (name.equals(c.getFullName()))
                return c;
        }
        return null;
    }

    public void changePhoneNumber(String name, String newPhoneNumber){
        for (Contact c: contacts) {
            if (name.equals(c.getFullName()))
                c.setPhoneNumber(newPhoneNumber);
        }
    }
}
