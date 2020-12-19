package servlet;

import dao.impl.BookDAO;
import model.Book;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddBookServlet extends HttpServlet {
    private static final String ADD_BOOK_SUCCESS="lab3/books/addSuccess.jsp";
    private static final String ADD_BOOK_ERROR="lab3/books/addError.jsp";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("charset=UTF-8");
        try {
            BookDAO db=new BookDAO();
            db.select();
            Book book=new Book();//临时变量   用来存储用户输入的信息
            book.setTitle(request.getParameter("title").trim());
            book.setPrice(Integer.parseInt(request.getParameter("price") ) );
            if(bookIsExist(db.resultSet, book)){
                //存在此图书
                response.sendRedirect(ADD_BOOK_ERROR);
            }else {
                //不存在此图书 执行插入
                db.insert(book);
                request.getSession().setAttribute("bookInfo",book);
                response.sendRedirect(ADD_BOOK_SUCCESS);
            }

            } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean bookIsExist(ResultSet rs,Book book) throws SQLException {
        boolean exist=false;
        while (rs.next()){
            if(rs.getString("title").equals(book.getTitle()) && rs.getInt("price")==book.getPrice())
                exist=true;
        }
        return exist;
    }
}
