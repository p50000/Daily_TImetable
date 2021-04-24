package application;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * Created by on 03.03.2018.
 */
public class EditDialog {

    private Stage dialogStage;
    private happenin InEvent;
    private boolean okClicked = false;

    @FXML
    private TextField NameField;
    @FXML
    private TextField st1;
    @FXML
    private TextField st2;
    @FXML
    private TextField fi1;
    @FXML
    private TextField fi2;
    @FXML
    private TextField descField;

    @FXML
    private void initialize() {

    }


    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
    public boolean isOkClicked() {
        return okClicked;
    }

    @FXML
    private void handleOk() {
        if (isInputValid()) {
            InEvent = new happenin(NameField.getText(), descField.getText(), Integer.parseInt(st1.getText()), Integer.parseInt(st2.getText()), Integer.parseInt(fi1.getText()), Integer.parseInt(fi2.getText()));
            if(intersects(InEvent)) {
                okClicked = true;
                dialogStage.close();
            }


        }
    }

    boolean intersects(happenin a){
        String errorMessage = "";
        if(!Main.getEventData().add(a)){
            errorMessage = "The event intersects the others!\n";

        }
        if (errorMessage.length() == 0) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Incorrect input format");
            alert.setHeaderText("Please set the input correctrly");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }

    @FXML
    private void handleCancel() {
        dialogStage.close();
    }
    private boolean addEvent(EventList a, happenin ev){
        boolean bool = a.add(ev);
        String errorMessage = "";
        if(!bool){
            errorMessage += "The event intersects the others!\n";
        }
        if (errorMessage.length() == 0) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Incorrect input format");
            alert.setHeaderText("Please set the input correctrly");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }

    private boolean isInputValid() {
        String errorMessage = "";

        if (NameField.getText() == null || NameField.getText().length() == 0) {
            errorMessage += "Wrong name!\n";
        }
        if (st1.getText() == null || st1.getText().length() != 2 ) {
            errorMessage += "Wrong time format!\n";
        } else {

            try {
                Integer.parseInt(st1.getText());
            } catch (NumberFormatException e) {
                errorMessage += "Wrong time format!\n";
            }
        }
        if (st2.getText() == null || st2.getText().length() != 2 ) {
            errorMessage += "Wrong time format!\n";
        } else {

            try {
                Integer.parseInt(st2.getText());
            } catch (NumberFormatException e) {
                errorMessage += "Wrong time format!\n";
            }
        }
        if (fi1.getText() == null || fi1.getText().length() != 2 ) {
            errorMessage += "Wrong time format!\n";
        } else {

            try {
                Integer.parseInt(fi1.getText());
            } catch (NumberFormatException e) {
                errorMessage += "Wrong time format!\n";
            }
        }
        if (fi2.getText() == null || fi2.getText().length() != 2 ) {
            errorMessage += "Wrong time format!\n";
        } else {

            try {
                Integer.parseInt(fi2.getText());
            } catch (NumberFormatException e) {
                errorMessage += "Wrong time format!\n";
            }
        }




        if (errorMessage.length() == 0) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Incorrect input format");
            alert.setHeaderText("Please set the input correctrly");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }
}