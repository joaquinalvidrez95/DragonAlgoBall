package db.app.view;

import db.app.MainApp;
import db.app.exception.*;
import db.app.model.entidad.personaje.estado.Personaje;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

import java.awt.*;
import java.io.IOException;

public class AtacarViewController{
    @FXML
    private Label nombrePersonaje;
    @FXML
    private Button cambiarEstadoBtn;
    @FXML
    private ImageView imagePersonaje;
    private Personaje personajeQueRecibe;
    private Personaje personajeQueAtaca;
    private MainApp mainApp = MainApp.getInstance();
    private TableroViewController tableroViewController;

    @FXML
    private void initialize() {

    }

    public void setPersonaje(TableroViewController tableroViewController, Personaje personajeQueRecibe, Personaje personajeQueAtaca) {
        this.personajeQueRecibe = personajeQueRecibe;
        this.personajeQueAtaca = personajeQueAtaca;
        this.tableroViewController = tableroViewController;

        nombrePersonaje.setText(personajeQueRecibe.getNombre());
        Image img = new Image(personajeQueRecibe.getSrcProfilImg());
        imagePersonaje.setImage(img);
    }

    @FXML
    private void onCLickAtaque() throws ElPersonajeEstaMuerto, JugadorYaHabiaAtacado, NoEsTurnoDeJugador, StringVacio, NoExistePersonaje, IOException, CeldaVacia, CasilleroNoExistente, AtaqueAlMismoEquipo {
        try {
            mainApp.getDragonModel().atacarPersonaje(personajeQueAtaca, personajeQueRecibe);
            int idPersonajeQueRecibe = personajeQueRecibe.getPosicion().getX() * tableroViewController.getAltura() + personajeQueRecibe.getPosicion().getY() + 1;
            StackPane stackpanePersonajeQueRecibe = (StackPane) (tableroViewController.getTablero().getChildren().get(idPersonajeQueRecibe));
            stackpanePersonajeQueRecibe.getChildren().clear();
            tableroViewController.setMouveMovimientoClickToStackPane(stackpanePersonajeQueRecibe);
            tableroViewController.refresh();
        } catch (DistanciaDeAtaqueInsuficiente e) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("Ataque");
            alert.setHeaderText(personajeQueAtaca.getNombre());
            alert.setContentText("No puede atacar :" + personajeQueRecibe.getNombre() + " demasiado lejos");
            alert.showAndWait();
        } catch (PersonajeEstaInhabilitado e1) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("Ataque");
            alert.setHeaderText(personajeQueAtaca.getNombre());
            alert.setContentText("Esta en forma de chocolate !");
            alert.showAndWait();
        }
    }

    @FXML
    private void onCLickAtaqueEspecial() throws PersonajeEstaInhabilitado, ElPersonajeEstaMuerto, StringVacio, NoExistePersonaje, IOException, AtaqueAlMismoEquipo, CeldaVacia, NoEsTurnoDeJugador, JugadorYaHabiaAtacado, DistanciaDeAtaqueInsuficiente, CasilleroNoExistente, KiInsuficiente {
        try {
                mainApp.getDragonModel().usarAtaqueEspecial(personajeQueAtaca, personajeQueRecibe);
                int idPersonajeQueRecibe = personajeQueRecibe.getPosicion().getX() * tableroViewController.getAltura() + personajeQueRecibe.getPosicion().getY() + 1;
                StackPane stackpanePersonajeQueRecibe = (StackPane) (tableroViewController.getTablero().getChildren().get(idPersonajeQueRecibe));
                stackpanePersonajeQueRecibe.getChildren().clear();
                tableroViewController.setMouveMovimientoClickToStackPane(stackpanePersonajeQueRecibe);
             tableroViewController.refresh();
            } catch (DistanciaDeAtaqueInsuficiente e ) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("Ataque Especial");
            alert.setHeaderText(personajeQueAtaca.getNombre());
            alert.setContentText("No puede atacar :" + personajeQueRecibe.getNombre() + " demasiado lejos");
            alert.showAndWait();
        }
            catch (KiInsuficiente e ) {
                Alert alert = new Alert(AlertType.WARNING);
                alert.initOwner(mainApp.getPrimaryStage());
                alert.setTitle("Ataque Especial");
                alert.setHeaderText(personajeQueAtaca.getNombre());
                alert.setContentText("No puede atacar :" + personajeQueRecibe.getNombre() + " KI insufisiente");
                alert.showAndWait();
            }
    }


}