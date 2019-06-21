package com.elca.fx.workbench;

import org.jacpfx.api.annotations.Resource;
import org.jacpfx.api.annotations.workbench.Workbench;
import org.jacpfx.api.componentLayout.WorkbenchLayout;
import org.jacpfx.api.message.Message;
import org.jacpfx.api.util.ToolbarPosition;
import org.jacpfx.rcp.componentLayout.FXComponentLayout;
import org.jacpfx.rcp.context.Context;
import org.jacpfx.rcp.workbench.FXWorkbench;

import com.elca.fx.config.BaseConfig;

import javafx.event.Event;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author bhr
 */
@Workbench(id = BaseConfig.WORKBENCH_ID, name = "workbench",
        perspectives = {
                BaseConfig.PERSPECTIVE_TWO,
                BaseConfig.PERSPECTIVE_ONE
        })
public class JacpFXWorkbench implements FXWorkbench {

    @Resource
    private Context context;

    @Override
    public void handleInitialLayout(final Message<Event, Object> action,
                                    final WorkbenchLayout<Node> layout, final Stage stage) {
        layout.setWorkbenchXYSize(1024, 768);
        layout.registerToolBar(ToolbarPosition.NORTH);
        layout.setStyle(StageStyle.DECORATED);
        layout.setMenuEnabled(false);


    }

    @Override
    public void postHandle(final FXComponentLayout layout) {

    }
}
