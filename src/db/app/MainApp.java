package db.app;

import db.app.model.entidad.personaje.estado.Personaje;
import db.app.model.estado.DragonAlgoBallModel;
import db.app.view.InfoPersonajeViewController;
import db.app.view.InscriptionViewController;
import db.app.view.TableroViewController;
import db.app.view.transformarViewController;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;
import java.util.Optional;

public class MainApp extends Application {
    private Stage primaryStage;
    private Stage dialogStage;
    private BorderPane rootLayout;
    private DragonAlgoBallModel dragonBall;
    private static MainApp instance;

    public static void mainApp(String[] args) {
        launch(args);
    }


    public static MainApp getInstance() {
        return instance;
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Dragon Ball ZzZ !");
        initRootLayout();
        showInscripcionOverview();
    }

    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Shows the person overview inside the root layout.
     */
    public void showInscripcionOverview() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/inscriptionView.fxml"));
            AnchorPane inscriptionOverview = (AnchorPane) loader.load();
            // Set person overview into the center of root layout.
            rootLayout.setCenter(inscriptionOverview);
            // Give the controller access to the main app.
            InscriptionViewController controller = loader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private Stage showpopup(String fxml, String nomFenetre, FXMLLoader loader) throws Exception {
        loader.setLocation(MainApp.class.getResource(fxml));
        AnchorPane contenu = (AnchorPane) loader.load();
        Stage dialogStage = new Stage();
        dialogStage.setTitle(nomFenetre);
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.initOwner(primaryStage);
        Scene scene = new Scene(contenu);
        dialogStage.setScene(scene);
        return dialogStage;
    }

    public boolean showPersonEditDialog(Personaje person) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            dialogStage = showpopup("view/InfoPersonajeView.fxml", "Consulta " + person.getNombre(), loader);
            // Set the person into the controller.
            InfoPersonajeViewController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setPerson(person);
            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();
            return controller.isOkClicked();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Constructor
     */
    public MainApp() {
        instance = this;
        dragonBall = new DragonAlgoBallModel();
    }


    /**
     * Returns the main stage.
     *
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }


    public boolean userRegistering(String nombreJugador1, String nombreJugador2, String nombreEquipo1, String nombreEquipo2, int largo, int altura) {
        dragonBall = new DragonAlgoBallModel(nombreJugador1, nombreJugador2, nombreEquipo1, nombreEquipo2, largo, altura);
        showTablero();
        return true;

    }

    private void showTablero() {
        try {
            transformarViewController controllerTranformarPersonaje = null;
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            dialogStage = showpopup("view/TableroView.fxml", "Partido entre " + dragonBall.getJugadorEnemigosDeLaTierra().getNombreJugador() + " y " + dragonBall.getJugadorGuerrerosZ().getNombreJugador(), loader);
            TableroViewController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setStageControllerTransformarPersonaje(controllerTranformarPersonaje);
            // Show the dialog and wait until the user closes it
            dialogStage.setOnCloseRequest(confirmCloseEventHandler);
            dialogStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private EventHandler<WindowEvent> confirmCloseEventHandler = event -> {
        Alert closeConfirmation = new Alert(
                Alert.AlertType.CONFIRMATION,
                "Seguro que quiere salir del juego ?"
        );
        Button exitButton = (Button) closeConfirmation.getDialogPane().lookupButton(
                ButtonType.OK
        );
        exitButton.setText("Salir");
        closeConfirmation.setHeaderText("Confirmacion salir");
        closeConfirmation.initModality(Modality.APPLICATION_MODAL);
        closeConfirmation.initOwner(dialogStage);

        // normally, you would just use the default alert positioning,
        // but for this simple sample the main stage is small,
        // so explicitly position the alert so that the main window can still be seen.
        closeConfirmation.setX(dialogStage.getX());
        closeConfirmation.setY(closeConfirmation.getY() + dialogStage.getHeight());

        Optional<ButtonType> closeResponse = closeConfirmation.showAndWait();
        if (!ButtonType.OK.equals(closeResponse.get())) {
            event.consume();
        }
    };

    public DragonAlgoBallModel getDragonModel() {
        return dragonBall;
    }


}
