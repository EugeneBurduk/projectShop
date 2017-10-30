package model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "`order`")
public class Order {
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private Integer id;
    private Integer idUser;
    private Integer idProduct;
    private boolean buy;
    private boolean receive;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idProduct", nullable = false, insertable = false, updatable = false)
    private Product product;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idUser", nullable = false, insertable = false, updatable = false)
    private User user;

    public Order(Integer idUser, Integer idProduct, boolean buy, boolean receive) {
        this.idUser = idUser;
        this.idProduct = idProduct;
        this.buy = buy;
        this.receive = receive;
    }

    public Order(Integer id,Integer idUser, Integer idProduct, boolean buy, boolean receive) {
        this.idUser = idUser;
        this.idProduct = idProduct;
        this.buy = buy;
        this.receive = receive;
        this.id=id;
    }
    public Order() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public boolean isBuy() {
        return buy;
    }

    public void setBuy(boolean buy) {
        this.buy = buy;
    }

    public boolean isReceive() {
        return receive;
    }

    public void setReceive(boolean receive) {
        this.receive = receive;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", idUser=" + idUser +
                ", idProduct=" + idProduct +
                ", buy=" + buy +
                ", receive=" + receive +
                ", product=" + product +
                ", user=" + user +
                '}';
    }
}
