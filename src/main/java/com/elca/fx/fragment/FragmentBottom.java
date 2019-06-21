package com.elca.fx.fragment;

import org.jacpfx.api.annotations.fragment.Fragment;
import org.jacpfx.api.fragment.Scope;

import com.elca.fx.config.BaseConfig;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;

/**
 *
 * @author bhr
 */
@Fragment(id = BaseConfig.FRAGMENT_BOTTOM,
        viewLocation = "/fxml/FragmentBottom.fxml",
        resourceBundleLocation = "bundles.languageBundle",
        localeID = "en_US",
        scope = Scope.PROTOTYPE)
public class FragmentBottom {


    @FXML
    private CheckBox localChk;


    public CheckBox getLocalChk() {
        return this.localChk;
    }

}
