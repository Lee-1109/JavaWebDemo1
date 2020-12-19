package model;

import java.io.Serializable;
import java.util.Set;

public class Author implements Serializable {
    private int id;
    private String name;
    private String tel;
    private String email;
    private Set<Book> books;
    public Author(){}
    public Author(String name){
        this.name=name;
    }
    public Author(int id,String name,String tel,String address){
        this.id=id;
        this.name=name;
        this.tel=tel;
        this.email =address;
    }
    public Author(String name,String tel,String email){
        this.name=name;
        this.tel=tel;
        this.email=tel;
    }

    public int getId() {
        return id;
    }

    public void setId(int ID) {
        this.id = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getTel() {
        return tel;
    }

    public void setEmail(String address) {
        this.email = address;
    }

    public String getEmail() {
        return email;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
