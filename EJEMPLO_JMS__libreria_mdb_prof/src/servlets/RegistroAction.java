package servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.DaoClientes;
import model.Cliente;



@WebServlet("/RegistroAction")
public class RegistroAction extends HttpServlet {
	@EJB
	DaoClientes gestion;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
                Cliente c=new Cliente(0,request.getParameter("email"),
                request.getParameter("password"),                       
                        Integer.parseInt(request.getParameter("telefono")),
                        request.getParameter("email"));
		gestion.registrar(c);
		
		
	}

}
