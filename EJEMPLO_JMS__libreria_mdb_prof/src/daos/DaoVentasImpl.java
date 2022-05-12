package daos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Cliente;
import model.Venta;

/**
 * Session Bean implementation class DaoVentasImpl
 */
@Stateless
public class DaoVentasImpl implements DaoVentas {
	@PersistenceContext(unitName = "librosPU")
	EntityManager em; 
	@Override
	public List<Venta> recuperarVentasCliente(int idCliente) {
		Cliente cliente=em.find(Cliente.class, idCliente);
		return cliente.getVentas();
	}
	@Override
	public void registrarVenta(Venta venta) {
		em.persist(venta);
		
	}


}
