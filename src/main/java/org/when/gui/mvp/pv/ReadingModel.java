package org.when.gui.mvp.pv;

import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;

import java.util.Objects;

/**
 * @author: when
 * @create: 2021-09-28  16:08
 **/
public class ReadingModel {
    private LongProperty actual;
    private LongProperty target;

    public ReadingModel(Long actual, Long target) {
        this(new SimpleLongProperty(actual), new SimpleLongProperty(target));
    }

    public ReadingModel(LongProperty actual, LongProperty target) {
        this.actual = actual;
        this.target = target;
    }


    public LongProperty actualProperty() {
        return actual;
    }

    public LongProperty targetProperty() {
        return target;
    }

    public Long getActual() {
        return actual.getValue();
    }

    public Long getTarget() {
        return target.getValue();
    }

    public void setActual(Long actual) {
        if (Objects.isNull(actual)) {
            actual = 0L;
        }
        this.actual.set(actual);
    }

    public Long getVariance() {
        if (Objects.isNull(getActual())) {
            return null;
        }
        return getActual() - getTarget();
    }

    public long getVarianceRatio() {
        return Math.round(100.0 * getVariance() / getTarget());
    }

    public VarianceCategory getVarianceCategory() {
        if (Objects.isNull(getVariance())) {
            return VarianceCategory.NULL;
        }
        if (getVarianceRatio() < -10) {
            return VarianceCategory.LOW;
        } else if (getVarianceRatio() > 5) {
            return VarianceCategory.HIGH;
        } else {
            return VarianceCategory.NORMAL;
        }
    }

    public enum VarianceCategory {LOW, NORMAL, HIGH, NULL}
}
