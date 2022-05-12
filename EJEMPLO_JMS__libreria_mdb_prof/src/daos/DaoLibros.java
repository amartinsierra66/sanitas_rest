package daos;

import java.util.List;

import javax.ejb.Local;

import model.Libro;
@Local
public interface DaoLibros {

	List<Libro> recuperarLibros();

	List<Libro> recuperarLibros(int idTema);
	
	Libro recuperarLibroPorIsbn(int isbn);

}