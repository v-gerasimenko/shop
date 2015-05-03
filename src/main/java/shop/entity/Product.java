package shop.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "products")
public class Product implements Serializable {
    private static final long serialVersionUID = 2L;
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;
    @NotEmpty
    @Column(name = "product_name")
    private String name;
    @NotNull
    @Column(name = "quantity")
    private Integer quantity;
    @NotNull
    @Column(name = "product_barcode")
    private Long barcode;
    @NotEmpty
    @Column(name = "product_type")
    private String type;
    @NotNull
    @Column(name = "price")
    private Long price;

    public Product() {
    }

    public Product(String name, Integer quantity, Long barcode, String type, Long price) {
        this.name = name;
        this.quantity = quantity;
        this.barcode = barcode;
        this.type = type;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Long getBarcode() {
        return barcode;
    }

    public void setBarcode(Long barcode) {
        this.barcode = barcode;
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
        return "Product{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", barcode=" + barcode +
                ", type='" + type + '\'' +
                ", price=" + price +
                '}';
    }

    public int getId() {
        return Id;
    }

}

