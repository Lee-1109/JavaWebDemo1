package servlet;

import dao.impl.CourseDAO;
import model.Course;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;

public class AddCourseServlet extends HttpServlet {
    private static final String SUCCESS_JSP="lab2/success.jsp";
    private static final String ERROR_JSP="lab2/error.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Course course = new Course();
        CourseDAO db = null;
        try {
            db = new CourseDAO();
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.setContentType("charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        course.setName(request.getParameter("name").trim());
        course.setCredit(Double.parseDouble(request.getParameter("credit")));
        course.setPeriod(Integer.parseInt(request.getParameter("period")));
        course.setTerm(Integer.parseInt(request.getParameter("term")));
        course.setAssessment(Integer.parseInt(request.getParameter("assessment")));
        course.setBrief(request.getParameter("brief"));
        try {
            boolean exist=false;
            db.initTableName("courses");
            db.executeQueryAll();
            ResultSet rs= db.executeQueryAll();
            while(rs.next()){
                if (course.getName().equals(rs.getString("name"))) {
                    exist=true;
                }
            }
            if(!exist){
                db.executeInsert(course);
                request.getSession().setAttribute("myCourse", course);
                response.sendRedirect(SUCCESS_JSP);
            }else {
                response.sendRedirect(ERROR_JSP);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}


