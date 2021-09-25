package org.when.gui.flow;

import javax.swing.*;
import java.awt.*;

/**
 * @author: when
 * @create: 2021-09-25  11:33
 **/
public class AssessmentWindow {

    private JFormattedTextField dateField, actualField, targetField, varianceField;
    private Reading currentReading;

    private void updateVarianceField() {
        varianceField.setValue(currentReading.getVariance());
        varianceField.setForeground(varianceColor());
    }

    private Color varianceColor() {
        switch (currentReading.getVarianceCategory()) {
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
