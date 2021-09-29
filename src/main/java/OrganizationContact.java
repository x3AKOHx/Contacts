import java.time.LocalDateTime;
import java.util.Scanner;

public class OrganizationContact extends Contacts {

    private String address;

    public OrganizationContact(String name, String address, String number) {
        super(name, number);
        this.address = address;
    }

    public void info() {
        System.out.println("Organization name: " + getName());
        System.out.println("Address: " + address);
        System.out.println("Number: " + getNumber());
        System.out.println("Time created: " + getCreationTime());
        System.out.println("Time last edit: " + getLastChangeTime());
        System.out.println();
    }

    public void edit() {
        System.out.println("Select a field (name, address, number):");
        Scanner sc = new Scanner(System.in);
        String field = sc.nextLine();
        switch (field) {
            case "name" -> {
                System.out.println("Enter name:");
                String name = sc.nextLine();
                setName(name);
                setLastChangeTime(LocalDateTime.now());
                System.out.println("The record updated!");
            }
            case "address" -> {
                System.out.println("Enter the address:");
                String address = sc.nextLine();
                setAddress(address);
                setLastChangeTime(LocalDateTime.now());
                System.out.println("The record updated!");
            }
            case "number" -> {
                System.out.println("Enter number:");
                String number = sc.nextLine();
                setNumber(number);
                setLastChangeTime(LocalDateTime.now());
                System.out.println("The record updated!");
            }
            default -> System.out.println("Wrong input!");
        }
        System.out.println();
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
