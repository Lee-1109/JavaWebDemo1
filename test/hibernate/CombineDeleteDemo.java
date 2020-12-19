package hibernate;

import model.Book;
import model.Lend;
import model.LendPK;
import model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateSessionFactory;

public class CombineDeleteDemo {
    public static void main(String[] args) {
        try {
            Session session= HibernateSessionFactory.getSession();
            User user=new User();
            Book book=new Book();
            Transaction transaction=session.beginTransaction();
            LendPK lendPK=new LendPK();
            lendPK.setUserName("18045221");
            lendPK.setBookIsbn("003");
            Lend lend1=session.get(Lend.class,lendPK);
            session.delete(lend1);
            transaction.commit();
            System.out.println("删除成功！");

        }catch (Exception e){
            e.printStackTrace();
            System.out.println("删除异常！");
        }

    }
}
