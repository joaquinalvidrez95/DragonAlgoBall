package db.app.view;

import db.app.MainApp;
import db.app.exception.IncapazDeTransformarse;
import db.app.model.entidad.personaje.estado.Personaje;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.awt.*;

public class transformarViewController {
    @FXML
    private Label nombrePersonaje;
    @FXML
    private Button cambiarEstadoBtn;
    @FXML
    private ImageView imagePersonaje;
    private TableroViewController tableroViewController;
    private Personaje personaje;
    private MainApp mainApp = MainApp.getInstance();

    @FXML
    private void initialize() {

    }

    public void setPersonaje(TableroViewController tableroViewController, Personaje person) {
        this.personaje = person;
        this.tableroViewController = tableroViewController;
        nombrePersonaje.setText(person.getEstadoDelPersonaje().getNombreEstado());
        Image img = new Image(person.getSrcProfilImg());
        imagePersonaje.setImage(img);
    }

    @FXML
    private void onCLickCambiarEstado() {
        try {
            personaje.transformar();
            tableroViewController.loadPersonajesEnemigosDeLaTierra();
            tableroViewController.loadPersonajesGuerrerosZ();
        } catch (IncapazDeTransformarse e) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("Impossible");
            alert.setHeaderText(personaje.getNombre());
            alert.setContentText("No tiene la recursos suficiente para transformarse");

            alert.showAndWait();
        }
    }
}