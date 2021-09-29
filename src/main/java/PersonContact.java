import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.Objects;
import java.util.Scanner;

public class PersonContact extends Contacts {

    private String surname;
    private LocalDate birthDate;
    private String gender;

    public PersonContact(String name, String surname, LocalDate birthDate, String gender, String number) {
        super(name, number);
        this.surname = surname;
        this.birthDate = birthDate;
        this.gender = Objects.requireNonNullElse(gender, "[no data]");
    }

    public String getName() {
        return super.getName() + " " + surname;
    }

    public void info() {
        System.out.println("Name: " + super.getName());
        System.out.println("Surname: " + getSurname());
        System.out.println("Birth date: " + Objects.requireNonNullElse(birthDate, "[no data]"));
        System.out.println("Gender: " + getGender());
        System.out.println("Number: " + getNumber());
        System.out.println("Time created: " + getCreationTime());
        System.out.println("Time last edit: " + getLastChangeTime());
        System.out.println();
    }

    public void edit() {
        System.out.println("Select a field (name, surname, birth, gender, number):");
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
            case "surname" -> {
                System.out.println("Enter surname:");
                String surname = sc.nextLine();
                setSurname(surname);
                setLastChangeTime(LocalDateTime.now());
                System.out.println("The record updated!");
            }
            case "birth" -> {
                System.out.println("Enter the birth date:");
                String birth = sc.nextLine();
                setBirthDate(birth);
                setLastChangeTime(LocalDateTime.now());
                System.out.println("The record updated!");
            }
            case "gender" -> {
                System.out.println("Enter the gender (M, F):");
                String gender = sc.nextLine();
                setGender(gender);
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setBirthDate(String birth) {
        try {
            this.birthDate = LocalDate.parse(birth);
        } catch (DateTimeParseException e) {
            System.out.println("Bad birth date!");
            this.birthDate = null;
        }
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if (!"M".equals(gender) && !"F".equals(gender)) {
            System.out.println("Bad gender!");
            this.gender = "[no data]";
        } else {
            this.gender = gender;
        }
    }
}
