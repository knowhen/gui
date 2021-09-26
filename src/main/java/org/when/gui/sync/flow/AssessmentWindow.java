package org.when.gui.sync.flow;


import javafx.application.Application;
import javafx.beans.property.StringProperty;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;

/**
 * @author: when
 * @create: 2021-09-25  11:33
 **/
public class AssessmentWindow extends Application {

    private final Reading reading;
    private final TextField actualField;
    private final Text targetField;
    private final Text varianceField;

    public AssessmentWindow() {
        this.reading = new Reading();
        this.actualField = new TextField();
        this.targetField = new Text();
        this.varianceField = new Text();

        StringProperty actualProperty = actualField.textProperty();
        StringConverter<Number> numberStringConverter = new NumberStringConverter();
        actualProperty.bindBidirectional(reading.actualProperty(), numberStringConverter);
        actualProperty.addListener((observable, oldValue, newValue) -> updateVarianceField());
        targetField.textProperty().bindBidirectional(reading.targetProperty(), numberStringConverter);
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

    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(createContent()));
        stage.show();
    }

    private Parent createContent() {
        VBox vBox = new VBox();
        vBox.getChildren().addAll(actualField, targetField, varianceField);
        return vBox;
    }

}
