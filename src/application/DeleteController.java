package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import application.EventList;
import application.Main;

public class DeleteController {
    private Stage dialogStage;
    private boolean okClicked = false;
    @FXML
    public VBox del;
    private application.Main Main;

    @FXML
    public Button close;







    @FXML
    private void initialize() {



    }

    public void handleOK(int index){
        EventList e = Main.getEventData();
        e.events.remove(index);
        okClicked = true;

        dialogStage.close();
    }
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

}

