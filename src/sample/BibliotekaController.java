package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class BibliotekaController {
    public ChoiceBox<Knjiga> choiceKnjige;
    public TextField fldAutor;
    public TextField fldNaslov;
    public TextField fldIsbn;

    private BibliotekaModel model;

    public BibliotekaController(BibliotekaModel model){
        this.model = model;
    }


    @FXML
    public void initialize(){ // initialize je metoda koja se pokrece odma kada se prozor otvori
        choiceKnjige.setItems(model.getKnjige());
        model.trenutna_knjigaProperty().addListener(
            (obs,oldKnjiga,newKnjiga) -> {
                if(oldKnjiga != null ){
                    fldAutor.textProperty().unbindBidirectional(oldKnjiga.autorProperty());           // Ako hocemo da selektiramo izaberemo drugu knjigu ovo "obrise" staru
                    fldNaslov.textProperty().unbindBidirectional(oldKnjiga.naslovProperty());
                    fldIsbn.textProperty().unbindBidirectional(oldKnjiga.isbnProperty());


                }

                if(newKnjiga == null){
                    fldAutor.setText("");      // Ako nema nove knjige stavi string na prazan
                    fldNaslov.setText("");
                    fldIsbn.setText("");
                }
                else {
                    fldAutor.textProperty().bindBidirectional(newKnjiga.autorProperty());    // Ako nije stavi tu novu knjigu
                    fldNaslov.textProperty().bindBidirectional(newKnjiga.naslovProperty());
                    fldIsbn.textProperty().bindBidirectional(newKnjiga.isbnProperty());
                }

        }
        );
    }


    // SimpleSTringProperty sluzi za povezivanje stringa sa vrijednoscu na grafickom interfejsu
    public void promjenaKnjige(ActionEvent actionEvent) {
        model.setTrenutna_knjiga(choiceKnjige.getValue());  // vratit vrijednost knjige koja je trenutno izabrana

    }


    public void btnIspisi(ActionEvent actionEvent) {
    }
}
