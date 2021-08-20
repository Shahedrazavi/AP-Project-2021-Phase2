package ui;

import javafx.scene.Scene;

public class Page extends Component {

    protected Scene scene;

    public Page(String fxmlName) {
        super(fxmlName);
        scene = new Scene(root);
    }

    public Scene getScene() {
        return scene;
    }
}
