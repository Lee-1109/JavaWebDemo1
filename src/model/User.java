package model;

public class User {

    private String name;
    //账户密码
    private String password;
    //用户类型 1管理员 0读者
    private String role;

    public User(){}

    public User(String name,String psw){
        this.name=name;
        this.password=psw;
    }
    public User(String name,String psw,String role){
        this.name=name;
        this.password=psw;
        this.role=role;
    }
    public String getName() {
        return name;
    }

    public void setName(final String name){
        this.name=name;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
