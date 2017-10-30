package model;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "subcategory")
public class Subcategory {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private Integer id;
    private String name;
    private Integer idCategory;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idCategory",  nullable = false, insertable = false, updatable = false)
    private Category category;

    public Subcategory() {}

    public Subcategory(Integer id, String name, Integer idCategory) {
        this.id = id;
        this.name = name;
        this.idCategory = idCategory;

    }
    public Subcategory(String name) {
        this.name = name;

    }

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Integer getIdCategory() { return idCategory; }

    public void setIdCategory(Integer idCategory) { this.idCategory = idCategory; }

    public Category getCategory() { return category; }

    public void setCategory(Category category) { this.category = category; }

    @Override
    public String toString() {
        return "SubcategoryService{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", idCategory=" + idCategory +
                '}';
    }
}
