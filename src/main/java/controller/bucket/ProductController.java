package controller.bucket;

import data_proccess.ProductUtil;
import entity.Product;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ProductController extends HttpServlet {
    public static final String PARAM_ID = "id";
    public static final String PAGE = "jsp/product.jsp";
    public static final String ATTRIBUTE = "product";
    private ProductUtil util = new ProductUtil();

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {

        String idStr = request.getParameter(PARAM_ID);
        Integer id = Integer.valueOf(idStr);
        Product product = util.getById(id);
        request.setAttribute(ATTRIBUTE, product);

        RequestDispatcher dispatcher = request.getRequestDispatcher(PAGE);
        dispatcher.forward(request, response);
    }
}
