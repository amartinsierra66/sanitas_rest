package service;

import javax.ejb.Local;

import model.Venta;

@Local
public interface ProductorVentas {
	void enviarVenta(Venta venta);
}
