package contacts.contacts;

import contacts.utility.RegexValidation;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.List;

public abstract class Contact implements Serializable {
    protected String phoneNumber = "[no number]";
    protected String timeCreated = "";
    protected String timeEdited = "";

    public abstract String getName();
    public abstract void editContact();

    public abstract void showInfo();


    public void setPhoneNumber(String phoneNumber) {
        if (RegexValidation.isValidPhoneNumber(phoneNumber)) this.phoneNumber = phoneNumber;
        else this.phoneNumber = "[no number]";
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(String timeCreated) {
        this.timeCreated = timeCreated;
    }

    public String getTimeEdited() {
        return timeEdited;
    }

    public void setTimeEdited(String timeEdited) {
        this.timeEdited = timeEdited;
    }

    public abstract String getSearchable();
}
