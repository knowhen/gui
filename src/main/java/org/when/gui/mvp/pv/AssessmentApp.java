package org.when.gui.mvp.pv;

import javafx.scene.Parent;
import org.when.gui.BaseApp;

/**
 * @author: when
 * @create: 2021-09-28  17:10
 **/
public class AssessmentApp extends BaseApp {
    @Override
    protected Parent createContent() {
        ReadingModel model = new ReadingModel(0L, 42L);
        AssessmentView view = new AssessmentView();
        AssessmentController controller = new AssessmentController(model, view);
        return view;
    }
}
