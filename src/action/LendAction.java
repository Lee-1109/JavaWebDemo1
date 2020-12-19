package action;

import com.opensymphony.xwork2.ActionSupport;
import dao.impl.LendDAO;
import model.Book;
import model.Lend;
import model.User;
import java.util.ArrayList;

public class LendAction extends ActionSupport {
    private User user;
    private Book book;
    private LendDAO lendDAO=new LendDAO();
    private ArrayList<Lend> lends =new ArrayList<>();
    private ArrayList<Book> books=new ArrayList<>();

    public LendAction() throws Exception {
    }

    //查看可借图书
    public String listBorrowBook(){
        this.books=lendDAO.selectNotBorrowBook(user);
        return SUCCESS;
    }
    //查看已借图书
    public String listBorrowedBook(){
        this.lends =lendDAO.selectBorrowedBook(user);
        return SUCCESS;
    }

    //借书
    public String BorrowBook(){
        if(lendDAO.borrowBook(user,book))
            return SUCCESS;
        else
            return ERROR;
    }
    //还书
    public String returnBook(){
        if(lendDAO.delete(user,book)){
            this.addActionMessage("还书成功！");
            return SUCCESS;
        }
        else{
            this.addActionMessage("还书失败！");
            return ERROR;
        }

    }
    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Book getBook() {
        return book;
    }

    public void setLendDAO(LendDAO lendDAO) {
        this.lendDAO = lendDAO;
    }

    public LendDAO getLendDAO() {
        return lendDAO;
    }

    public void setLends(ArrayList<Lend> lends) {
        this.lends = lends;
    }

    public ArrayList<Lend> getLends() {
        return lends;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }
}
