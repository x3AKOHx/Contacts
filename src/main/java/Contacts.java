import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

abstract public class Contacts implements Serializable {

    private String name;
    private String number;
    private final LocalDateTime creationTime;
    private LocalDateTime lastChangeTime;

    public Contacts(String name, String number) {
        this.name = name;
        this.number = Objects.requireNonNullElse(number, "[no number]");
        creationTime = LocalDateTime.now();
        lastChangeTime = LocalDateTime.now();
    }

    abstract void info();

    abstract void edit();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        String check = "^\\+?(((\\([0-9A-Za-z]+\\)[\\s,-][0-9A-Za-z]{2,})|" +
                "([0-9A-Za-z]+[\\s,-]\\([0-9A-Za-z]{2,}\\))|" +
                "([0-9A-Za-z]+[\\s,-][0-9A-Za-z]{2,}))([\\s,-][0-9A-Za-z]{2,})*)|" +
                "(\\+?(\\([0-9A-Za-z]+\\))|(\\+?[0-9A-Za-z]+))$";
        if (number.matches(check)) {
            this.number = number;
        } else {
            System.out.println("Wrong number format!");
            this.number = "[no number]";
        }

    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public LocalDateTime getLastChangeTime() {
        return lastChangeTime;
    }

    public void setLastChangeTime(LocalDateTime lastChangeTime) {
        this.lastChangeTime = lastChangeTime;
    }
}
