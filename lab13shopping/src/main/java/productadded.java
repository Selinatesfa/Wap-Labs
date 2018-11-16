import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/productadded")
public class productadded extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession ses= req.getSession();
        String productname= req.getParameter("pro");
        String productprice= req.getParameter("pr");
        if( ses.getAttribute("cart")!=null){
            shoppingcart shop= (shoppingcart) ses.getAttribute("cart");
            shop.AddProduct(new product(productname,productprice));
            ses.setAttribute("products",shop.getProducts());
        }
        else {
            shoppingcart shop= new shoppingcart();
            shop.AddProduct(new product(productname,productprice));
            ses.setAttribute("cart",shop);
            ses.setAttribute("products",shop.getProducts());
        }

// adding collection og products
        RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/productadded.jsp");
        dispatcher.forward(req, resp);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        shoppingcart shop= new shoppingcart();
        String productname= req.getParameter("pro1");
        String productprice= req.getParameter("pr");
        shop.AddProduct(new product(productname,productprice));
        HttpSession ses= req.getSession();
        ses.setAttribute("cart",shop);
        RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/productadded.jsp");
        dispatcher.forward(req, resp);
    }
}
