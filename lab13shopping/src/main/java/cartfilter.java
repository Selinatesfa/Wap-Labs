import com.sun.net.httpserver.HttpExchange;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter("/checkout")
public class cartfilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        String name= req.getParameter("un");
        String password= req.getParameter("pw");
        boolean rememberme= req.getParameter("rm")!=null;
        //session


        // String res= ses.getAttribute("username").toString();
        //
        PrintWriter out= resp.getWriter();

        if( name.length()!=0 && password.length()> 3 ){
            check newcheck= new check();
            if(newcheck.validate(name,password))
            {
                HttpSession ses=req.getSession();
                user ur= new user(name,password);
                ses.setAttribute("username",ur);
                ses.setAttribute("remember",rememberme);
                chain.doFilter(request, response);
            }
            else
                          {

                ((HttpServletResponse) response).sendRedirect("/Login");
            }
        }
        else {

            out.print("enter user name correctly");
            // RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            //  dispatcher.forward(request, response);
            ((HttpServletResponse) response).sendRedirect("/Login");
        }
//
    }
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }

}
