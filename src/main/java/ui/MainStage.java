package ui;

import config.Config;
import javafx.stage.Stage;

public class MainStage extends Stage {
    public MainStage() {
        super();
        Config config = Config.getConfig("stage");
        setWidth(config.getProperty(Integer.class,"width"));
        setHeight(config.getProperty(Integer.class, "height"));
        setTitle(config.getProperty("name"));
        setResizable(false);
    }

}
