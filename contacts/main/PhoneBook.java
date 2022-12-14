package contacts.main;

import contacts.contacts.Contact;
import contacts.contacts.ContactOrganization;
import contacts.contacts.ContactPerson;
import contacts.utility.Serializer;

import java.util.ArrayList;
import java.util.Scanner;

public class PhoneBook {

    private final Scanner scanner = new Scanner(System.in);
    private static final PhoneBook instance = new PhoneBook();
    private ArrayList<Contact> list = new ArrayList<>();

    private String fileName;

    public ArrayList<Contact> getList() {
        return list;
    }

    public static PhoneBook getInstance() {
        return instance;
    }

    public void addContact() {
        Contact contact = null;
        System.out.print("Enter the type (person, organization): ");
        String input = scanner.nextLine();
        if (input.equals("person")) contact = new ContactPerson();
        else if (input.equals("organization")) contact = new ContactOrganization();
        if (contact != null) {
            System.out.println("The record added.");
            list.add(contact);
        } else System.out.println("Invalid type!");
    }

    public void listContacts(ArrayList<Contact> contacts) {
        if (contacts.isEmpty()) System.out.println("No records to list!");
        else {
            for (int i = 0; i < contacts.size(); i++) {
                Contact contact = contacts.get(i);
                System.out.println(i + 1 + ". " + contact.getName());
            }
        }
    }

    public void countContacts() {
        System.out.println("The Phone Book has " + list.size() + " records.");
    }

    public void removeContact(Contact contact) {
        list.remove(contact);
        System.out.println("The record removed!");
    }

    public void searchContacts() {
        if (!list.isEmpty()) {
            System.out.print("Enter search query: ");
            String searchRegex = scanner.nextLine().toLowerCase();
            ArrayList<Contact> foundContacts = getListBasedOnRegex(searchRegex);

            listContacts(foundContacts);
            Menu.getInstance().searchMenu(foundContacts);
        } else System.out.println("The Phone book is empty!");
    }

    private ArrayList<Contact> getListBasedOnRegex(String searchRegex) {
        ArrayList<Contact> foundContacts = new ArrayList<>();
        for (Contact contact : list) {
            if (contact.getSearchable().matches(".*" + searchRegex + ".*")) foundContacts.add(contact);
        }
        return foundContacts;
    }

    public void loadContacts() {
        list = (ArrayList<Contact>) Serializer.deserialize(fileName);
        System.out.println("Loaded " + fileName);
    }

    public void saveContacts() {
        if (fileName != null) {
            Serializer.serialize(list, fileName);
            System.out.println("Can't save contacts.");
        }
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
