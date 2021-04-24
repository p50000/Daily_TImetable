package application;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;



import static javafx.scene.layout.Priority.NEVER;

public class Controller {
    @FXML
    public GridPane b;
    @FXML
    public Button add;
    @FXML
    public Button delBut;
    @FXML
    public Button save;
    @FXML
    public ScrollPane scr;

    private Main Main;



    @FXML
    private void initialize() {



    }
    @FXML
    private void handleDeletePerson() {
        int selectedIndex = Main.showDelete();
        if (selectedIndex >= 0) {
            EventList e = Main.getEventData();
            b.getRowConstraints().clear();
            b.getChildren().clear();
            for(int i =0; i < Main.getEventData().events.size(); i++){
                RowConstraints a = new RowConstraints();
                a.setMinHeight(195.0);
                a.setMaxHeight(195.0);
                a.setPrefHeight(195.0);
                a.setVgrow(NEVER);
                GraphHap n = new GraphHap(e.events.get(i));
                GridPane m = n.pain;
                b.add(m, 0, i);
            }
        } else {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(Main.getPrimaryStage());
            alert.setTitle("No event chosen");
            alert.setHeaderText("None of the events was chosen");
            alert.setContentText("Please choose an event!");

            alert.showAndWait();
        }

    }
    @FXML
    private void handleAdd(){
        happenin tempPerson = new happenin();
        boolean okClicked = Main.showPersonEditDialog(tempPerson);
        if(okClicked){
            EventList e = Main.getEventData();
            b.getRowConstraints().clear();
            b.getChildren().clear();
            for(int i =0; i < Main.getEventData().events.size(); i++){
                RowConstraints a = new RowConstraints();
                a.setMinHeight(195.0);
                a.setMaxHeight(195.0);
                a.setPrefHeight(195.0);
                a.setVgrow(NEVER);
                GraphHap n = new GraphHap(e.events.get(i));
                GridPane m = n.pain;
                b.add(m, 0, i);
            }


        }
    }
    public void renew(){
    	EventList e = Main.getEventData();
        b.getRowConstraints().clear();
        b.getChildren().clear();
        for(int i =0; i < Main.getEventData().events.size(); i++){
            RowConstraints a = new RowConstraints();
            a.setMinHeight(195.0);
            a.setMaxHeight(195.0);
            a.setPrefHeight(195.0);
            a.setVgrow(NEVER);
            GraphHap n = new GraphHap(e.events.get(i));
            GridPane m = n.pain;
            b.add(m, 0, i);
        }
        }

    

    @FXML

    public void setMainApp(Main mainApp) {
        this.Main = mainApp;
    }
}






