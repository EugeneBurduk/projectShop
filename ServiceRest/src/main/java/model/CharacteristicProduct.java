package model;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "characteristicsproduct")
public class CharacteristicProduct {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private Integer id;
    private Integer idProduct;
    private String nameCharacteristic;
    private String value;

    public CharacteristicProduct(Integer idProduct, String nameCharacteristic, String value) {
        this.idProduct = idProduct;
        this.nameCharacteristic = nameCharacteristic;
        this.value = value;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idProduct", nullable = false, insertable = false, updatable = false)
    private Product product;

    public CharacteristicProduct() {
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getNameCharacteristic() {
        return nameCharacteristic;
    }

    public void setNameCharacteristic(String nameCharacteristic) {
        this.nameCharacteristic = nameCharacteristic;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }



    @Override
    public String toString() {
        return "CharacteristicProduct{" +
                "id=" + id +
                ", value='" + value + '\'' +
                ", idProduct" +idProduct+
                ", characteristic=" + nameCharacteristic +
                ", product=" + product +
                '}';
    }
}
