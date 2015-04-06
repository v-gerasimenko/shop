package entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Supplier implements Serializable{
    private static final long serialVersionUID = 2L;
    @Id
    @Column(name = "name")
    private String name;
    @Column(name = "product_type")
    private String productType;
;
    public Supplier() {
    }

    public Supplier(String name, String productType) {
        this.name = name;
        this.productType = productType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Supplier supplier = (Supplier) o;

        if (name != null ? !name.equals(supplier.name) : supplier.name != null) return false;
        if (productType != null ? !productType.equals(supplier.productType) : supplier.productType != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (productType != null ? productType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "name='" + name + '\'' +
                ", productType='" + productType + '\'' +
                '}';
    }
}


