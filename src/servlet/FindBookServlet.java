package servlet;

import dao.impl.BookDAO;
import model.Book;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class FindBookServlet extends HttpServlet {
   // private static final String FIND_BOOK_SUCCESS="lab3/books/findSuccess.jsp";
   // private static final String FIND_BOOKS_ERROR="lab3/books/findError.jsp";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        Book book=new Book();
        ArrayList<Book> bookList = new ArrayList<>();
        String title=request.getParameter("title").trim();
        try {
            BookDAO db=new BookDAO();
            db.initTableName("books");
            db.select();
            db.select();
            boolean exist=false;
            while (db.resultSet.next()){
                if(db.resultSet.getString("title").equals(title)){
                    exist=true;
                    book.setTitle(title);
                    book.setPrice(db.resultSet.getInt("price") );
                    bookList.add(book);
                }
            }
            if(exist){
                //存在此书籍
                request.getSession().setAttribute("result",bookList);
               // response.sendRedirect(FIND_BOOK_SUCCESS);
            }else {
                //不存在书籍
              //  response.sendRedirect(FIND_BOOKS_ERROR);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
