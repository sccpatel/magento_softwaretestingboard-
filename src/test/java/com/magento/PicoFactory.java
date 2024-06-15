package com.magento;

import com.magento.utils.WebUtil;
import io.cucumber.core.backend.ObjectFactory;
import org.picocontainer.DefaultPicoContainer;
import org.picocontainer.MutablePicoContainer;

public class PicoFactory implements ObjectFactory {
    private static final MutablePicoContainer pico = new DefaultPicoContainer();

    public PicoFactory() {
        // Register the singleton instance of WebUtil
        pico.addComponent(WebUtil.getInstance());
    }

    @Override
    public void start() {
        pico.start();
    }

    @Override
    public void stop() {
        pico.stop();
        pico.dispose();
    }

    @Override
    public boolean addClass(Class<?> clazz) {
        if (pico.getComponentAdapter(clazz) == null) {
            pico.addComponent(clazz);
            System.out.println("Added class to PicoContainer: " + clazz.getName());
            return true;
        } else {
            System.out.println("Class already exists in PicoContainer: " + clazz.getName());
        }
        return false;
    }

    @Override
    public <T> T getInstance(Class<T> type) {
        return pico.getComponent(type);
    }

    public static <T> T getStaticInstance(Class<T> type) {
        return pico.getComponent(type);
    }

    public static boolean addStaticClass(Class<?> clazz) {
        if (pico.getComponentAdapter(clazz) == null) {
            pico.addComponent(clazz);
            System.out.println("Added class to PicoContainer: " + clazz.getName());
            return true;
        } else {
            System.out.println("Class already exists in PicoContainer: " + clazz.getName());
        }
        return false;
    }
}
