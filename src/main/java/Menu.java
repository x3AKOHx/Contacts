import java.util.Scanner;

public class Menu {

    public static void start(String fileName, PhoneBook phoneBook) {
        while (true) {
            System.out.println("Enter action (add, remove, edit, count, info, exit):");
            Scanner sc = new Scanner(System.in);
            String pick = sc.nextLine();
            switch (pick) {
                case "add" -> phoneBook.addContact(fileName);
                case "remove" -> phoneBook.removeContact(fileName);
                case "edit" -> phoneBook.editContact(fileName);
                case "count" -> phoneBook.contactsCount();
                case "info" -> phoneBook.contactsInfo();
                case "exit" -> System.exit(0);
                default -> System.out.println("Wrong input!");
            }
        }
    }
}
