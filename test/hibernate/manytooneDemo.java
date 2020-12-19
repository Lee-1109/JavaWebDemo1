package hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateSessionFactory;
import model.Author;

import java.util.Iterator;

public class manytooneDemo {
    public static void main(String[] args) {
        Session session= HibernateSessionFactory.getSession();
        Transaction transaction=session.beginTransaction();
//        Query query=session.createQuery("from Author a where a.name='康密军'");
        Query query=session.createQuery("from Author a where a .name=:myname");
        query.setParameter("myname","康密军");
        Iterator iterator = query.list().iterator();
        while(iterator.hasNext()){
            Author author1= (Author) iterator.next();
            System.out.println(author1.getEmail());

        }
        transaction.commit();
    }
}
