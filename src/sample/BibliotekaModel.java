package sample;

import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class BibliotekaModel {
    private ObservableList<Knjiga> knjige = FXCollections.observableArrayList();
    private SimpleObjectProperty<Knjiga>  trenutna_knjiga = new SimpleObjectProperty<>();  // jer vraca knjigu a knjiga je klasa pa ide objectproperty


    public void napuni(){
        knjige.add(new Knjiga("Ivo Andrić","Travnicka hronika","123456"));
        knjige.add(new Knjiga("Meša Selimovic","Tvrđava","123645"));
        knjige.add(new Knjiga("George.R.R Martin","Igra Prijestolja","13243645"));
        trenutna_knjiga.set(null);
    }

    public ObservableList<Knjiga> getKnjige() {
        return knjige;
    }


    public void setKnjige(ObservableList<Knjiga> knjige) {
        this.knjige = knjige;
    }

    public Knjiga getTrenutna_knjiga() {
        return trenutna_knjiga.get();
    }

    public SimpleObjectProperty<Knjiga> trenutna_knjigaProperty() {
        return trenutna_knjiga;
    }

    public void setTrenutna_knjiga(Knjiga trenutna_knjiga) {
        this.trenutna_knjiga.set(trenutna_knjiga);
    }
}
