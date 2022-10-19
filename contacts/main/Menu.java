package contacts.main;

import contacts.contacts.Contact;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    private final static Menu instance = new Menu();
    private final Scanner scanner = new Scanner(System.in);
    private final PhoneBook phoneBook = PhoneBook.getInstance();

    public static Menu getInstance() {
        return instance;
    }

    public void startMenu() {
        boolean exitProgram = false;
        while (!exitProgram) {
            System.out.print("\n[menu] Enter action (add, list, search, count, exit): ");
            String input = scanner.nextLine();
            switch (input) {
                case "add":
                    phoneBook.addContact();
                    break;
                case "list":
                    listMenu();
                    break;
                case "count":
                    phoneBook.countContacts();
                    break;
                case "search":
                    phoneBook.searchContacts();
                    break;
                case "exit":
                    exitProgram = true;
                    break;
                default:
                    System.out.println("No such action");
            }
        }
        PhoneBook.getInstance().saveContacts();
    }

    public void searchMenu(ArrayList<Contact> foundContacts) {
        System.out.print("\n[search] Enter action ([number], back, again): ");
        String inputOption = scanner.nextLine();
        switch (inputOption) {
            case "back":
                break;
            case "again":
                phoneBook.searchContacts();
                break;
            default:
                chooseRecordByNumber(foundContacts, inputOption);
        }
    }

    private void chooseRecordByNumber(ArrayList<Contact> list, String number) {
        if (number.matches("\\d")) {
            int index = Integer.parseInt(number);
            if (index < 1 || index > list.size()) System.out.println("No such record.");
            else {
                Contact contact = list.get(index - 1);
                contact.showInfo();
                System.out.println();
                recordMenu(contact);
            }
        }
    }

    private void recordMenu(Contact contact) {
        System.out.print("[record] Enter action (edit, delete, menu): ");
        String inputOption = scanner.nextLine();
        switch (inputOption) {
            case "edit":
                contact.editContact();
                break;
            case "delete":
                phoneBook.removeContact(contact);
                break;
            case "menu":
                break;
        }
    }

    private void listMenu() {
        ArrayList<Contact> list = phoneBook.getList();
        phoneBook.listContacts(list);
        System.out.println();
        System.out.print("[list] Enter action ([number], back): ");
        String inputOption = scanner.nextLine();
        switch (inputOption) {
            case "back":
                break;
            case "again":
                phoneBook.searchContacts();
                break;
            default:
                chooseRecordByNumber(list, inputOption);
        }
    }
}
