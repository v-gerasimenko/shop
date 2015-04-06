package controller.entity_control;


import data_proccess.SupplierUtil;
import entity.Supplier;
import validation.SupplierValidator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SupplierEnterController extends HttpServlet {

    public static final String OK_PAGE = "jsp/correct.jsp";
    private SupplierValidator validator = new SupplierValidator();
    private SupplierUtil util = new SupplierUtil();

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String productType = request.getParameter("type");

        if (validator.isSupplierNameValid(name) && validator.isProductTypeValid(productType)) {
            Supplier supplier = new Supplier(name, productType);
            if (util.entityExists(supplier)) {
                response.sendError(402);
            } else {
                util.addEntity(supplier);
                response.sendRedirect(OK_PAGE);
            }
        } else {
            response.sendError(400);
        }
    }
}


