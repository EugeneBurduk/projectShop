package model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "characteristic")
public class Characteristic {
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private Integer id;
    private String name;
    private Integer idSubcategory;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idSubcategory", nullable = false, insertable = false, updatable = false)

    private Subcategory subcategory;

    public Integer getIdSubcategory() {
        return idSubcategory;
    }

    public void setIdSubcategory(Integer idSubcategory) {
        this.idSubcategory = idSubcategory;
    }

    public Subcategory getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(Subcategory subcategory) {
        this.subcategory = subcategory;
    }

    public Characteristic() {}

    public Characteristic(String name, Integer idSubcategory) {
        this.name = name;
        this.idSubcategory = idSubcategory;
    }

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    @Override
    public String toString() {
        return "Characteristic{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", idSubcategory=" + idSubcategory +
                ", subcategory=" + subcategory +
                '}';
    }
      /*@JsonIgnore
    public Set<Product> getProduct() {
        return product;
    }

    public void setProduct(Set<Product> product) {
        this.product = product;
    }*/


   /* @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "characteristictoproduct",
            joinColumns = @JoinColumn(name = "idCharacteristic"),
            inverseJoinColumns = @JoinColumn(name = "idProduct"))
    private Set<Product> product;*/

}
