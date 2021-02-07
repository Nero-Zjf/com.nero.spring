package pojo;

public class Book {
    private String name;
    private Student owner;

    public Book(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Student getOwner() {
        return owner;
    }

    public void setOwner(Student owner) {
        this.owner = owner;
    }
}
