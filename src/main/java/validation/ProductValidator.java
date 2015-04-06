package validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProductValidator {

    public boolean isProductNameValid(String name) {
        if (!name.isEmpty()) {
            return true;
        } else return false;
    }

    public boolean isProductQuantityValid(String quantity) {
        Matcher matcher = Pattern.compile("[0-9]+").matcher(quantity);
        if (matcher.matches()) {
            return true;
        } else return false;

    }

    public boolean isProductBarcodeValid(String barcode) {
        Matcher matcher = Pattern.compile("[0-9]+").matcher(barcode);
        if (matcher.matches()) {
            return true;
        } else return false;

    }

    public boolean isProductTypeValid(String type) {
        if (!type.isEmpty()) {
            return true;
        } else return false;
    }

    public boolean isProductPriceValid(String price) {
        Matcher matcher = Pattern.compile("[0-9]+").matcher(price);
        if (matcher.matches()) {
            return true;
        } else return false;

    }
}
