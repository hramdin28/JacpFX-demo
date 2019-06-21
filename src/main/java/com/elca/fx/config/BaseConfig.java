package com.elca.fx.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author bhr
 */
@Configuration
@ComponentScan
public class BaseConfig {

    public static final String WORKBENCH_ID = "wkB1";

    public static final String PERSPECTIVE_ONE = "persOne";
    public static final String PERSPECTIVE_TWO = "persTwo";

    public static final String TARGET_CONTAINER = "PContainer";

    public static final String COMPONENT = "cpId";

    public static final String FRAGMENT_ONE = "frTop";
    public static final String FRAGMENT_Middle = "frMiddle";
    public static final String FRAGMENT_BOTTOM = "frBottom";

}