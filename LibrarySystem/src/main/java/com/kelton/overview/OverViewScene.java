package com.kelton.overview;

import javafx.scene.Scene;

public class OverViewScene extends Scene {

    private final OverViewPane overViewPane;

    public OverViewScene() {
        super(new OverViewPane());
        overViewPane = (OverViewPane) this.getRoot();
    }

    public void refreshData() {
        overViewPane.refreshData();
    }
}
