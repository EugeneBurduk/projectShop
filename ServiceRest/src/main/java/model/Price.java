package model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Price {
    private int id;
    private String nameProduct;
    private float value;

    public Price(){}
    public Price(int id, String nameProduct, float value){
        this.id=id;
        this.nameProduct=nameProduct;
        this.value=value;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) { this.id = id;  }
    public String getNameProduct() {
        return nameProduct;
    }
    public void setNameProduct(String nameProduct) { this.nameProduct = nameProduct;  }
    public float getValue() {
        return value;
    }
    public void setValue(float value) { this.value = value;  }

    public String toString(){
        return "Id " + id + " nameProduct " + nameProduct+ " value "+ value;
    }
}
