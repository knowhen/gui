package org.when.gui.mvp.pv;

import javafx.scene.paint.Color;

import java.util.Objects;

/**
 * @author: when
 * @create: 2021-09-28  16:08
 **/
public class AssessmentController {
    private final ReadingModel model;
    private final AssessmentView view;

    public AssessmentController(ReadingModel model, AssessmentView view) {
        this.model = model;
        this.view = view;
        this.view.setActual(model.getActual());
        this.view.setTarget(model.getTarget());
        this.view.getActualField().textProperty().addListener((observable, oldValue, newValue) -> {
            Long actual = convertFrom(newValue);
            model.setActual(actual);
            updateView();
        });
    }

    private void updateView() {
        Long actual = model.getActual();
        Long variance = model.getVariance();
        view.setActual(actual);
        view.setVariance(variance);
        view.setVarianceColor(varianceColor());
    }

    private Color varianceColor() {
        switch (model.getVarianceCategory()) {
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
}
