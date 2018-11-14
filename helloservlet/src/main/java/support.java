import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.*;
import java.lang.String;

import static java.lang.Integer.parseInt;

@WebServlet("/support")
public class support extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.print("<html><head><title>Test</title></head><body>");
        out.print("<form method='POST' action='/support'>");
        out.print( "Name:<input name='nm'>");
        out.print(" Email address: <input name='email'><br>");
        out.print("Problem: <textarea name='ta' rows=20 cols=30></textarea><br>");
        out.print("<input type='submit' value='Help'/>");
        out.print("</form>");
        out.print("</body></html>");
               }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        String name= req.getParameter("nm");
        String email= req.getParameter("email");
              ServletContext sc = this.getServletContext();
       String sup= sc.getInitParameter("support-email");
               String id= sc.getInitParameter("id");
               int finalId=parseInt(id);
               finalId++;
               out.print("<html><head><title>Test</title></head><body>");
        out.print("<p>Thank you! "+name+ "  for contacting us. You should receive reply from us with in 24 hrs " +
                "in your email address"+email + "   Let us know in our support email "+ sup +"   support-email if you" +
                "if you don’t receive reply within 24 hrs. Please be sure to attach your reference "+
                finalId +"  in your email.</p>");
        out.print("</body></html>");
    }
}
