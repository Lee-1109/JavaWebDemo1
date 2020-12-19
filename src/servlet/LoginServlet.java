package servlet;
import dao.impl.UserDAO;
import model.User;

import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    private String SUCCESS_JSP="lab3/adminMain.jsp";
    private String ERROR_JSP="lab3/login/loginError.jsp";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        User user=new User();
        //获取用户输入的用户名
        user.setName(request.getParameter("name").trim());
        //获取用户输入的密码
        user.setPassword(request.getParameter("password").trim());
        try {
            boolean exist=false;
            UserDAO db=new UserDAO();
            db.initTableName("users");
            ResultSet rs = db.select();
            while (rs.next()){
                if(rs.getString("name").equals(user.getName()) && rs.getString("password").equals(user.getPassword())){
                    exist=true;
                }
            }
            //跳转到成功页面
            if(exist){
                request.getSession().setAttribute("user",user);
                response.sendRedirect(SUCCESS_JSP);
            }else {
                response.sendRedirect(ERROR_JSP);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
