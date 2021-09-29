public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        String fileName = "phonebook.db";
        FileSave.loadFromFile(fileName, phoneBook);
        Menu.start(fileName, phoneBook);
    }
}
