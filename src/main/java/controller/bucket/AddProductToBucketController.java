package controller.bucket;

import controller.SessionAttributes;
import data_proccess.ProductUtil;
import entity.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class AddProductToBucketController extends HttpServlet {
    public static final String PARAM_ID = "id";
    private ProductUtil utility = new ProductUtil();

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {
        String idStr = request.getParameter(PARAM_ID);
        if (idStr != null) {
            try {
                Integer id = Integer.valueOf(idStr);
                Product product = utility.getById(id);
                HttpSession session = request.getSession(true);
                Map<Product, Integer> oldBucket = (Map<Product, Integer>)
                        session.getAttribute(SessionAttributes.PRODUCTS_IN_BUCKET);
                AtomicLong totalPrice = (AtomicLong)
                        session.getAttribute(SessionAttributes.TOTAL_PRICE);
                if (oldBucket == null && totalPrice == null) {
                    session.setAttribute(SessionAttributes.PRODUCTS_IN_BUCKET,
                            Collections.singletonMap(product, 1));
                    totalPrice = new AtomicLong(0);
                    session.setAttribute(SessionAttributes.TOTAL_PRICE,
                            totalPrice.addAndGet(product.getPrice()));
                } else {
                    Map<Product, Integer> newBucket = new LinkedHashMap<>(oldBucket);
                    if (!oldBucket.containsKey(product)) {
                        newBucket.put(product, 1);
                        totalPrice.addAndGet(product.getPrice());
                    } else {
                        newBucket.put(product, newBucket.get(product) + 1);
                        totalPrice.addAndGet(product.getPrice());
                    }
                    session.setAttribute(SessionAttributes.PRODUCTS_IN_BUCKET,
                            Collections.unmodifiableMap(newBucket));
                }
                session.setAttribute(SessionAttributes.TOTAL_PRICE, totalPrice);
                String newLocation = "product.do?id=" + id;
                RequestDispatcher dispatcher = request.getRequestDispatcher(newLocation);
                dispatcher.forward(request, response);

            } catch (Exception ignore) {
            }
        }

    }

}
