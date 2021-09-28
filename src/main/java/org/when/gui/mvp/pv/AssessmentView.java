package org.when.gui.mvp.pv;

import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

/**
 * @author: when
 * @create: 2021-09-28  16:08
 **/
public class AssessmentView extends VBox {
    private TextField actualField;
    private Text targetField;
    private Text varianceField;

    public AssessmentView() {
        createView();
    }

    public TextField getActualField() {
        return actualField;
    }

    public void setActual(Long actual) {
        actualField.setText(actual.toString());
    }

    public void setTarget(Long target) {
        targetField.setText(target.toString());
    }

    public void setVariance(Long variance) {
        varianceField.setText(variance.toString());
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
}
