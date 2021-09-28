package org.when.gui.sync.observer;

import java.util.Objects;

/**
 * @author: when
 * @create: 2021-09-22  09:53
 **/
public class ReadingModel extends Subject {

    private Long actual;
    private Long target;

    public ReadingModel(Long actual, Long target) {
        this.actual = actual;
        this.target = target;
    }

    public Long getActual() {
        return actual;
    }

    public void setActual(Long actual) {
        this.actual = actual;
        notifyListeners();
    }

    public Long getTarget() {
        return target;
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
