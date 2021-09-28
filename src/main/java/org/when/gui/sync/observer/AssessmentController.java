package org.when.gui.sync.observer;

/**
 * @author: when
 * @create: 2021-09-28  09:19
 **/
public class AssessmentController {
    private final ReadingModel model;
    private final AssessmentView view;

    public AssessmentController(ReadingModel model) {
        this.model = model;
        this.view = new AssessmentView(model, this);
    }

    public void setActual(Long actual) {
        model.setActual(actual);
    }

    public AssessmentView getView() {
        return view;
    }
}
