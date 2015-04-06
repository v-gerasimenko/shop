package controller.bucket;

import data_proccess.ProductUtil;
import entity.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AllProductController extends HttpServlet {
    public static final String ALL_PRODUCTS_PAGE = "jsp/allProducts.jsp";
    public static final String ATTRIBUTE = "productList";
    private ProductUtil util = new ProductUtil();

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Product> products = util.selectAll();
            request.setAttribute(ATTRIBUTE, products);
            RequestDispatcher dispatcher = request.getRequestDispatcher(ALL_PRODUCTS_PAGE);
            dispatcher.forward(request, response);
            return;
        } catch (Exception ignore) {
        }

    }
}