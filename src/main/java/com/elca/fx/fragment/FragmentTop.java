package com.elca.fx.fragment;

import java.util.HashMap;
import java.util.Map;

import org.jacpfx.api.annotations.Resource;
import org.jacpfx.api.annotations.fragment.Fragment;
import org.jacpfx.api.fragment.Scope;
import org.jacpfx.rcp.context.Context;

import com.elca.fx.config.BaseConfig;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 *
 * @author bhr
 */
@Fragment(id = BaseConfig.FRAGMENT_ONE,
        viewLocation = "/fxml/FragmentTop.fxml",
        resourceBundleLocation = "bundles.languageBundle",
        localeID = "en_US",
        scope = Scope.PROTOTYPE)
public class FragmentTop {
    @Resource
    private Context context;

    Map<String, String> data = new HashMap(1);

    @FXML
    private TextField address;

    public void init() {

        address.setOnKeyReleased(event -> {
            final String nameValue = address.getText();
            data.put("address", nameValue);
            context.send(BaseConfig.PERSPECTIVE_ONE.concat(".").concat(BaseConfig.COMPONENT), data);
        });

    }

    public TextField getAddress() {
        return this.address;
    }
}


