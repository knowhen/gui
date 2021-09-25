package org.when.gui.flow;

import java.util.Objects;

/**
 * @author: when
 * @create: 2021-09-22  09:53
 **/
public class Reading {

    public Long getActual() {
        return 0L;
    }

    public Long getTarget() {
        return 0L;
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
