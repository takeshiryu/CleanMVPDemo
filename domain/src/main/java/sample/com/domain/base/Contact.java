package sample.com.domain.base;

public class Contact {
    private String id;
    private String name;
    private String number;

    public Contact(String id, String name, String number) {
        this.id = id;
        this.name = name;
        this.number = number;
    }

    public Contact(String id, String name) {
        this(id, name, "");
    }

    public String name() {
        return name;
    }

    public String number() {
        return number;
    }
}
