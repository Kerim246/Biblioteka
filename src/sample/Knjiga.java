package sample;

import javafx.beans.property.SimpleStringProperty;

public class Knjiga {
    private SimpleStringProperty naslov,autor,isbn;

    public Knjiga() {
        autor = new SimpleStringProperty("");
        naslov = new SimpleStringProperty("");
        isbn = new SimpleStringProperty("");
    }

    public Knjiga(String autor, String naslov, String isbn) {
        this.autor = new SimpleStringProperty(autor);
        this.naslov = new SimpleStringProperty(naslov);
        this.isbn = new SimpleStringProperty(isbn);
    }

    public String getNaslov() {
        return naslov.get();
    }

    public SimpleStringProperty naslovProperty() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov.set(naslov);
    }

    public String getAutor() {
        return autor.get();
    }

    public SimpleStringProperty autorProperty() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor.set(autor);
    }

    public String getIsbn() {
        return isbn.get();
    }

    public SimpleStringProperty isbnProperty() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn.set(isbn);
    }

    @Override
    public String toString() {
        return autor.get() + ", "+ naslov.get() + ", "+ isbn.get();

    }
}
