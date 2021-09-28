package org.when.gui.sync.separated;


import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

/**
 * @author: when
 * @create: 2021-09-25  11:33
 **/
public class AssessmentWindow extends VBox {

    private Reading reading;
    private TextField actualField;
    private Text targetField;
    private Text varianceField;

    public AssessmentWindow(Reading reading) {
        this.reading = reading;
        createView();
        createControl();
    }

    private void createView() {
        this.actualField = new TextField(reading.getActual().toString());
        this.targetField = new Text(reading.getTarget().toString());
        this.varianceField = new Text("#variance");
        getChildren().addAll(actualField, targetField, varianceField);
    }

    private void createControl() {
        this.actualField.textProperty().addListener(((observable, oldValue, newValue) -> updateVarianceField()));
    }

    private void updateVarianceField() {
        varianceField.setFill(varianceColor());
        varianceField.setText(String.valueOf(reading.getVariance()));
    }

    private Color varianceColor() {
        switch (reading.getVarianceCategory()) {
            case LOW:
                return Color.RED;
            case HIGH:
                return Color.GREEN;
            case NULL:
            case NORMAL:
                return Color.BLACK;
            default:
                throw new IllegalArgumentException("Unknown variance category");
        }
    }

}
