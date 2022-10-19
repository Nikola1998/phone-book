package contacts.utility;

public class RegexValidation {
    public static boolean isValidPhoneNumber(String phoneNumber) {
        if (phoneNumber.matches("(\\+?[A-Za-z\\d][ -])?[A-Za-z\\d]{2,}([ -][A-Za-z\\d]{2,})*") ||
                phoneNumber.matches("(\\+?[A-Za-z\\d][ -])?\\([A-Za-z\\d]{2,}\\)([ -][A-Za-z\\d]{2,})*") ||
                phoneNumber.matches("\\+?\\([A-Za-z\\d]\\)[ -][A-Za-z\\d]{2,}([ -][A-Za-z\\d]{2,})*") ||
                phoneNumber.matches("\\+?[A-Za-z\\d]+") ||
                phoneNumber.matches("\\+?\\([A-Za-z\\d]+\\)") ||
                phoneNumber.matches("\\+?[A-Za-z\\d]{2,}[ -]\\([A-Za-z\\d]{2,}\\)([ -][A-Za-z\\d]{2,})*") ||
                phoneNumber.matches("\\+?\\([A-Za-z\\d]{2,}\\)[ -][A-Za-z\\d]{2,}([ -][A-Za-z\\d]{2,})*")) return true;
        else {
            System.out.println("Wrong number format!");
            return false;
        }
    }
}
