package service;

import java.util.List;

import model.Hotel;

public interface HotelesService {
	List<Hotel> hotelesDisponibles();
	Hotel hotel(String nombre);
}
