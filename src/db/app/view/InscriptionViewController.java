package db.app.view;

import db.app.MainApp;
import db.app.exception.CampoVacioException;
import db.app.model.entidad.personaje.DragonBallZParametros;
import db.app.model.entidad.personaje.estado.Personaje;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;

public class InscriptionViewController {
    @FXML
    private TableView<Personaje> personTable;
    @FXML
    private TableColumn<Personaje, String> namePersonajeColumn;
    @FXML
    private TableColumn<Personaje, String> equipoPersonajeColumn;
    @FXML
    private TextField nameJugadorUno;
    @FXML
    private TextField nameJugadorDos;
    @FXML
    private Label logNameJugadorUno;
    @FXML
    private Label logNameJugadorDos;
    @FXML
    private ComboBox<String> equipoJugadorUno;
    @FXML
    private ComboBox<String> equipoJugadorDos;
    @FXML
    private ComboBox<Text> tamanioTablero;

    private MainApp mainApp = MainApp.getInstance();
    private String guerrerosZ = DragonBallZParametros.NombresDeEquipos.ParametrosDeGuerrerosZ.GUERREROS_Z;
    private String enemigosDTR = DragonBallZParametros.NombresDeEquipos.ParamentrosDeEnemigosDeLaTierra.ENEMIGOS_DE_LA_TIERRA;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public InscriptionViewController() {
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        // Initialize the Combobox with the name of each team
        ObservableList<String> equipo = FXCollections.observableArrayList();
        ObservableList<Text> tamanio = FXCollections.observableArrayList();
        ObservableList<Personaje> personData = FXCollections.observableArrayList();
        Text dimension7 = new Text("7 x 7");
        dimension7.setX(7);
        dimension7.setY(7);
        Text dimension9 = new Text("9 x 9");
        dimension9.setX(9);
        dimension9.setY(9);
        Text dimension11 = new Text("11 x 11");
        dimension11.setX(11);
        dimension11.setY(11);

        tamanio.add(dimension7);
        tamanio.add(dimension9);
        tamanio.add(dimension11);
        tamanioTablero.setItems(tamanio);
        tamanioTablero.getSelectionModel().select(dimension7);

        equipo.add(enemigosDTR);
        equipo.add(guerrerosZ);


        equipoJugadorDos.setItems(equipo);
        equipoJugadorDos.getSelectionModel().select(guerrerosZ);
        equipoJugadorUno.setItems(equipo);
        equipoJugadorUno.getSelectionModel().select(enemigosDTR);


        // Initialize the person table with the two columns.
        List<Personaje> listPersonajeEnmigosDeLaTierra = new ArrayList<>(mainApp.getDragonModel().getEquipos().get(DragonBallZParametros.NombresDeEquipos.ParamentrosDeEnemigosDeLaTierra.ENEMIGOS_DE_LA_TIERRA).getmColeccionDePersonajes().getmPersonajes().values());
        List<Personaje> listPersonajeGuerrerosZ = new ArrayList<>(mainApp.getDragonModel().getEquipos().get(DragonBallZParametros.NombresDeEquipos.ParametrosDeGuerrerosZ.GUERREROS_Z).getmColeccionDePersonajes().getmPersonajes().values());
        personData.addAll(listPersonajeGuerrerosZ);
        personData.addAll(listPersonajeEnmigosDeLaTierra);
        personTable.setItems(personData);
        namePersonajeColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<String>(cellData.getValue().getNombre()));
        equipoPersonajeColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<String>(cellData.getValue().getEquipo()));
    }

    /**
     * Is called by the main application to give a reference back to itself.
     *
     * @param mainApp
     */

    @FXML
    private void handleConsultPerson() {
        Personaje selectedPerson = personTable.getSelectionModel().getSelectedItem();
        if (selectedPerson != null) {
            mainApp.showPersonEditDialog(selectedPerson);

        } else {
            // Nothing selected.
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Person Selected");
            alert.setContentText("Please select a person in the table.");

            alert.showAndWait();
        }
    }

    @FXML
    private void checkComboBoxE2() {
        if ((equipoJugadorDos.getValue().equals(guerrerosZ) && equipoJugadorUno.getValue().equals(guerrerosZ))) {
            equipoJugadorUno.getSelectionModel().select(enemigosDTR);
        }
        ;
        if ((equipoJugadorDos.getValue().equals(enemigosDTR) && equipoJugadorUno.getValue().equals(enemigosDTR))) {
            equipoJugadorUno.getSelectionModel().select(guerrerosZ);
        }
        ;

    }

    @FXML
    private void checkComboBoxE1() {
        if ((equipoJugadorDos.getValue().equals(guerrerosZ) && equipoJugadorUno.getValue().equals(guerrerosZ))) {
            equipoJugadorDos.getSelectionModel().select(enemigosDTR);
        }
        ;
        if ((equipoJugadorDos.getValue().equals(enemigosDTR) && equipoJugadorUno.getValue().equals(enemigosDTR))) {
            equipoJugadorDos.getSelectionModel().select(guerrerosZ);
        }
        ;

    }

    @FXML
    private void handleListoParaJugar() {
        if (isValid()) {
            mainApp.userRegistering(nameJugadorUno.getText(), nameJugadorDos.getText(), equipoJugadorUno.getValue(), equipoJugadorDos.getValue(), (int) tamanioTablero.getValue().getX(), (int) tamanioTablero.getValue().getY());
        }
    }

    private boolean isValid() {
        logNameJugadorDos.setText(CampoVacioException.validCampo(nameJugadorDos.getText()));
        logNameJugadorUno.setText(CampoVacioException.validCampo(nameJugadorUno.getText()));
        return ((logNameJugadorUno.getText() == "") && (logNameJugadorDos.getText() == ""));
    }

}
