package contacts.contacts;

import java.time.LocalDateTime;

public class ContactOrganization extends Contact{
    private String organizationName = "";
    private String address = "";

    public ContactOrganization() {
        System.out.print("Enter the organization name: ");
        setOrganizationName(scanner.nextLine());
        System.out.print("Enter the address: ");
        setAddress(scanner.nextLine());
        System.out.print("Enter the number: ");
        setPhoneNumber(scanner.nextLine());
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String getName() {
        return organizationName;
    }

    @Override
    public void editContact() {
        System.out.print("Select a field (address, number): ");
        String input = scanner.nextLine();
        switch (input) {
            case "address":
                System.out.print("Enter address: ");
                setAddress(scanner.nextLine());
                break;
            case "number":
                System.out.print("Enter number: ");
                setPhoneNumber(scanner.nextLine());
                break;
            default:
                System.out.print("No such field.");
        }
        System.out.println("The record updated!");
        setTimeEdited(LocalDateTime.now().toString());
    }

    @Override
    public void showInfo() {
        System.out.println("Organization name: " + organizationName +
                "\nAddress: " + address +
                "\nNumber: " + getPhoneNumber() +
                "\nTime created: " + getTimeCreated() +
                "\nTime last edit: " + getTimeEdited());
    }

    @Override
    public String getSearchable() {
        return (organizationName + address + phoneNumber + timeCreated + timeEdited).toLowerCase();
    }
}
