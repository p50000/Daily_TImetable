package application;

import javafx.beans.InvalidationListener;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.text.TextAlignment;

/**
 * Created by  on 21.02.2018.
 */

public class happenin {
    public int bg1;
    public int bg2;
    public int en1;
    public int en2;
    public String name;
    public String desc;



    happenin(String name, String desc, int bg1, int bg2, int en1, int en2){
        this.bg1 = bg1;
        this.bg2 = bg2;
        this.en1 = en1;
        this.en2 = en2;
        this.desc = desc;
        this.name = name;

    }
    happenin(){

    }
    public int compareBeg(happenin that){
        if (Double.compare(this.bg1, that.bg1) == 0){
            return Double.compare(this.bg2, that.bg2);
        }
        return Double.compare(this.bg1, that.bg1);
    }

    public int compareEnd(happenin that){
        if (Double.compare(this.en1, that.en1) == 0){
            return Double.compare(this.en2, that.en2);
        }
        return Double.compare(this.en1, that.en1);
    }

    public int compareBegEnd(happenin that){
        if (Double.compare(this.en1, that.bg1) == 0){
            return Double.compare(this.en2, that.bg2);
        }
        return Double.compare(this.en1, that.bg1);
    }
}
