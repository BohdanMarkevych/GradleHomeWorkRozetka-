package model;


import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="searchFilter")
public class SearchFilter {

    private String productType;
    private  String brand;
    private  int allowedSum;

    public  String getProductType() {
        return productType;
    }

    public  String getBrand() {
        return brand;
    }

    public  int getAllowedSum() {
        return allowedSum;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setAllowedSum(int allowedSum) {
        this.allowedSum = allowedSum;
    }

}

