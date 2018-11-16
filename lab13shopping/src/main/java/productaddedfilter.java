import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 import java.io.IOException;

//@WebFilter("/checkout")
public class productaddedfilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws ServletException, IOException {
        HttpServletRequest req= (HttpServletRequest) servletRequest;
        HttpServletResponse resp=(HttpServletResponse) servletResponse;
               HttpSession ses= req.getSession();
        if( ses.getAttribute("cart")!=null){
            RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/checkout.jsp");
            dispatcher.forward(req, resp);
        }
        else {
            RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/welcomecart.jsp");
            dispatcher.forward(req, resp);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void destroy() {

    }
}
