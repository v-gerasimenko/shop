package controller.entity_control;

import data_proccess.ProductUtil;
import data_proccess.SupplierUtil;
import entity.Product;
import validation.ProductValidator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ProductEnterController extends HttpServlet {
    public static final String OK_PAGE = "jsp/correct.jsp";
    private ProductValidator validator = new ProductValidator();
    private ProductUtil util = new ProductUtil();
    private SupplierUtil supUtil = new SupplierUtil();

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String quantity = request.getParameter("quantity");
        String barcode = request.getParameter("barcode");
        String type = request.getParameter("type");
        String price = request.getParameter("price");
        String supplier = request.getParameter("supplier");

        if (validator.isProductNameValid(name) && validator.isProductQuantityValid(quantity)
                && validator.isProductBarcodeValid(barcode)
                && validator.isProductTypeValid(type) && validator.isProductPriceValid(price)
                && supUtil.checkByName(supplier)) {

            Product product = new Product(name, Integer.parseInt(quantity),
                    Long.parseLong(barcode), type, Long.parseLong(price),
                    supUtil.getByName(supplier));

                if (util.entityExists(product)) {
                    response.sendError(401);
                } else {
                    util.addEntity(product);
                    response.sendRedirect(OK_PAGE);
                }

        } else {
            response.sendError(400);
        }
    }
}
