package hibernate;

import model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateSessionFactory;

public class UserDemo {
    public static void main(String[] args) {
        Session session=HibernateSessionFactory.getSession();
        Transaction transaction=session.beginTransaction();
        session.save(new User("18045214","18045214","读者"));
        transaction.commit();
        System.out.println("添加成功!");
    }
}
