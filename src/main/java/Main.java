import dao.BookDao;
import models.Book;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Crear una instancia de BookDAO
        BookDao bookDAO = new BookDao();

        // Crear un nuevo libro
        Book.Libro book = new Book.Libro("1984", "George Orwell", 1949, true);
        bookDAO.crearLibro(book);

        // Consultar libros disponibles
        List<Book.Libro> availableBooks = bookDAO.consultarLibrosDisponibles();
        availableBooks.forEach(b -> System.out.println(b.getTitulo()));

        // Actualizar un libro
        book.setTitulo("1984 (Updated Edition)");
        bookDAO.actualizarLibro(book);

        // Marcar un libro como no disponible
        BookDao.marcarComoNoDisponible(book.getId());

        // Eliminar un libro
        bookDAO.eliminarLibro(book.getId());
    }
}
