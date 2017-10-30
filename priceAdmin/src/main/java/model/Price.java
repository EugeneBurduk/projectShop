package model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Price {
    private int id;
    private String nameProduct;
    private double value;

    public Price(){}
    public Price(int id, String nameProduct, double value){
        this.id=id;
        this.nameProduct=nameProduct;
        this.value=value;
    }

    public Price(String nameProduct, double value) {
        this.value = value;
        this.nameProduct = nameProduct;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) { this.id = id;  }
    public String getNameProduct() {
        return nameProduct;
    }
    public void setNameProduct(String nameProduct) { this.nameProduct = nameProduct;  }
    public double getValue() {
        return value;
    }
    public void setValue(double value) { this.value = value;  }

    public String toString(){
        return "Id " + id + " nameProduct " + nameProduct+ " value "+ value;
    }
}
