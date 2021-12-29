package MODEL;

public class RequesterModel {
   private int idRequester;
   private String name;
   private String code;

    public RequesterModel() {
    }

    public RequesterModel(int idRequester, String name, String code) {
        this.idRequester = idRequester;
        this.name = name;
        this.code = code;
    }

    public int getIdRequester() {
        return idRequester;
    }

    public void setIdRequester(int idRequester) {
        this.idRequester = idRequester;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
