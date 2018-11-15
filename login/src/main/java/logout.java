import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/logout")
public class logout extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession ses=req.getSession();
        ses.invalidate(); // destroying session
        PrintWriter out =resp.getWriter();
        //"session destroyed"
        out.print(req.getParameter("rm"));
        RequestDispatcher dispatcher = req.getRequestDispatcher("/Login");
        dispatcher.forward(req, resp);
    }
}
