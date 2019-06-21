package com.elca.fx.fragment;

import org.jacpfx.api.annotations.fragment.Fragment;
import org.jacpfx.api.fragment.Scope;

import com.elca.fx.config.BaseConfig;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 *
 * @author bhr
 */
@Fragment(id = BaseConfig.FRAGMENT_Middle,
        viewLocation = "/fxml/FragmentMiddle.fxml",
        resourceBundleLocation = "bundles.languageBundle",
        localeID = "en_US",
        scope = Scope.PROTOTYPE)
public class FragmentMiddle {

    @FXML
    private TextField fNameTxt;

    @FXML
    private TextField lNameTxt;


    public TextField getfNameTxt() {
        return this.fNameTxt;
    }

    public TextField getlNameTxt() {
        return this.lNameTxt;
    }

}
