package com.elca.fx;

import org.jacpfx.rcp.workbench.FXWorkbench;
import org.jacpfx.spring.launcher.AFXSpringJavaConfigLauncher;

import com.elca.fx.config.BaseConfig;
import com.elca.fx.workbench.JacpFXWorkbench;

import javafx.application.Application;
import javafx.stage.Stage;


public class JavaFxDemoApplication extends AFXSpringJavaConfigLauncher {

    @Override
    protected Class<? extends FXWorkbench> getWorkbenchClass() {
        return JacpFXWorkbench.class;
    }

    @Override
    protected String[] getBasePackages() {
        return new String[]{"com.elca.fx"};
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void postInit(Stage stage) {
    }

    @Override
    protected Class<?>[] getConfigClasses() {
        return new Class<?>[]{BaseConfig.class};
    }
}
