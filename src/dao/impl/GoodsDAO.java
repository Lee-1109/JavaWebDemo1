package dao.impl;

import java.sql.*;

/**
 * 用于连接Mysql数据库
 * dbName:liyang
 *
 */
public class GoodsDAO extends BaseDAO {

    /**
     * 在构造函数中获取与数据库的连接
     *
     * @throws Exception
     */
    public GoodsDAO() throws Exception {
        super();
    }

    @Override
    public void initTableName(String tbName) {
        this.tbName=tbName;
    }

    /**
     * 向goods表中添加数据
     * @param tableName 要使用的数据库表名
     * @param name 货物名字
     * @param price 货物价格
     * @param quantity 货物数量
     * @throws SQLException
     */
    public void executeInsert(final String tableName,final String name,final double price,final int quantity) throws SQLException {
        String insert="insert into "+tableName.trim()+" values(?,?,?)";
        preparedStatement=connection.prepareStatement(insert);
        preparedStatement.setString(1,name);
        preparedStatement.setDouble(2,price);
        preparedStatement.setInt(3,quantity);
        preparedStatement.executeUpdate();
    }

    /**
     * 查询表中所有结果集
     * @return goods表中的结果集
     * @throws SQLException
     */
    public ResultSet executeQueryAll(final String tableName) throws SQLException {
        final String select="select * from  "+tableName;
        //先编译
        preparedStatement=connection.prepareStatement(select);
        //编译后执行语句
        this.resultSet = preparedStatement.executeQuery(select);
        return resultSet;
    }

}
