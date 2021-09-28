package org.when.gui.sync.observer;

import javafx.scene.Parent;
import org.when.gui.BaseApp;

/**
 * @author: when
 * @create: 2021-09-28  17:37
 **/
public class AssessmentApp extends BaseApp {
    @Override
    protected Parent createContent() {
        ReadingModel model = new ReadingModel(0L, 42L);
        AssessmentController controller = new AssessmentController(model);
        return controller.getView();
    }
}
