package hibernate;

import dao.impl.LendDAO;
import model.Book;
import model.Lend;
import model.LendPK;
import model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateSessionFactory;

import java.util.Date;

public class ConbinePKTest {
    public static void main(String[] args) {
//        Session session= HibernateSessionFactory.getSession();
//        Transaction transaction= session.beginTransaction();
//        LendPK pk=new LendPK();
//        pk.setUserName("18045204");
//        pk.setBookIsbn("002");
//        Lend lend=new Lend();
//        lend.setLendPK(pk);
//        lend.setDate(new Date(System.currentTimeMillis()));
//        session.save(lend);
//        transaction.commit();
        try {
            User user=new User();
            Book book=new Book();
            user.setName("userTest1");
            book.setIsbn("bookTest2");
            LendDAO lendDAO=new LendDAO();
            lendDAO.borrowBook(user,book);
            System.out.println("测试成功!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("测试失败！");
        }


    }
}
