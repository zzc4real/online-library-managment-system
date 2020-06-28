package Action;

import Dao.UserDao;
import Dao.ReaderDao;
import Entity.Reader;
import Entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginAction extends HttpServlet 
{
    UserDao udao = new UserDao(); //data access object
    ReaderDao rdao = new ReaderDao(); //data access object

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        String action = request.getParameter("action");
        if (action.equals("login")) {
            this.login(request, response);
        }
        if (action.equals("stulogin")){
        	this.stulogin(request, response);
        }
        else if(action.equals("logout")){
            this.logout(request, response);
        }
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        doPost(request, response);
    }
    
    private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        String username = null;
        String password = null;
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        username = request.getParameter("username");
        password = request.getParameter("password");
//        System.out.println(" ### 第二步：LoginAction action=Login 里调用udao 类 进行比较###");
//        System.out.println(username);
//        System.out.println(password);
        
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        String result = udao.login(user);
        if(result.equals("true")){
            session.setAttribute("adminname", user.getName());
            request.getRequestDispatcher("/main.jsp").forward(request, response);
        }
        else{
//        	System.out.println("this line test LoginAction.java");
            out.write(result);
        }
    }

    private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(1);
        session.setAttribute("logout", "1");
        response.sendRedirect("/Library/index.jsp");
    }
    
    /* ——————————————————————————————————————————————————————————————————--*/
    /*---- 分界线 -----  上面是 user= administrator   下面是 student = reader */
    /* ——————————————————————————————————————————————————————————————————--*/
    
    private void stulogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        String certiID = null;
        String stupassword = null;
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        certiID = request.getParameter("certiID");
        stupassword = request.getParameter("stupassword");
        System.out.println(certiID);
        System.out.println(stupassword);
        
        Reader reader = new Reader();
        reader.setCertiID(certiID);
        reader.setPassword(stupassword);
        String result = rdao.stulogin(reader);
        System.out.println("result = rdao.stulogin(reader) =" + result);
        if(result.equals("true"))
        {
        	out.write(result);
            session.setAttribute("certiID", reader.getCertiID());
            System.out.println("test test test");
//            response.sendRedirect("/Library/main.jsp");
            request.getRequestDispatcher("/stuMain.jsp").forward(request, response);
            System.out.println("test test test test test");
        }
        else{
            out.write(result);
        }
    }
}