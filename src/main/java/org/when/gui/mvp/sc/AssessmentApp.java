package org.when.gui.mvp.sc;

import javafx.scene.Parent;
import org.when.gui.BaseApp;

/**
 * @author: when
 * @create: 2021-09-28  16:53
 **/
public class AssessmentApp extends BaseApp {
    @Override
    protected Parent createContent() {
        ReadingModel model = new ReadingModel(0L, 42L);
        AssessmentView view = new AssessmentView(model);
        AssessmentController controller = new AssessmentController(model, view);
        return view;
    }
}
