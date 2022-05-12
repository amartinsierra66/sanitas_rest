package servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.DaoVentas;
import model.Cliente;

/**
 * Servlet implementation class VentasAction
 */
@WebServlet("/VentasAction")
public class VentasAction extends HttpServlet {
	@EJB
	DaoVentas daoVentas;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cliente cliente=(Cliente)request.getSession().getAttribute("cliente");
		if(cliente!=null) {
			request.setAttribute("ventas", daoVentas.recuperarVentasCliente(cliente.getIdCliente()));
		}
	}

}
