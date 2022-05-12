package daos;

import java.util.List;

import javax.ejb.Local;

import model.Venta;

@Local
public interface DaoVentas {
	List<Venta> recuperarVentasCliente(int idCliente);
	void registrarVenta(Venta venta);
}
