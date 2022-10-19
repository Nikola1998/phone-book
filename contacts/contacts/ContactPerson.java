package contacts.contacts;

import java.time.LocalDateTime;

public class ContactPerson extends Contact {
    private String firstName = "";
    private String lastName = "";
    private String gender = "[no data]";
    private String birthDate = "[no data]";

    public ContactPerson() {
        System.out.print("Enter the name of the person: ");
        setFirstName(scanner.nextLine());
        System.out.print("Enter the surname of the person: ");
        setLastName(scanner.nextLine());
        System.out.print("Enter the birth date: ");
        setBirthDate(scanner.nextLine());
        System.out.print("Enter the gender (M, F): ");
        setGender(scanner.nextLine());
        System.out.print("Enter the number: ");
        setPhoneNumber(scanner.nextLine());
        setTimeCreated(LocalDateTime.now().toString());
        setTimeEdited(LocalDateTime.now().toString());
    }

    @Override
    public void editContact() {
        System.out.print("Select a field (name, surname, birth, gender, number): ");
        String input = scanner.nextLine();
        switch (input) {
            case "name":
                System.out.print("Enter name: ");
                setFirstName(scanner.nextLine());
                break;
            case "surname":
                System.out.print("Enter surname: ");
                setLastName(scanner.nextLine());
                break;
            case "birth":
                System.out.print("Enter birth day: ");
                setBirthDate(scanner.nextLine());
                break;
            case "gender":
                System.out.print("Enter gender: ");
                setGender(scanner.nextLine());
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
        System.out.println("Name: " + firstName +
                "\nSurname: " + lastName +
                "\nBirth date: " + birthDate +
                "\nGender: " + gender +
                "\nNumber: " + phoneNumber +
                "\nTime created: " + timeCreated +
                "\nTime last edit: " + timeEdited);
    }

    @Override
    public String getSearchable() {
        return (firstName + lastName + birthDate + gender + phoneNumber + timeEdited + timeCreated).toLowerCase();
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirthDate(String birthDate) {
        if (birthDate.equals("")) {
            this.birthDate = "[no data]";
            System.out.println("Bad birth date!");
        } else this.birthDate = birthDate;
    }

    public void setGender(String gender) {
        if (gender.equals("M") || gender.equals("F")) this.gender = gender;
        else {
            this.gender = "[no data]";
            System.out.println("Bad gender!");
        }
    }

    @Override
    public String getName() {
        return (firstName + " " + lastName);
    }
}
