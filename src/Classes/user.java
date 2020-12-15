package Classes;

public class user {
    String id;
    String login;
    String password;
    public user(String id,String lo ,String password)
    {
        this.id =id;
        this.login=lo;
        this.password=password;
    }
    public user(String lo ,String password)
    {
        this.id =id;
        this.login=lo;
        this.password=password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
