package model;

/**
 * 书籍类Book，成员变量：书名title（String类型）、价格price（int类型）。
 */
public class Book {
    private String isbn;

    private String title;

    private Author author;

    private int price;

    private String bookInformation;//存放从简介文件中读取的信息

    public Book(){}

    public Book(Book book){
        this.isbn=book.getIsbn();
        this.title=book.getTitle();
        this.author=book.getAuthor();
        this.price=book.getPrice();
    }
        public Book(String isbn,String title,Author author,int price){
        this.isbn=isbn;
        this.author=author;
        this.title=title;
        this.price=price;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setTitle(String title) {
        this.title = title.trim();
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice(){
        return price;
    }

    public String getBookInformation() {
        return bookInformation;
    }

    public void setBookInformation(String bookInformation) {
        this.bookInformation = bookInformation;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

