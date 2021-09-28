package org.when.gui.sync.separated;

import javafx.scene.Parent;
import org.when.gui.BaseApp;

/**
 * @author: when
 * @create: 2021-09-28  17:44
 **/
public class AssessmentApp extends BaseApp {

    @Override
    protected Parent createContent() {
        Reading model = new Reading(0L, 42L);
        return new AssessmentWindow(model);
    }
}
