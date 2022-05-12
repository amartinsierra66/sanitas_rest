package servlets;

import java.io.IOException;
import java.util.Date;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.DaoLibros;
import model.Cliente;
import model.Libro;
import model.Venta;
import service.ProductorVentas;

/**
 * Servlet implementation class ComprarAction
 */
@WebServlet("/ComprarAction")
public class ComprarAction extends HttpServlet {
	@EJB
	ProductorVentas productor;
	@EJB
	DaoLibros daoLibros;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Date fecha=new Date();
		//recuperamos los datos necesarios para construir objeto Venta
		Cliente cliente=(Cliente)request.getSession().getAttribute("cliente");
		int isbn=Integer.parseInt(request.getParameter("isbn"));
		Libro libro=daoLibros.recuperarLibroPorIsbn(isbn);
		productor.enviarVenta(new Venta(0,fecha,libro,cliente));
		
	}

}
