package hibernate;

import dao.impl.LendDAO;
import model.Book;
import model.Lend;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateSessionFactory;

import javax.management.Query;
import java.util.ArrayList;
import java.util.Iterator;

public class queryDemo {
    public static void main(String[] args) {
        Session session= HibernateSessionFactory.getSession();
        Transaction transaction = session.beginTransaction();
        Iterator iterator= session.createQuery("select b from Lend l,Book b where l.lendPK.bookIsbn=b.isbn ").iterate();
        while (iterator.hasNext()){
            Book lend= (Book) iterator.next();
            System.out.println(
                    lend.getTitle()
            );
        }
        transaction.commit();
    }
}
