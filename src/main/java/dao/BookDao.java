package dao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import models.Book;

import java.util.List;


    public class BookDao {

        private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Biblioteca");

        public static void crearLibro(Book.Libro libro) {
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            em.persist(libro);
            em.getTransaction().commit();
            em.close();
        }

        public static void eliminarBook(Integer id) {
        }

        public List<Book.Libro> consultarLibrosDisponibles() {
            EntityManager em = emf.createEntityManager();
            List<Book.Libro> library = em.createQuery("SELECT l FROM Libro l WHERE l.disponible = true", Book.Libro.class).getResultList();
            em.close();
            return library;
        }

        public void actualizarLibro(Book.Libro libro) {
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            em.merge(libro);
            em.getTransaction().commit();
            em.close();
        }

        public void eliminarLibro(Integer id) {
            EntityManager em = emf.createEntityManager();
            Book.Libro libro = em.find(Book.Libro.class, id);
            if (libro != null) {
                em.getTransaction().begin();
                em.remove(libro);
                em.getTransaction().commit();
            }
            em.close();
        }

        public static void marcarComoNoDisponible(Integer id) {
            EntityManager em = emf.createEntityManager();
            Book.Libro libro = em.find(Book.Libro.class, id);
            if (libro != null) {
                em.getTransaction().begin();
                libro.setDisponible(false);
                em.merge(libro);
                em.getTransaction().commit();
            }
            em.close();
        }
    }


