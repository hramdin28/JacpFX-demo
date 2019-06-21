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
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

/**
 *
 * @author bhr
 */
@Perspective(id = BaseConfig.PERSPECTIVE_ONE, name = "p1", components = {
        BaseConfig.COMPONENT
},
        viewLocation = "/fxml/PerspectiveOne.fxml")
public class PerspectiveOne implements FXPerspective {

    @Resource
    public Context context;
    @FXML
    private HBox content;


    @Override
    public void handlePerspective(Message<Event, Object> message, PerspectiveLayout perspectiveLayout) {

    }

    @PostConstruct
    public void onStartPerspective(final PerspectiveLayout perspectiveLayout, final FXComponentLayout layout,
                                   final ResourceBundle resourceBundle) {

        // register Content
        perspectiveLayout.registerTargetLayoutComponent(BaseConfig.TARGET_CONTAINER, content);

        createToolbar(layout);
    }

    private void createToolbar(final FXComponentLayout layout) {
        // define toolbars and menu entries
        JACPOptionButton optionButton = new JACPOptionButton("Perspective 1", layout);
        JACPToolBar toolbar = layout.getRegisteredToolBar(ToolbarPosition.NORTH);


        Button button = new Button("Perspective 2");
        button.setOnAction((event) -> {
            context.send(BaseConfig.PERSPECTIVE_TWO, "Pers 2");
        });

        JACPOptionButton options = new JACPOptionButton("Perspectives", layout);
        options.addOption(button);


        toolbar.addAllOnEnd(options);
    }
}
