package entity;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "products")
public class Product implements Serializable {
    private static final long serialVersionUID = 2L;
    @javax.persistence.Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;
    @Column(name = "product_name")
    private String name;
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "product_barcode")
    private Long barcode;
    @Column(name = "product_type")
    private String type;
    @Column(name = "price")
    private Long price;
    @OneToOne
    @JoinColumn(name = "supplier", referencedColumnName = "name", nullable = false)
    private Supplier supplier;

    public Product() {
    }

    public Product(String name, Integer quantity, Long barcode, String type, Long price, Supplier supplier) {
        this.name = name;
        this.quantity = quantity;
        this.barcode = barcode;
        this.type = type;
        this.price = price;
        this.supplier = supplier;

    }

    public long getBarcode() {
        return barcode;
    }

    public void setBarcode(long barcode) {
        this.barcode = barcode;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (Id != null ? !Id.equals(product.Id) : product.Id != null) return false;
        if (barcode != null ? !barcode.equals(product.barcode) : product.barcode != null) return false;
        if (name != null ? !name.equals(product.name) : product.name != null) return false;
        if (price != null ? !price.equals(product.price) : product.price != null) return false;
        if (quantity != null ? !quantity.equals(product.quantity) : product.quantity != null) return false;
        if (type != null ? !type.equals(product.type) : product.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = Id != null ? Id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        result = 31 * result + (barcode != null ? barcode.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Name: " + name + " Quantity: " + quantity + " Barcode: " + barcode + " Type: " + type;

    }

    public int getId() {
        return Id;
    }

}

