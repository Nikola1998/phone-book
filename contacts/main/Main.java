package contacts.main;

public class Main {
    public static void main(String[] args) {
        Menu contactsConsole = Menu.getInstance();
        if (args.length > 0) {
            PhoneBook.getInstance().setFileName(args[0]);
            PhoneBook.getInstance().loadContacts();
        }
        contactsConsole.startMenu();
    }
}
