package hibernate;

import model.Book;
import model.Lend;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import util.HibernateSessionFactory;

import java.util.Iterator;
import java.util.List;

public class Dymatic {
    public static void main(String[] args) {
        Session session= HibernateSessionFactory.getSession();
        Iterator iterator=session.createQuery("from Book b where b.isbn not in ( select l.lendPK.bookIsbn from Lend l ) " ).list().iterator();

        while(iterator.hasNext()){
            Book book= (Book) iterator.next();
            System.out.println(book.getTitle());
        }
//        assert session != null;
//        //动态条件查询
//        List cats = session.createCriteria(Lend.class).add( Expression.like("lendPK.userName", "18045221") )
//                .list();
//        Iterator iterator=cats.iterator();
//        while (iterator.hasNext()){
//            Lend lend= (Lend) iterator.next();
//            System.out.println("借书："+lend.getLendPK().getUserName());
//            System.out.println("借书名："+lend.getLendPK().getBookIsbn());
//        }
    }
}
