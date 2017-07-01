package db.app.view;

import db.app.model.entidad.personaje.estado.Personaje;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;


public class InfoPersonajeViewController {

    @FXML
    private Label nombrePersonaje;
    @FXML
    private Label equipoPersonaje;
    @FXML
    private Label ptosVidaPersonaje;
    @FXML
    private Label kiIniPersonaje;
    @FXML
    private Label ataqueEsPersonaje;

    @FXML
    private ImageView imajePersonaje = new ImageView();

    @FXML
    private Label nombreEstadoUno;
    @FXML
    private Label poderPeleaUno;
    @FXML
    private Label velocidadUno;
    @FXML
    private Label DistanciaAtaqueUno;

    @FXML
    private Label nombreEstadodos;
    @FXML
    private Label poderPeleaDos;
    @FXML
    private Label velocidadDos;
    @FXML
    private Label DistanciaAtaqueDos;

    @FXML
    private Label nombreEstadotres;
    @FXML
    private Label poderPeleaTres;
    @FXML
    private Label velocidadTres;
    @FXML
    private Label DistanciaAtaqueTres;

    private Stage dialogStage;
    private Personaje person;
    private boolean okClicked = false;

    @FXML
    private void initialize() {
    }

    /**
     * Sets the stage of this dialog.
     *
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    /**
     * Sets the person to be edited in the dialog.
     *
     * @param person
     * @throws IOException
     */
    public void setPerson(Personaje person) throws IOException {
        this.person = person;
        Image img = new Image(person.getSrcProfilImg());
        imajePersonaje.setImage(img);
        nombrePersonaje.setText(person.getNombre());
        equipoPersonaje.setText(person.getEquipo());
        ptosVidaPersonaje.setText(String.valueOf((person.getVida())));
        ataqueEsPersonaje.setText(person.getAtaqueEspecial().getNombreAtaqueEspecial());
        kiIniPersonaje.setText(Integer.toString(person.getKi()));

        nombreEstadoUno.setText(person.getEstadoNormal().getNombreEstado());
        poderPeleaUno.setText(String.valueOf(person.getEstadoNormal().getPoderDePelea()));
        DistanciaAtaqueUno.setText(Integer.toString(person.getEstadoNormal().getDistanciaAtaque()));
        velocidadUno.setText(Integer.toString(person.getEstadoNormal().getVelocidad()));

        nombreEstadodos.setText(person.getSegundaTransformacion().getNombreEstado());
        poderPeleaDos.setText(String.valueOf(person.getSegundaTransformacion().getPoderDePelea()));
        DistanciaAtaqueDos.setText(Integer.toString(person.getSegundaTransformacion().getDistanciaAtaque()));
        velocidadDos.setText(Integer.toString(person.getSegundaTransformacion().getVelocidad()));

        nombreEstadotres.setText(person.getTerceraTransformacion().getNombreEstado());
        poderPeleaTres.setText(String.valueOf(person.getTerceraTransformacion().getPoderDePelea()));
        DistanciaAtaqueTres.setText(Integer.toString(person.getTerceraTransformacion().getDistanciaAtaque()));
        velocidadTres.setText(Integer.toString(person.getTerceraTransformacion().getVelocidad()));

    }

    /**
     * Returns true if the user clicked OK, false otherwise.
     *
     * @return
     */
    public boolean isOkClicked() {
        return okClicked;
    }

    /**
     * Called when the user clicks cancel.
     */
    @FXML
    private void handleClose() {
        dialogStage.close();
    }
}
