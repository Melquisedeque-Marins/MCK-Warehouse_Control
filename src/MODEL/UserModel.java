package MODEL;

public class UserModel {
    
    private int id;
    private String name;
    private String user;
    private String password;
    private String autpassword; 
    private String perfil; 

    public UserModel() {
    }

    public UserModel(int id, String name, String user, String password, String autpassword, String perfil) {
        this.id = id;
        this.name = name;
        this.user = user;
        this.password = password;
        this.autpassword = autpassword;
        this.perfil = perfil;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAutPassword() {
        return autpassword;
    }

    public void setAutPassword(String autpassword) {
        this.autpassword = autpassword;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }
    
    
    
}
