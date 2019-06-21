package com.elca.fx.perspective;

import java.util.ResourceBundle;

import org.jacpfx.api.annotations.Resource;
import org.jacpfx.api.annotations.lifecycle.PostConstruct;
import org.jacpfx.api.annotations.perspective.Perspective;
import org.jacpfx.api.message.Message;
import org.jacpfx.api.util.ToolbarPosition;
import org.jacpfx.rcp.componentLayout.FXComponentLayout;
import org.jacpfx.rcp.componentLayout.PerspectiveLayout;
import org.jacpfx.rcp.components.toolBar.JACPOptionButton;
import org.jacpfx.rcp.components.toolBar.JACPToolBar;
import org.jacpfx.rcp.context.Context;
import org.jacpfx.rcp.perspective.FXPerspective;

import com.elca.fx.config.BaseConfig;

import javafx.event.Event;
import javafx.scene.control.Button;

/**
 *
 * @author bhr
 */
@Perspective(id = BaseConfig.PERSPECTIVE_TWO, name = "p1", components = {

},
        viewLocation = "/fxml/PerspectiveTwo.fxml")
public class PerspectiveTwo implements FXPerspective {

    @Resource
    public Context context;

    @Override
    public void handlePerspective(Message<Event, Object> message, PerspectiveLayout perspectiveLayout) {

    }

    @PostConstruct
    public void onStartPerspective(final PerspectiveLayout perspectiveLayout, final FXComponentLayout layout,
                                   final ResourceBundle resourceBundle) {

        createToolbar(layout);
    }

    private void createToolbar(final FXComponentLayout layout) {
        // define toolbars and menu entries
        JACPOptionButton optionButton = new JACPOptionButton("Perspective 1", layout);
        JACPToolBar toolbar = layout.getRegisteredToolBar(ToolbarPosition.NORTH);

        Button button = new Button("Perspective 1");
        button.setOnAction((event) -> {
            context.send(BaseConfig.PERSPECTIVE_ONE, "Pers 1");
        });

        JACPOptionButton options = new JACPOptionButton("Perspectives", layout);
        options.addOption(button);

        toolbar.addAllOnEnd(options);
    }
}
