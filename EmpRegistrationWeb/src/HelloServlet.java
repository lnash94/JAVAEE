package com.emp.ejb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HelloServlet")
public class HelloServlet<HelloEjbLocal> extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    @EJB
	HelloEjbLocal helloEjbLocal;
    
    public HelloServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		
		try{
			
			
			InitialContext ic = new InitialContext();
			
			helloEjbLocal = (HelloEjbLocal) ic.lookup("java:app/EmpRegistration/HelloEjb!com.emp.ejb.HelloEjb");
			String msg =  helloEjbLocal.sayHello();
			out.println(msg);
			
			RequestDispatcher rd = request.getRequestDispatcher("message.jsp");
			request.setAttribute("Mess",msg);
			rd.forward(request, response);
			
			
		}catch(NamingException e){
			e.printStackTrace();
		}
	}

	

}
