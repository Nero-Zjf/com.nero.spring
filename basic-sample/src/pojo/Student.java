package pojo;

public class Student {
    private String name;
    private Book book;

    public void readBook() {
        System.out.println(name + " read " + book.name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
