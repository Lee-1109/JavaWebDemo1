package action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import dao.impl.BookDAO;
import model.Book;
import util.MyActionMessage;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class BookAction extends ActionSupport {
    private String condition;
    private Book book;
    private BookDAO bookDao;
    private ArrayList<Book> bookArrayList;
    private File file;//上传的简介文件
    private String fileFileName;
    private String fileContentType;
    private String bookInformation;//存放从文件中读取的内容

    public String add () throws Exception {
        bookDao.select();
        while (bookDao.iterator.hasNext()){
            Book tempBook= (Book) bookDao.iterator.next();
            if (tempBook.getIsbn().equals(book.getIsbn())){
                this.addActionMessage(MyActionMessage.ADD_BOOK_ERROR);
                return Action.ERROR;//书籍已存在
            }
        }
        upload();//上传文件
        book.setBookInformation(bookInformation);
        bookDao.insert(book);
        this.addActionMessage(MyActionMessage.ADD_BOOK_SUCCESS);
        return Action.SUCCESS;//书籍不存在
    }


    private void upload() throws IOException {
        if(this.file!=null){
            InputStream inputStream=new FileInputStream(getFile());
            OutputStream outputStream=new FileOutputStream("C:/"+ getFileFileName());
            //OutputStream outputStream=new FileOutputStream(getFileFileName());
            byte[] buffer =new byte[64];
            int count=0;
            while ( ( count=inputStream.read(buffer) )>0){
                String temp=new String(buffer, StandardCharsets.UTF_8);
                outputStream.write(buffer,0,count);//写入到文件
                if(bookInformation==null){
                    bookInformation=temp.trim();
                }
                bookInformation=bookInformation + temp.trim();//写入到简介
            }
            outputStream.close();
            inputStream.close();
        }
        bookInformation="暂无简介";
    }



    public String find() {
        while (bookDao.iterator.hasNext()){
            Book tempBook= (Book) bookDao.iterator.next();
            if(tempBook.getTitle().equals(book.getTitle()))
                bookArrayList.add(tempBook);
        }
        if(bookArrayList.isEmpty())
            return Action.ERROR;
        else
            return Action.SUCCESS;
    }

    public String search() {
        bookDao.findBookByCondition("%"+this.condition+"%");
        bookArrayList.clear();
        while (bookDao.iterator.hasNext()){
            Book tempBook= (Book) bookDao.iterator.next();
                bookArrayList.add(tempBook);
        }
        if(bookArrayList.isEmpty())
            return Action.ERROR;
        else
            return Action.SUCCESS;
    }

    public String list()  {
        bookDao.select();//查询数据库中的数据
        bookArrayList.clear();
        while (bookDao.iterator.hasNext()){
            Book tempBook= (Book) bookDao.iterator.next();
            bookArrayList.add(tempBook);
        }
        if(bookArrayList.isEmpty())
            return Action.ERROR;
        else
            return Action.SUCCESS;
    }

    public String delete(){
        bookDao.select();
        while (bookDao.iterator.hasNext()){
            Book tempBook= (Book) bookDao.iterator.next();
           if(tempBook.getIsbn().equals(book.getIsbn())){
               bookDao.delete(book);
               return Action.SUCCESS;
           }
        }
            return Action.ERROR;
    }

    public String modify() {
        bookDao.select();
        while (bookDao.iterator.hasNext()){
            Book tempBook= (Book) bookDao.iterator.next();
            if(tempBook.getIsbn().equals(book.getIsbn())){
                bookDao.update(book);
                this.addActionMessage("书籍修改成功！");
                return SUCCESS;
            }
        }
        return ERROR;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setBookDao(BookDAO bookDao) {
        this.bookDao = bookDao;
    }

    public BookDAO getBookDao() {
        return bookDao;
    }

    public void setBookArrayList(ArrayList<Book> bookArrayList) {
        this.bookArrayList = bookArrayList;
    }

    public ArrayList<Book> getBookArrayList() {
        return bookArrayList;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getCondition() {
        return condition;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getFileFileName() {
        return fileFileName;
    }

    public void setFileFileName(String fileFileName) {
        this.fileFileName = fileFileName;
    }

    public String getFileContentType() {
        return fileContentType;
    }

    public void setFileContentType(String fileContentType) {
        this.fileContentType = fileContentType;
    }
}
