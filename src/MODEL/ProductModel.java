
package MODEL;


public class ProductModel {
    
    private int idProducts;
    private String code;
    private String name;
    private String type;
    private String manufactor; 
    private String barCode; 
    private String unity; 
    private int amount;

    public ProductModel() {
    }

    public ProductModel(int idProducts, String code, String name, String type, String manufactor, String barCode, String unity, int amount) {
        this.idProducts = idProducts;
        this.code = code;
        this.name = name;
        this.type = type;
        this.manufactor = manufactor;
        this.barCode = barCode;
        this.unity = unity;
        this.amount = amount;
    }

    public int getIdProducts() {
        return idProducts;
    }

    public void setIdProducts(int idProducts) {
        this.idProducts = idProducts;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getManufactor() {
        return manufactor;
    }

    public void setManufactor(String manufactor) {
        this.manufactor = manufactor;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getUnity() {
        return unity;
    }

    public void setUnity(String unity) {
        this.unity = unity;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}

