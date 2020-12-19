package dao.impl;

import model.Course;

import java.sql.*;

public class CourseDAO extends BaseDAO {
    /**
     * @throws Exception
     */
    public CourseDAO() throws Exception {
        super();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

    @Override
    public void initTableName(String tbName) {
        this.tbName=tbName;
    }

    public void executeInsert(Course course) throws SQLException {
        String insert="insert into "+this.tbName.trim()+" values(?,?,?,?,?,?)";
        preparedStatement=connection.prepareStatement(insert);
        preparedStatement.setString(1,course.getName());
        preparedStatement.setDouble(2,course.getCredit());
        preparedStatement.setInt(3,course.getPeriod());
        preparedStatement.setInt(4,course.getTerm());
        preparedStatement.setInt(5,course.getAssessment());
        preparedStatement.setString(6,course.getBrief());
        preparedStatement.executeUpdate();
    }

    public ResultSet executeQueryAll() throws SQLException {
        final String SELECT="select * from  "+this.tbName;
        //先编译
        preparedStatement=connection.prepareStatement(SELECT);
        //编译后执行语句
        this.resultSet = preparedStatement.executeQuery(SELECT);
        return resultSet;
    }


}
