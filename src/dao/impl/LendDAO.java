package dao.impl;

import model.Book;
import model.Lend;
import model.LendPK;
import model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;
import util.HibernateSessionFactory;

import java.util.ArrayList;
import java.util.Date;

public class LendDAO extends BaseDAO {

    public LendDAO() throws Exception {
        super();
    }

    @Override
    public void initTableName(String tbName) {
        this.tbName="null";
    }

    /**
     * ==============Î´Íê³É===========
     * @param user
     * @return
     */
    public ArrayList<Book> selectNotBorrowBook(User user) {
        Session session=HibernateSessionFactory.getSession();
        ArrayList<Book> books= (ArrayList<Book>) session.createQuery("from Book b where b.isbn not in ( select l.lendPK.bookIsbn from Lend l ) " ).list();
        session.close();
        return books;
//        session.createQuery("select b from Book b where b.isbn not in (select l.lendPK.bookIsbn from Lend l where l.lendPK.userName= )");
//        return (ArrayList<Book>) session.createCriteria(Book.class)
//                .add( Expression.like("isbn", user.getName()) )
//                .list();

    }

    public ArrayList<Lend> selectBorrowedBook(User user) {
        Session session=HibernateSessionFactory.getSession();
        ArrayList<Lend> lends=(ArrayList<Lend>) session.createCriteria(Lend.class).add( Expression.like("lendPK.userName", user.getName()) ).list();
        session.close();
       return  lends;

    }

    public boolean borrowBook(User user, Book book){
        try {
            Session session=HibernateSessionFactory.getSession();
            Transaction transaction=session.beginTransaction();
            Lend lend=new Lend();
            LendPK lendPK=new LendPK();
            lendPK.setUserName(user.getName());
            lendPK.setBookIsbn(book.getIsbn());
            lend.setLendPK(lendPK);
            lend.setDate(new Date(System.currentTimeMillis()));
            session.save(lend);
            transaction.commit();
            session.close();
            return true;
        }catch (Exception e){
            return false;
        }

    }

    public boolean delete(User user, Book book){
        try{
            Session session=HibernateSessionFactory.getSession();
            Transaction transaction=session.beginTransaction();
            LendPK lendPK=new LendPK();
            lendPK.setUserName(user.getName());
            lendPK.setBookIsbn(book.getIsbn());
            Lend lend1=session.get(Lend.class,lendPK);
            session.delete(lend1);
            transaction.commit();
            session.close();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
