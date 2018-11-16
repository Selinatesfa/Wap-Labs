import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/checkout")
public class checkout extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name= req.getParameter("un");
        String password= req.getParameter("pw");
        boolean rememberme= req.getParameter("rm")!=null;
        PrintWriter out= resp.getWriter();
        HttpSession ses=req.getSession();
        if( name.length()!=0 && password.length()> 3 ){
            check newcheck= new check();
            if(newcheck.validate(name,password))
            {
                user ur= new user(name,password);
                ses.setAttribute("username",ur);
                ses.setAttribute("remember",rememberme);
                if (rememberme){
                    Cookie cook= new Cookie("username",name);
                    cook.setMaxAge(32400);
                    resp.addCookie(cook);

                }
                else{
                    for (Cookie cookie : req.getCookies()) {
                        if (cookie.getName().equals("username")) {
                            cookie.setMaxAge(-1);
                        } }
                }
            }
            else
            {
                RequestDispatcher dispatcher = req.getRequestDispatcher("Login.jsp");
                dispatcher.forward(req, resp);
            }
        }
        else {

            ses.setAttribute("errormsg","enter user name and password correctly");
            RequestDispatcher dispatcher = req.getRequestDispatcher("Login.jsp");
            dispatcher.forward(req, resp);
            //((HttpServletResponse) response).sendRedirect("/Login");
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/checkout.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/checkout.jsp");
        dispatcher.forward(req, resp);
    }
}
