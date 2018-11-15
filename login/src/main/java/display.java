import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/display")
public class display extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name= req.getParameter("un");
        String password= req.getParameter("pw");
               PrintWriter out = resp.getWriter();
        // check ch= user ur
      user ur=  new user(name,password);
        new check(ur);
        HttpSession ses= req.getSession();
        String rememberme= ses.getAttribute("remember").toString();
       if((rememberme.equalsIgnoreCase("False"))){
    //Cookie cookie = new Cookie("username", ur.toString());
           for (Cookie cookie : req.getCookies()) {
               if (cookie.getName().equals("username")|| cookie.getName().equals("password")) {
                   cookie.setMaxAge(0);
               } }
     //in seconds
    }
else {

           Cookie usercookie = new Cookie("username", name);
           usercookie.setMaxAge(42300); //in seconds
           resp.addCookie(usercookie);
           Cookie passwordcookie = new Cookie("password", password);
           passwordcookie.setMaxAge(42300); //in seconds
           resp.addCookie(passwordcookie);
       }

        //  use session
// forward to welcome.jsp
        RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/welcome.jsp");
        dispatcher.forward(req, resp);

    }
}
