package application;



import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {
    static EventList eventData = new EventList();
    private static Stage stage;
    /**
     *
     */

    File file = new File("EventData.txt");

    @Override
    @FXML
    public void start(final Stage stage) throws IOException, JAXBException {
        this.stage = stage;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("sample2.fxml"));
        final Scene sceneOne = new Scene((AnchorPane)loader.load());
        Controller sample2 = loader.getController();




        sample2.setMainApp(this);
        stage.setTitle("My Events");
        stage.setScene(sceneOne);

        AnchorPane anc = (AnchorPane) sceneOne.getRoot();
        loadEventDataFromFile();
        sample2.renew();

        sample2.save.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent arg0) {
				saveEventDataToFile();

			}

        });
        stage.show();


    }


    public Stage getPrimaryStage() {
        return stage;
    }

    public static int showDelete() {
        try {
            final boolean[] isOkClicked = {false};
            final int[] index = {-1};

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("sample.fxml"));
            AnchorPane page = (AnchorPane) loader.load();


            Stage dialogStage = new Stage();
            dialogStage.setTitle("Delete");
            dialogStage.initOwner(stage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            DeleteController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            EventList a = Main.getEventData();
            for(int i = 0; i < a.events.size(); i++){
                Button but = new Button();
                but.setText(a.events.get(i).name);
                but.setPrefSize(350, 40);
                controller.del.getChildren().add(but);
                int finalI = i;
                but.setOnAction(event -> {
                    final int ind = finalI;
                    index[0] = ind;
                    controller.handleOK(ind);
                });

            }

            dialogStage.showAndWait();

            return index[0];
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }



    public static boolean showPersonEditDialog(happenin event) {
        try {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("EditDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();


            Stage dialogStage = new Stage();
            dialogStage.setTitle("New event");
            dialogStage.initOwner(stage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            EditDialog controller = loader.getController();
            controller.setDialogStage(dialogStage);
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    public static EventList getEventData() {
        return eventData;
    }
    public void loadEventDataFromFile() throws FileNotFoundException {
    	try{
    	    Scanner in = new Scanner(file);
	        eventData.events.clear();
	        if(file != null){
		        int n = in.nextInt();
		        for(int i = 0; i < n; i++){
		        	String sep = in.nextLine();
		        	String name = in.nextLine();
		        	String desc = in.nextLine();
		        	int bg1 = in.nextInt();
		        	int bg2 = in.nextInt();
		        	int en1 = in.nextInt();
		        	int en2 = in.nextInt();
		        	happenin a = new happenin(name, desc, bg1, bg2, en1, en2);
		        	eventData.events.add(a);
		        }
		        in.close();
	        }
         } catch (Exception e) { // catches ANY exception
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Could not load data");
            alert.setContentText("Could not load data from file:\n" + file.getPath());

            alert.showAndWait();
    	}

    }






    public void saveEventDataToFile() {
    	try {
    		FileWriter fstream1 = new FileWriter("EventData.txt");// ����������� � ����� ���������� - ��� ����������
            BufferedWriter out1 = new BufferedWriter(fstream1); //  ������ ���������������� �����
            out1.write(""); // �������, ����������� ������ ������ ������
            out1.close();
    		PrintWriter out = new PrintWriter(file);
    		out.println(eventData.events.size());
    		for(int i = 0; i <eventData.events.size(); i++){
    			happenin a = eventData.events.get(i);
    			out.println(a.name);
    			out.println(a.desc);
    			out.println(a.bg1);
    			out.println(a.bg2);
    			out.println(a.en1);
    			out.println(a.en2);
    		}
    		out.close();

        } catch (Exception e) { // catches ANY exception
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Could not save data");
            alert.setContentText("Could not save data to file:\n" + file.getPath());

            alert.showAndWait();
        }
    }



    public static void main(String[] args) {
        launch(args);
    }
}
