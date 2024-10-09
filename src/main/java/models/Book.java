package models;
import jakarta.persistence.*;



public class Book {

    private String titulo;

    public Book(String number, String georgeOrwell, int i, boolean b) {
    }

    public void forEach(Object object) {
    }

    public Integer getId() {
        return 0;
    }

    public String getTitulo() {
        return titulo;
    }


    @Entity
    @Table(name = "libros")
    public static class Libro {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        @Column(nullable = false)
        private String titulo;

        @Column(nullable = false)
        private String autor;

        @Column(name = "anio_publicacion")
        private Integer anioPublicacion;

        @Column(nullable = false)
        private Boolean disponible;

        // Constructores
        public Libro() {}

        public Libro(String titulo, String autor, Integer anioPublicacion, Boolean disponible) {
            this.titulo = titulo;
            this.autor = autor;
            this.anioPublicacion = anioPublicacion;
            this.disponible = disponible;
        }

        // Getters y Setters
        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getTitulo() {
            return titulo;
        }

        public void setTitulo(String titulo) {
            this.titulo = titulo;
        }

        public String getAutor() {
            return autor;
        }

        public void setAutor(String autor) {
            this.autor = autor;
        }

        public Integer getAnioPublicacion() {
            return anioPublicacion;
        }

        public void setAnioPublicacion(Integer anioPublicacion) {
            this.anioPublicacion = anioPublicacion;
        }

        public Boolean getDisponible() {
            return disponible;
        }

        public void setDisponible(Boolean disponible) {
            this.disponible = disponible;
        }
    }





}
