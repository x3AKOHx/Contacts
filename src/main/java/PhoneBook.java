import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class PhoneBook implements Serializable {

    private ArrayList<Contacts> contacts = new ArrayList<>();

    public void addContact(String fileName) {
        System.out.println("Enter the type (person, organization):");
        Scanner sc = new Scanner(System.in);
        String pick = sc.nextLine();
        switch (pick) {
            case "person" -> {
                addPerson(fileName);
                System.out.println();
            }
            case "organization" -> {
                addOrganization(fileName);
                System.out.println();
            }
            default -> {
                System.out.println("Wrong input!");
                System.out.println();
            }
        }
    }

    private void addPerson(String fileName) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name:");
        String name = sc.nextLine();
        System.out.println("Enter the surname:");
        String surname = sc.nextLine();
        System.out.println("Enter the birth date:");
        String birthDate = sc.nextLine();
        LocalDate date = null;
        try {
            date = LocalDate.parse(birthDate);
        } catch (DateTimeParseException e) {
            System.out.println("Bad birth date!");
        }
        System.out.println("Enter the gender (M, F):");
        String gender = sc.nextLine();
        if (!"M".equals(gender) && !"F".equals(gender)) {
            System.out.println("Bad gender!");
            gender = null;
        }
        System.out.println("Enter the number:");
        String number = sc.nextLine();
        if (!checkNumber(number)) {
            System.out.println("Wrong number format!");
            number = null;
        }
        Contacts contact = new PersonContact(name, surname, date, gender, number);
        contacts.add(contact);
        FileSave.saveToFile(fileName, contacts);
        System.out.println("The record added.");
    }

    private void addOrganization(String fileName) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the organization name:");
        String name = sc.nextLine();
        System.out.println("Enter the address:");
        String address = sc.nextLine();
        System.out.println("Enter the number:");
        String number = sc.nextLine();
        if (!checkNumber(number)) {
            System.out.println("Wrong number format!");
            number = null;
        }
        Contacts contact = new OrganizationContact(name, address, number);
        contacts.add(contact);
        FileSave.saveToFile(fileName, contacts);
        System.out.println("The record added.");
    }

    public void removeContact(String fileName) {
        if (contacts.size() > 0) {
            showContacts();
            System.out.println("Select a record:");
            Scanner sc = new Scanner(System.in);
            int pick = sc.nextInt();
            contacts.remove(pick - 1);
            FileSave.saveToFile(fileName, contacts);
            System.out.println("The record removed!");
        } else {
            System.out.println("No records to remove");
        }
        System.out.println();
    }

    public void editContact(String fileName) {
        if (contacts.size() > 0) {
            showContacts();
            System.out.println("Select a record:");
            Scanner sc = new Scanner(System.in);
            int pick = sc.nextInt();
            contacts.get(pick - 1).edit();
            FileSave.saveToFile(fileName, contacts);
        } else {
            System.out.println("No records to edit");
            System.out.println();
        }
    }

    public void contactsCount() {
        System.out.println("The Phone Book has " + contacts.size() + " records.");
    }

    public void contactsInfo() {
        if (contacts.size() > 0) {
            showContacts();
            System.out.println("Enter index to show info:");
            Scanner sc = new Scanner(System.in);
            int pick = sc.nextInt();
            contacts.get(pick - 1).info();
        } else {
            System.out.println("No records to show");
            System.out.println();
        }
    }

    private void showContacts() {
        int number = 1;
        for (Contacts contact : contacts) {
            System.out.println(number + ". " + contact.getName());
            number++;
        }
    }

    private boolean checkNumber(String number) {
        String check = "^\\+?(((\\([0-9A-Za-z]+\\)[\\s,-][0-9A-Za-z]{2,})|" +
                "([0-9A-Za-z]+[\\s,-]\\([0-9A-Za-z]{2,}\\))|" +
                "([0-9A-Za-z]+[\\s,-][0-9A-Za-z]{2,}))([\\s,-][0-9A-Za-z]{2,})*)|" +
                "(\\+?(\\([0-9A-Za-z]+\\))|(\\+?[0-9A-Za-z]+))$";
        return number.matches(check);
    }

    public void setContacts(ArrayList<Contacts> contacts) {
        this.contacts = contacts;
    }
}
