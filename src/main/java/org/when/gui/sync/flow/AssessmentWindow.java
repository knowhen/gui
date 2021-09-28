package org.when.gui.sync.flow;

import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import org.when.gui.BaseApp;

import java.util.Objects;

/**
 * @author: when
 * @create: 2021-09-27  22:47
 **/
public class AssessmentWindow extends BaseApp {
    private final TextField actualField;
    private final Text targetField;
    private final Text varianceField;

    public AssessmentWindow() {
        this.actualField = new TextField("#actual");
        this.targetField = new Text("42");
        this.varianceField = new Text("#variance");
        actualField.textProperty().addListener((observable, oldValue, newValue) -> updateVarianceField());
    }

    private void updateVarianceField() {
        varianceField.setText(String.valueOf(getVariance()));
        varianceField.setFill(varianceColor());
    }

    public Long getActual() {
        String text = actualField.getText();
        return convertFrom(text);
    }

    public Long getTarget() {
        String text = targetField.getText();
        return convertFrom(text);
    }

    private Long convertFrom(String text) {
        if (Objects.isNull(text)) {
            return null;
        }
        text = text.trim();
        if (text.length() < 1) {
            return null;
        }
        return Long.parseLong(text);
    }

    public Long getVariance() {
        if (null == getActual()) {
            return null;
        }
        return getActual() - getTarget();
    }

    public long getVarianceRatio() {
        return Math.round(100.0 * getVariance() / getTarget());
    }

    public Color varianceColor() {
        if (null == getVariance()) {
            return Color.BLACK;
        }
        if (getVarianceRatio() < -10) {
            return Color.RED;
        } else if (getVarianceRatio() > 5) {
            return Color.GREEN;
        } else {
            return Color.BLACK;
        }
    }

    @Override
    protected Parent createContent() {
        VBox vBox = new VBox();
        vBox.getChildren().addAll(actualField, targetField, varianceField);
        return vBox;
    }
}
