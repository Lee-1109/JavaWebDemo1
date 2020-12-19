package dao.impl;

import java.sql.*;
import java.util.Iterator;
import java.util.List;

abstract class BaseDAO {
    //指定的数据库常量 一般不修改
    protected final static String DRIVE_NAME="com.mysql.cj.jdbc.Driver";

    protected final static String URL="jdbc:mysql://localhost:3306/liyang?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

    protected final static String USER="root";

    protected final static String PASSWORD="tiger";
    //与数据库的连接
    protected Connection connection;
    //连接通道
    protected PreparedStatement preparedStatement;

    protected List selectList;

    public ResultSet resultSet;

    public Iterator iterator;

    protected String tbName;

    /**
     * function:连接数据库 并创建对象
     * @throws Exception
     */
    public BaseDAO() throws Exception {
        Class.forName(DRIVE_NAME).newInstance();
        this.connection = DriverManager.getConnection(URL,USER,PASSWORD);
    }

    /**
     * 在析构函数中断开与数据库的连接
     * @throws Throwable
     */
    @Override
    protected void finalize() throws Throwable {
        preparedStatement.close();
        connection.close();
        super.finalize();
    }

    /**
     * 设置将要使用的数据库表名
     * @param tbName 数据库中表名
     */
    public abstract void initTableName(String tbName);

    public List getSelectList() {
        return selectList;
    }

    public void setSelectList(List selectList) {
        this.selectList = selectList;
    }
}
