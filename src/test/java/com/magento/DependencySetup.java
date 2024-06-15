package com.magento;

import com.magento.utils.WebUtil;
import io.cucumber.java.BeforeAll;

public class DependencySetup {
    @BeforeAll
    public static void setUp() {
        PicoFactory picoFactory = new PicoFactory();
        picoFactory.addClass(WebUtil.getInstance().getClass());
    }
}
