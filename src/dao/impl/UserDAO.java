package dao.impl;

import model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateSessionFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAO extends BaseDAO {

    public UserDAO() throws Exception {
        super();
        initTableName("users");
    }

    @Override
    public void initTableName(String tbName) {
        this.tbName=tbName;
    }


//    public void insert(User user) throws SQLException {
//        String insert="insert into "+this.tbName.trim()+" values(?,?)";
//        preparedStatement=connection.prepareStatement(insert);
//
//        preparedStatement.setString(1,user.getName());
//        preparedStatement.setString(2,user.getPassword());
//        preparedStatement.executeUpdate();
//    }
    public ResultSet select() throws SQLException {
//        Session session=HibernateSessionFactory.getSession();
//        Transaction transaction=session.beginTransaction();
//        ArrayList userList= (ArrayList) session.createQuery("from User").list();
//        transaction.commit();
        final String SELECT="select * from  "+this.tbName;
        preparedStatement=connection.prepareStatement(SELECT);
        this.resultSet = preparedStatement.executeQuery();
        return resultSet;
    }

    public ArrayList<User> selectAllUser(){
        Session session=HibernateSessionFactory.getSession();
        return (ArrayList<User>)session.createQuery(" from User u where u.role= '读者' ").list();

    }

    public boolean update(User user){
        try {
            Session session=HibernateSessionFactory.getSession();
            Transaction transaction=session.beginTransaction();
            session.update(user);
            transaction.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public boolean insert(User user){
        try{
            Session session=HibernateSessionFactory.getSession();
            Transaction transaction=session.beginTransaction();
            session.save(user);
            transaction.commit();
            return true;
        }catch (Exception e){
            return false;
        }
    }
    public boolean delete(User user){
        Session session = HibernateSessionFactory.getSession();
        try  {
            Transaction transaction = session.beginTransaction();
            User user1 = session.get(User.class, user.getName());
            session.delete(user1);
            transaction.commit();
            return true;
        } catch (Exception e) {
            return false;
        }finally {
            session.close();
        }
    }

    public ArrayList<User> findUserByCondition(String condition){
        ArrayList<User> users=new ArrayList<>();
        try {
            Session session=HibernateSessionFactory.getSession();
            Transaction transaction=session.beginTransaction();
            Query query =session.createQuery("from User u where u.name like:condition or u.role like:condition");
            query.setParameter("condition",condition);
            users= (ArrayList<User>) query.list();
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
        return users;
    }

}
