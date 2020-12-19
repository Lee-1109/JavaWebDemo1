package model;

import java.io.Serializable;

public class LendPK implements Serializable {
    private String userName="1804";
    private String bookIsbn="901";

    @Override
    public int hashCode() {
        return this.userName.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if( obj instanceof LendPK){
            LendPK pk=(LendPK)obj;
            return this.userName.equals(pk.getUserName()) && this.bookIsbn.equals(pk.getBookIsbn());
        }
        return false;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public String getBookIsbn() {
        return bookIsbn;
    }

    public void setBookIsbn(String bookIsbn) {
        this.bookIsbn = bookIsbn;
    }
}
