package db.app.view;

import db.app.MainApp;
import db.app.exception.*;
import db.app.model.ObservadorDeModelo;
import db.app.model.entidad.consumible.Consumible;
import db.app.model.entidad.personaje.DragonBallZParametros;
import db.app.model.entidad.personaje.equipo.Equipo;
import db.app.model.entidad.personaje.estado.Personaje;
import db.app.model.estado.DragonAlgoBallModel;
import db.app.model.estado.EstadoDelJuego;
import db.app.model.tablero.Posicion;
import db.app.model.tablero.Tablero;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TableroViewController implements ObservadorDeModelo {
    @FXML
    private BorderPane borderPaneInfoPersonajeEnemigosDeLaTierra;
    @FXML
    private BorderPane borderPaneInfoPersonajeGuerrerosZ;
    @FXML
    private Label turno;
    @FXML
    private Label nombreJugadorEnemigosDeLaTierra;
    @FXML
    private Label equipoJugadorEnemigosDeLaTierra;
    @FXML
    private TableView<Personaje> personTableJugadorEnemigosDeLaTierra;
    @FXML
    private TableColumn<Personaje, String> namePersonajeColumnJugadorEnemigosDeLaTierra;
    @FXML
    private TableColumn<Personaje, String> estadoPersonajeColumnJugadorEnemigosDeLaTierra;
    @FXML
    private TableColumn<Personaje, String> vidaPersonajeColumnJugadorEnemigosDeLaTierra;
    @FXML
    private TableColumn<Personaje, String> KiPersonajeColumnJugadorEnemigosDeLaTierra;
    @FXML
    private TableColumn<Personaje, String> velocidadPersonajeColumnJugadorEnemigosDeLaTierra;
    @FXML
    private Label nombreJugadorGerrerosZ;
    @FXML
    private Label equipoJugadorGerrerosZ;
    @FXML
    private TableView<Personaje> personTableJugadorGerrerosZ;
    @FXML
    private TableColumn<Personaje, String> namePersonajeColumnJugadorGerrerosZ;
    @FXML
    private TableColumn<Personaje, String> estadoPersonajeColumnJugadorGerrerosZ;
    @FXML
    private TableColumn<Personaje, String> vidaPersonajeColumnJugadorGerrerosZ;
    @FXML
    private TableColumn<Personaje, String> KiPersonajeColumnJugadorGerrerosZ;
    @FXML
    private TableColumn<Personaje, String> velocidadPersonajeColumnJugadorGerrerosZ;
    @FXML
    private GridPane tablero;
    @FXML
    private AnchorPane anchorPaneAccionesPersonaje;
    private transformarViewController controllerTransformarPersonaje;
    private AtacarViewController controllerAtacarPersonaje;

    private MainApp mainApp = MainApp.getInstance();
    private Tablero tablerodbz;
    private BorderPane borderPaneTransformar;
    private BorderPane borderPaneAtacar;
    private Stage dialogStage;
    private Personaje personajeSelected;
    private String ganador;
    private int sizeAltura;
    private int sizeLargo;
    private String guerrerosZ = DragonBallZParametros.NombresDeEquipos.ParametrosDeGuerrerosZ.GUERREROS_Z;
    private String enemigosDT = DragonBallZParametros.NombresDeEquipos.ParamentrosDeEnemigosDeLaTierra.ENEMIGOS_DE_LA_TIERRA;
    private EstadoDelJuego turnoJugadorActivo;


    @FXML
    private void initialize() throws StringVacio, NoExistePersonaje, CasilleroNoExistente, PosicionInvalida, CasilleroSinPersonaje, IOException {
        tablerodbz = mainApp.getDragonModel().getTablero();
        sizeAltura = tablerodbz.getAltura() + 2;
        sizeLargo = tablerodbz.getLargo() + 2;
        tablero.setAlignment(Pos.CENTER);
        mainApp.getDragonModel().registrarObservador(this);
        loadJugadores();


        for (int i = 0; i < sizeAltura; i++) {
            ColumnConstraints colConstraints = new ColumnConstraints();
            colConstraints.setHgrow(Priority.SOMETIMES);
            tablero.getColumnConstraints().add(colConstraints);
        }

        for (int i = 0; i < sizeLargo; i++) {
            RowConstraints rowConstraints = new RowConstraints();
            rowConstraints.setVgrow(Priority.SOMETIMES);
            tablero.getRowConstraints().add(rowConstraints);
        }

        for (int i = 0; i < sizeAltura; i++) {
            for (int j = 0; j < sizeLargo; j++) {
                addStackPane(i, j);
            }
        }
        this.loadPersonajesEnemigosDeLaTierra();
        this.loadPersonajesGuerrerosZ();
        this.loadPersonajes();
        this.loadTurno();
    }

    public void setStageControllerTransformarPersonaje(transformarViewController controller) {
        this.controllerTransformarPersonaje = controller;
    }

    public void setStageControllerAtacarPersonaje(AtacarViewController controller) {
        this.controllerAtacarPersonaje = controller;
    }

    private void addStackPane(int colIndex, int rowIndex) throws CasilleroSinPersonaje, CasilleroNoExistente {
        StackPane stackpane = new StackPane();
        stackpane.setPrefSize(800 / sizeLargo, 800 / sizeAltura);
        stackpane.setAlignment(Pos.CENTER);
        if (colIndex == 0 || colIndex == sizeLargo - 1 || rowIndex == 0 || rowIndex == sizeAltura - 1) {
            stackpane.setStyle("-fx-background-color:  #196619;");
        } else {
            setMouveMovimientoClickToStackPane(stackpane);
        }
        tablero.add(stackpane, colIndex, rowIndex);
    }

    public void setMouveMovimientoClickToStackPane(StackPane stackPane) {
        stackPane.setOnMouseClicked(e -> {
            try {
                mouseMovimientoClick(e);
            } catch (Exception e1) {
                e1.printStackTrace();
            }

        });
    }

    public void setMouvePersonajeClickToStackPane(StackPane stackPane) {
        stackPane.setOnMouseClicked(e -> {
            try {
                mousePersonajeClick(e);
            } catch (Exception e1) {
                e1.printStackTrace();
            }

        });
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void refresh() throws StringVacio, NoExistePersonaje, IOException {
        borderPaneAtacar.setCenter(null);
        borderPaneTransformar.setCenter(null);
        this.personTableJugadorEnemigosDeLaTierra.refresh();
        this.personTableJugadorGerrerosZ.refresh();
        this.loadConsumible();
        this.loadPersonajes();
        this.loadTurno();
    }


    private void initViewPersonajeTransformar(BorderPane bdPane, Personaje person) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("view/transformarView.fxml"));
        anchorPaneAccionesPersonaje = (AnchorPane) loader.load();
        bdPane.setCenter(anchorPaneAccionesPersonaje);
        controllerTransformarPersonaje = loader.getController();
        controllerTransformarPersonaje.setPersonaje(this, person);


    }

    private void initViewPersonajeAtacar(BorderPane bdPane, Personaje personajeQueRecibe) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("view/AtacarView.fxml"));
        anchorPaneAccionesPersonaje = (AnchorPane) loader.load();
        bdPane.setCenter(anchorPaneAccionesPersonaje);
        controllerAtacarPersonaje = loader.getController();
        controllerAtacarPersonaje.setPersonaje(this, personajeQueRecibe, personajeSelected);

    }

    public void loadTurno() {
        turnoJugadorActivo = mainApp.getDragonModel().getEstadoDelJuego();
        if (turnoJugadorActivo.equals(mainApp.getDragonModel().getTurnoDeEnemigosDeLaTierra())) {
            turno.setText("Turno : " + enemigosDT);
            turno.setStyle("-fx-text-fill: #e32210 !important; -fx-highlight-text-fill: #000");
            borderPaneTransformar = borderPaneInfoPersonajeEnemigosDeLaTierra;
            borderPaneAtacar = borderPaneInfoPersonajeGuerrerosZ;
        } else {
            turno.setText("Turno : " + guerrerosZ);
            turno.setStyle("-fx-text-fill:#003300 !important; -fx-highlight-text-fill: #000;");
            borderPaneTransformar = borderPaneInfoPersonajeGuerrerosZ;
            borderPaneAtacar = borderPaneInfoPersonajeEnemigosDeLaTierra;
        }
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    private void loadConsumible() {
        Iterator<Consumible> itConsumible = mainApp.getDragonModel().getConsumibles();
        while (itConsumible.hasNext()) {
            Consumible consumible = itConsumible.next();
            Image image = new Image(consumible.getSrcImg());
            StackPane myStackpane = (StackPane) (tablero.getChildren().get(consumible.getPosicion().getX() * sizeAltura + consumible.getPosicion().getY() + 1));
            ImageView pic = new ImageView(image);
            pic.setFitHeight(800 / sizeAltura);
            pic.setFitWidth(800 / sizeLargo);
            pic.setPreserveRatio(true);
            myStackpane.getChildren().add(pic);
            setMouveMovimientoClickToStackPane(myStackpane);

        }
    }

    private void setPicViewPersonaje(Image imagePersonaje, StackPane stackpane) {
        ImageView pic = new ImageView(imagePersonaje);
        pic.setFitHeight(800 / sizeAltura);
        pic.setFitWidth(800 / sizeLargo);
        pic.setPreserveRatio(true);
        stackpane.getChildren().add(pic);
        setMouvePersonajeClickToStackPane(stackpane);
    }

    private void loadPersonajes() {
        Iterator<Personaje> itPersonaje;
        itPersonaje = mainApp.getDragonModel().getIteratorDePersonajes();
        while (itPersonaje.hasNext()) {
            Personaje personaje = itPersonaje.next();
            Image image = new Image(personaje.getSrcProfilImg());
            StackPane myStackpane = (StackPane) (tablero.getChildren().get(personaje.getPosicion().getX() * sizeAltura + personaje.getPosicion().getY() + 1));
            setPicViewPersonaje(image, myStackpane);
        }
        ;

    }


    public void loadJugadores() {
        DragonAlgoBallModel dragonBall = mainApp.getDragonModel();
        System.out.println(dragonBall.getJugadorEnemigosDeLaTierra().getNombreJugador());
        nombreJugadorEnemigosDeLaTierra.setText(dragonBall.getJugadorEnemigosDeLaTierra().getNombreJugador());
        equipoJugadorEnemigosDeLaTierra.setText("Enemigos de la Tierra");
        nombreJugadorGerrerosZ.setText(dragonBall.getJugadorGuerrerosZ().getNombreJugador());
        equipoJugadorGerrerosZ.setText("Guerreros Z");
    }

    public void loadPersonajesEnemigosDeLaTierra() {
        Equipo enemigos = mainApp.getDragonModel().getEquipos().get(enemigosDT);
        List<Personaje> listPersonajeEnmigosDeLaTierra = new ArrayList<Personaje>(enemigos.getmColeccionDePersonajes().getmPersonajes().values());
        ObservableList<Personaje> data = FXCollections.observableArrayList(listPersonajeEnmigosDeLaTierra);
        personTableJugadorEnemigosDeLaTierra.setItems(data);
        namePersonajeColumnJugadorEnemigosDeLaTierra.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getNombre()));
        estadoPersonajeColumnJugadorEnemigosDeLaTierra.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getEstadoDelPersonaje().getNombreEstado()));
        vidaPersonajeColumnJugadorEnemigosDeLaTierra.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getVida() + ""));
        KiPersonajeColumnJugadorEnemigosDeLaTierra.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getKi() + ""));
        velocidadPersonajeColumnJugadorEnemigosDeLaTierra.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getVelocidad() + ""));


    }

    public void loadPersonajesGuerrerosZ() {
        Equipo guerreros = mainApp.getDragonModel().getEquipos().get(guerrerosZ);
        List<Personaje> listPersonajeEnmigosDeLaTierra = new ArrayList<>(guerreros.getmColeccionDePersonajes().getmPersonajes().values());
        ObservableList<Personaje> data = FXCollections.observableArrayList(listPersonajeEnmigosDeLaTierra);
        personTableJugadorGerrerosZ.setItems(data);
        namePersonajeColumnJugadorGerrerosZ.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getNombre()));
        estadoPersonajeColumnJugadorGerrerosZ.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getEstadoDelPersonaje().getNombreEstado()));
        vidaPersonajeColumnJugadorGerrerosZ.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getVida() + ""));
        KiPersonajeColumnJugadorGerrerosZ.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getKi() + ""));
        velocidadPersonajeColumnJugadorGerrerosZ.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getVelocidad() + ""));

    }


    public GridPane getTablero() {
        return tablero;
    }

    public int getAltura() {
        return sizeAltura;
    }


    @FXML
    private void mousePersonajeClick(MouseEvent e) throws PosicionInvalida, IOException, CasilleroSinPersonaje, CasilleroNoExistente {
        Node source = (Node) e.getSource();
        Posicion posicion = new Posicion(GridPane.getColumnIndex(source), GridPane.getRowIndex(source));
        try {
            Personaje personaje = tablerodbz.getPersonaje(posicion);
            if (mainApp.getDragonModel().getEquipos().get(turnoJugadorActivo.getNombreEquipo()).pertenceAEquipo(personaje)) {
                personajeSelected = personaje;
                initViewPersonajeTransformar(borderPaneTransformar, personaje);
            } else {
                if (!(personajeSelected == null)) {
                    initViewPersonajeAtacar(borderPaneAtacar, personaje);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }


    @FXML
    private void mouseMovimientoClick(MouseEvent e) throws PosicionInvalida, CaminoBloqueado, CeldaOcupada, CasilleroNoExistente, StringVacio, NoExistePersonaje, IOException, ElPersonajeEstaMuerto, CeldaVacia, NoEsTurnoDeJugador{
        Node source = (Node) e.getSource();
        Posicion posicion = new Posicion(GridPane.getColumnIndex(source), GridPane.getRowIndex(source));
        if (!(personajeSelected == null)) {
            try {
                int idPersonajeSelected = personajeSelected.getPosicion().getX() * sizeAltura + personajeSelected.getPosicion().getY() + 1;
                mainApp.getDragonModel().moverPersonaje(personajeSelected, posicion);
                int idConsumible = posicion.getX() * sizeAltura + posicion.getY() + 1;
                StackPane stackPaneConsumible = (StackPane) (tablero.getChildren().get(idConsumible));
                stackPaneConsumible.getChildren().clear();
                StackPane myStackpanePersonaje = (StackPane) (tablero.getChildren().get(idPersonajeSelected));
                myStackpanePersonaje.getChildren().clear();
               setMouveMovimientoClickToStackPane(myStackpanePersonaje);
                this.loadPersonajes();
            } catch (PersonajeEstaInhabilitado e1) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.initOwner(dialogStage);
                alert.setTitle("Movimiento");
                alert.setHeaderText(personajeSelected.getNombre());
                alert.setContentText("Esta en forma de chocolate !");
                alert.showAndWait();
            } catch (CaminoBloqueado e1) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.initOwner(dialogStage);
                alert.setTitle("Movimiento");
                alert.setHeaderText(personajeSelected.getNombre());
                alert.setContentText("Camino bloqueado !");
                alert.showAndWait();
            } catch (FaltaDeVelocidad e1) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.initOwner(dialogStage);
                alert.setTitle("Movimiento");
                alert.setHeaderText(personajeSelected.getNombre());
                alert.setContentText("Falta velocidad !");
                alert.showAndWait();
            }catch (JugadorYaHabiaMovido e1) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.initOwner(dialogStage);
                alert.setTitle("Movimiento");
                alert.setHeaderText(personajeSelected.getNombre());
                alert.setContentText("Personaje ya movio !");
                alert.showAndWait();
            }


        }

    }

    @FXML
    private void onClickPasarTurno() throws NoEsTurnoDeJugador, StringVacio, NoExistePersonaje, IOException, ElPersonajeEstaMuerto, CeldaOcupada, CasilleroNoExistente {
        borderPaneAtacar.setCenter(null);
        borderPaneTransformar.setCenter(null);
        personajeSelected = null;
        mainApp.getDragonModel().pasarTurno();
        this.refresh();
    }

    @Override
    public void seTerminoElJuego(String nombreDelGanador) {
        ganador = nombreDelGanador;
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.initOwner(dialogStage);
        alert.setTitle("Gano : "+ganador);
        dialogStage.hide();
       alert.showAndWait();
        dialogStage.close();

    }


}






