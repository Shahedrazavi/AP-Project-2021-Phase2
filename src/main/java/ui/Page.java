package ui;

import javafx.scene.Scene;

public abstract class Page extends Component {

    protected Scene scene;

    public Page(String fxmlName) {
        super(fxmlName);
        scene = new Scene(root);
    }

    public Scene getScene() {
        return scene;
    }
}
