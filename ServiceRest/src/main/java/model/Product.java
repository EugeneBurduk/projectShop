package model;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private Integer id;
    private String name;
    private String photo;
    private Integer rating;
    private Integer idProducer;
    private Integer idSubcategory;
    private Integer countProduct;

    public Product(Integer id,String name,  String photo,Integer rating, Integer idProducer, Integer idSubcategory, Integer countProduct) {
        this.name = name;
        this.rating = rating;
        this.photo = photo;
        this.idProducer = idProducer;
        this.idSubcategory = idSubcategory;
        this.countProduct = countProduct;
        this.id= id;
    }

    @ManyToOne(fetch = FetchType.EAGER)

    @JoinColumn(name = "idProducer", nullable = false, insertable = false, updatable = false)
    private Producer producer;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idSubcategory", nullable = false, insertable = false, updatable = false)
    private Subcategory subcategory;

    public Integer getCountProduct() {
        return countProduct;
    }

    public void setCountProduct(Integer countProduct) {
        this.countProduct = countProduct;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public Subcategory getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(Subcategory subcategory) {
        this.subcategory = subcategory;
    }

    public Product() {}

    public Product(String name, String photo, Integer rating, Integer idProducer, Integer idSubcategory, Integer countProduct) {
        this.name = name;
        this.photo = photo;
        this.rating = rating;
        this.idProducer = idProducer;
        this.idSubcategory = idSubcategory;
        this.countProduct = countProduct;
    }
    public Product(String name, String photo, Integer rating, Integer idProducer, Integer idSubcategory,Integer countProduct, Producer producer, Subcategory subcategory) {
        this.name = name;
        this.photo = photo;
        this.rating = rating;
        this.idProducer = idProducer;
        this.idSubcategory = idSubcategory;
        this.producer = producer;
        this.subcategory = subcategory;
        this.countProduct = countProduct;
    }

    public Product(String name,  Producer producer, Subcategory subcategory, String photo) {
        this.name = name;
        this.photo = photo;
        this.producer = producer;
        this.subcategory = subcategory;
    }

    public Product(String name, Integer idProducer, Integer idSubcategory) {
        this.name = name;
        this.idProducer = idProducer;
        this.idSubcategory = idSubcategory;
    }

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getPhoto() { return photo; }

    public void setPhoto(String photo) { this.photo = photo; }

    public Integer getRating() { return rating; }

    public void setRating(Integer rating) { this.rating = rating; }

    public Integer getIdProducer() { return idProducer; }

    public void setIdProducer(Integer idProducer) { this.idProducer = idProducer; }

    public Integer getIdSubcategory() { return idSubcategory; }

    public void setIdSubcategory(Integer idSubcategory) { this.idSubcategory = idSubcategory;}

 /*   @JsonIgnore
    public Set<Characteristic> getCharacteristic() {
        return characteristic;
    }

    public void setCharacteristic(Set<Characteristic> characteristic) {
        this.characteristic = characteristic;
    }*/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (id != null ? !id.equals(product.id) : product.id != null) return false;
        if (name != null ? !name.equals(product.name) : product.name != null) return false;
        if (photo != null ? !photo.equals(product.photo) : product.photo != null) return false;
        if (rating != null ? !rating.equals(product.rating) : product.rating != null) return false;
        if (idProducer != null ? !idProducer.equals(product.idProducer) : product.idProducer != null) return false;
        if (idSubcategory != null ? !idSubcategory.equals(product.idSubcategory) : product.idSubcategory != null)
            return false;
        if (producer != null ? !producer.equals(product.producer) : product.producer != null) return false;
        return subcategory != null ? subcategory.equals(product.subcategory) : product.subcategory == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (photo != null ? photo.hashCode() : 0);
        result = 31 * result + (rating != null ? rating.hashCode() : 0);
        result = 31 * result + (idProducer != null ? idProducer.hashCode() : 0);
        result = 31 * result + (idSubcategory != null ? idSubcategory.hashCode() : 0);
        result = 31 * result + (producer != null ? producer.hashCode() : 0);
        result = 31 * result + (subcategory != null ? subcategory.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", photo='" + photo + '\'' +
                ", rating=" + rating +
                ", idProducer=" + idProducer +
                ", idSubcategory=" + idSubcategory +
                ", producer=" + producer +
                ", subcategory=" + subcategory +
                '}';
    }
}
