package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import dao.impl.UserDAO;
import model.User;
import java.util.ArrayList;
import java.util.Map;
public class UserAction extends ActionSupport {

    private User user;

    private UserDAO userDAO;

    private String condition="";

    private ArrayList<User> userArrayList=new ArrayList<>();

    public String login() throws Exception {

        String usr=user.getName();

        String pwd= user.getPassword();

        Map session=ActionContext.getContext().getSession();
        userDAO.select();
        while (userDAO.resultSet.next()){
            if (userDAO.resultSet.getString("name").equals(usr) && userDAO.resultSet.getString("password").equals(pwd)){
//                user.setName(usr);
//                user.setPassword(pwd);
                if(userDAO.resultSet.getString("role").equals("读者")){//读者
                    user.setRole("读者");
                    session.put("nowUser",user);
                    return "reader";
                }else if(userDAO.resultSet.getString("role").equals("管理员")){//管理员
                    user.setRole("管理员");
                    session.put("nowUser",user);
                    return "admin";
                }
                else {
                   return ERROR;
                }
            }
        }
        return ERROR;
    }

    public String logout(){
        ActionContext context=ActionContext.getContext();
        Map session=context.getSession();
        User user= (User) session.get("nowUser");
        if(user==null){
            return ERROR;
        }else {
            session.remove("nowUser");
            return SUCCESS;
        }
    }


    public String allUser(){
        userArrayList=userDAO.selectAllUser();
        return SUCCESS;
    }

    public String addUser(){
        if(userDAO.insert(user)){
            this.addActionMessage("用户添加成功!");
            return SUCCESS;
        }else {
            this.addActionMessage("用户添加失败!");
            return ERROR;
        }
    }

    public String updateUser(){
        if(userDAO.update(user)){
            this.addActionMessage("读者修改成功!");
            return SUCCESS;
        }
        else {
            this.addActionMessage("读者修改失败!");
            return ERROR;
        }
    }

    public String deleteUser(){
        if(userDAO.delete(user)){
            this.addActionMessage("删除成功");
            return SUCCESS;
        }else {
            this.addActionMessage("删除失败");
            return ERROR;
        }
    }

    public String searchUser(){
        userArrayList.clear();
        userArrayList=userDAO.findUserByCondition("%"+condition+"%");
        if(userArrayList.isEmpty()) return ERROR;
        return SUCCESS;
    }

    public void validateLogin(){
        if(user!=null){
            if(user.getName().equals("")|| user.getName().trim().equals("")){
                this.addFieldError("user.name","用户名不能为空！");
            }
        }
    }

    public void validate(){
        if(user!=null){
            if(user.getPassword().equals("")|| user.getPassword().trim().equals("")){
                this.addFieldError("user.password","密码不能为空！");
            }
        }

   }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void setUserArrayList(ArrayList<User> userArrayList) {
        this.userArrayList = userArrayList;
    }

    public ArrayList<User> getUserArrayList() {
        return userArrayList;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
}
