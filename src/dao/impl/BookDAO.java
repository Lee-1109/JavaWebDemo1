package dao.impl;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateSessionFactory;
import model.Book;
import java.sql.SQLException;

public class BookDAO extends BaseDAO {

    private Session session;

    private Transaction transaction;

    private Query query;

    public BookDAO() throws Exception {
        this.session=HibernateSessionFactory.getSession();
    }

    @Override
    public void initTableName(String tbName) {
        this.tbName=tbName;
    }

    /**
     * 插入图书信息
     * @param book
     */
    public void insert(Book book) {
       this.transaction=session.beginTransaction();
       session.get(Book.class,book.getIsbn());
       session.save(book);
       transaction.commit();
    }

    /**
     * 删除图书
     * @param book
     * @throws SQLException
     */
    public void delete(Book book) {
        transaction= session.beginTransaction();
        Book book1=session.get(Book.class, book.getIsbn());
        session.delete(book1);
        transaction.commit();
    }
    /**
     * 更新图书信息
     * @param book
     */
    public void update(Book book) {
        this.transaction= session.beginTransaction();
        //session.update(book);
        session.merge(book);
        transaction.commit();

    }

    public void select(){
        //final String select="select b from Book b inner join  b.author";
        final String select="from Book";
        transaction= session.beginTransaction();
        query=session.createQuery(select);
        selectList = query.list();
        iterator= selectList.iterator();
        transaction.commit();
    }

    /**
     * 模糊查找
     * @param condition 查找条件
     * @throws SQLException
     */
    public void findBookByCondition(String condition) {
        transaction = session.beginTransaction();
        try {//检查是否是数字
            int demo = Integer.parseInt(condition.substring(1, condition.length() - 1));
            final String findByCondition1 = " from Book b where b.price=:condition";
            query = session.createQuery(findByCondition1);
            query.setParameter("condition", demo);
        } catch (Exception e) {
            final String findByCondition = "select b from Book b join b.author a" +
                    " where a.email like :condition or a.name like :condition or a.id =:condition";
            //final String findByCondition = " from Book b where  b.isbn like:condition  or b.title like:condition or b.author.name like: condition or b.author.email like: condition or b.author.tel like: condition";
            query = session.createQuery(findByCondition);
            query.setParameter("condition", condition);
        } finally {
            selectList = query.list();
            iterator= selectList.iterator();
            transaction.commit();
        }
    }
}
