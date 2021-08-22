import javafx.application.Application;

import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import ui.GraphicalAgent;
import util.Logger;

import java.util.LinkedList;

import static javafx.geometry.Pos.CENTER;

public class MainApp extends Application {
    @Override
    public void start(Stage stage) {
        Logger.getLogger().start();
        GraphicalAgent graphicalAgent = GraphicalAgent.getInstance();
        graphicalAgent.initialize();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
