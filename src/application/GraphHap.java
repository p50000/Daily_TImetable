package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

import static javafx.geometry.Pos.CENTER;
import static javafx.scene.layout.Priority.NEVER;
import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

/**
 * Created by Ренота on 23.02.2018.
 */
public class GraphHap {
    GridPane pain;
    AnchorPane bas;
    GridPane time;
    Label ti1;
    Label ti2;
    Label ti3;
    Label ti4;
    GridPane desc;
    Label descript;
    Label name;

    private void setColumnComstraints(ColumnConstraints a, double prefW){
        a.setMinWidth(prefW);
        a.setMaxWidth(prefW);
        a.setPrefWidth(prefW);
        a.setHgrow(NEVER);
    }
    private void setRowComstraints(RowConstraints a, double prefH){
        a.setMinHeight(prefH);
        a.setMaxHeight(prefH);
        a.setPrefHeight(prefH);
        a.setVgrow(NEVER);
    }



    public GraphHap(happenin ev){
        pain = new GridPane();
        pain.addColumn(0);
        pain.addRow(0);
        pain.addRow(1);
        pain.setAlignment(CENTER);
        pain.setGridLinesVisible(true);
        pain.setPrefHeight(191.0);
        pain.setPrefWidth(435.0);
        pain.setMinHeight(191.0);
        pain.setMaxHeight(191.0);
        pain.setMinWidth(435.0);
        pain.setMaxWidth(435.0);

        ColumnConstraints con = new ColumnConstraints();
        setColumnComstraints(con, 435);
        pain.getColumnConstraints().add(0, con);
        RowConstraints ron = new RowConstraints();
        setRowComstraints(ron, 24.9);
        pain.getRowConstraints().add(0, ron);
        RowConstraints rsec = new RowConstraints();
        setRowComstraints(rsec, 166.1);
        pain.getRowConstraints().add(1, rsec);


        bas = new AnchorPane();
        bas.setPrefHeight(162.12);
        bas.setMinHeight(162.12);
        bas.setMaxHeight(162.12);
        bas.setPrefWidth(404.8582677);
        bas.setMaxWidth(404.8582677);
        bas.setMinWidth(404.8582677);
        pain.add(bas, 0, 1);

        time = new GridPane();
        ColumnConstraints tion = new ColumnConstraints();
        setColumnComstraints(tion, 203.4567);
        time.getColumnConstraints().add(0, tion);
        ColumnConstraints titw = new ColumnConstraints();
        setColumnComstraints(titw, 51.37795);
        time.getColumnConstraints().add(1, titw);
        ColumnConstraints tith = new ColumnConstraints();
        setColumnComstraints(tith, 51.37795);
        time.getColumnConstraints().add(2, tith);
        ColumnConstraints tifo = new ColumnConstraints();
        setColumnComstraints(tifo, 24.66);
        time.getColumnConstraints().add(3, tifo);
        ColumnConstraints tifi = new ColumnConstraints();
        setColumnComstraints(tifi, 51.37795);
        time.getColumnConstraints().add(4, tifi);
        ColumnConstraints tisi = new ColumnConstraints();
        setColumnComstraints(tisi, 51.37795);
        time.getColumnConstraints().add(5, tisi);
        RowConstraints tione = new RowConstraints();
        setRowComstraints(tione, 32.16);
        time.getRowConstraints().add(0, tione);

        Font f = new Font("Arial", 25);

        Rectangle t1 = new Rectangle(43.32, 44.32);
        t1.setFill(Paint.valueOf("#a6b6c6"));
        time.add(t1, 1, 0);
        ti1 = new Label();
        ti1.setFont(f);
        String text1 = String.valueOf(ev.bg1);
        if(text1.length() == 1){
            text1 = "0".concat(text1);
        }
        ti1.setText(text1);
        ti1.setPadding(new Insets(7, 7, 7, 7));
        time.add(ti1, 1, 0);

        Rectangle t2 = new Rectangle(43.32, 44.32);
        t2.setFill(Paint.valueOf("#a6b6c6"));
        time.add(t2, 2, 0);
        ti2 = new Label();
        ti2.setFont(f);
        String text2 = String.valueOf(ev.bg2);
        if(text2.length() == 1){
            text2 = "0".concat(text2);
        }
        ti2.setText(text2);
        ti2.setPadding(new Insets(7, 7, 7, 7));
        time.add(ti2, 2, 0);

        Rectangle t3 = new Rectangle(43.32, 44.32);
        t3.setFill(Paint.valueOf("#a6b6c6"));
        time.add(t3, 4, 0);
        ti3 = new Label();
        String text3 = String.valueOf(ev.en1);
        if(text3.length() == 1){
            text3 = "0".concat(text3);
        }
        ti3.setText(text3);
        ti3.setFont(f);
        ti3.setPadding(new Insets(7, 7, 7, 7));
        time.add(ti3, 4, 0);

        Rectangle t4 = new Rectangle(43.32, 44.32);
        t4.setFill(Paint.valueOf("#a6b6c6"));
        time.add(t4, 5, 0);
        ti4 = new Label();
        String text4 = String.valueOf(ev.en2);
        if(text4.length() == 1){
            text4 = "0".concat(text4);
        }
        ti4.setText(text4);
        ti4.setFont(f);
        ti4.setPadding(new Insets(7, 7, 7, 7));
        time.add(ti4, 5, 0);

        bas.getChildren().add(time);
        AnchorPane.setBottomAnchor(time, 99.11);
        AnchorPane.setLeftAnchor(time, 0.0);
        AnchorPane.setRightAnchor(time, 0.0);
        AnchorPane.setTopAnchor(time, 9.19);


        desc = new GridPane();
        desc.setAlignment(CENTER);
        desc.setPrefHeight(82.045);
        desc.setPrefWidth(419.93);
        desc.setMinHeight(82.045);
        desc.setMaxHeight(82.045);
        desc.setMinWidth(419.93);
        desc.setMaxWidth(419.93);
        ColumnConstraints cdes = new ColumnConstraints();
        setColumnComstraints(cdes, 392.53);
        desc.getColumnConstraints().add(0, cdes);
        RowConstraints rdes = new RowConstraints();
        setRowComstraints(rdes, 19.69);
        desc.getRowConstraints().add(0, rdes);

        Rectangle desrec = new Rectangle(396.6378, 88.60);
        desrec.setFill(Paint.valueOf("#bec7d0"));
        desc.add(desrec, 0, 0);
        descript = new Label();
        descript.setPrefSize(396.63778,88.61);
        descript.setText(ev.desc);
        descript.setWrapText(true);
        descript.setAlignment(Pos.valueOf("TOP_LEFT"));
        AnchorPane forl = new AnchorPane();
        forl.setPrefSize(131.3, 131.3);
        forl.getChildren().add(descript);
        AnchorPane.setBottomAnchor(descript, -28.88);
        AnchorPane.setLeftAnchor(descript, 4.11);
        AnchorPane.setRightAnchor(descript, 0.0);
        AnchorPane.setTopAnchor(descript, -32.16);
        desc.add(forl, 0, 0);

        bas.getChildren().add(desc);
        AnchorPane.setBottomAnchor(desc, 9.19);
        AnchorPane.setLeftAnchor(desc, 0.0);
        AnchorPane.setRightAnchor(desc, 0.0);
        AnchorPane.setTopAnchor(desc, 76.137);


        Rectangle nam = new Rectangle(435, 24.9);
        nam.setFill(Paint.valueOf("#d8dde1"));
        pain.add(nam, 0, 0);
        name = new Label();
        name.setText(ev.name);
        name.setPadding(new Insets(4, 4, 4, 4));
        pain.add(name, 0, 0);



    }
}
