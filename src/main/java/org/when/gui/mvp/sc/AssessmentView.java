package org.when.gui.mvp.sc;

import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;

/**
 * @author: when
 * @create: 2021-09-28  16:08
 **/
public class AssessmentView extends VBox {
    private final ReadingModel reading;
    private TextField actualField;
    private Text targetField;
    private Text varianceField;

    public AssessmentView(ReadingModel reading) {
        this.reading = reading;
        createView();
        createBinding();
        createControl();
    }

    public TextField getActualField() {
        return actualField;
    }

    public void setVarianceColor(Color color) {
        varianceField.setFill(color);
    }

    private void createView() {
        this.actualField = new TextField();
        this.targetField = new Text();
        this.varianceField = new Text();
        getChildren().addAll(actualField, targetField, varianceField);
    }

    private void createBinding() {
        StringConverter<Number> numberStringConverter = new NumberStringConverter();
        this.actualField.textProperty().bindBidirectional(reading.actualProperty(), numberStringConverter);
        this.targetField.textProperty().bindBidirectional(reading.targetProperty(), numberStringConverter);
    }

    private void createControl() {
        this.reading.actualProperty().addListener(((observable, oldValue, newValue) -> this.varianceField.setText(reading.getVariance().toString())));
    }
}
