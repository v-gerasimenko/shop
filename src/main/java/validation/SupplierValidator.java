package validation;


public class SupplierValidator {
    public boolean isSupplierNameValid(String name) {
        if (!name.isEmpty()) {
            return true;
        } else return false;
    }
    public boolean isProductTypeValid(String type) {
        if (!type.isEmpty()) {
            return true;
        } else return false;
    }
}
