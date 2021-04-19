package pojo;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.util.Date;

public class Student implements Cloneable {
    private String name;
    private Book book;
    private Date birth;

    public Student() {

    }

    public Student(String name) {
        this.name = name;
    }

    public void readBook() {
        System.out.println(getName() + " read " + book.getName());
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

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Student clone() throws CloneNotSupportedException {
        return (Student) super.clone();
    }
}
