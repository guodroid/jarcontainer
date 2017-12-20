package com.okwallet.jarcontainer;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.JarURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.jar.Attributes;

class JarClassLoader extends URLClassLoader {

    //Copy from Java tutorial. https://docs.oracle.com/javase/tutorial/deployment/jar/jarclassloader.html
    private String fullFilePath;

    public JarClassLoader(String fullFilePath) throws MalformedURLException {
        //TODO: should url, but I confused by url, so change to fullFilePath
        super(new URL[]{new File(fullFilePath).toURL()}, JarClassLoader.class.getClassLoader());
        this.fullFilePath = fullFilePath;
    }

    public String getMainClassName() throws IOException {
        URL u = new URL("jar", "", "file://" + fullFilePath + "!/");
        JarURLConnection uc = (JarURLConnection) u.openConnection();
        Attributes attr = uc.getMainAttributes();
        return attr != null ? attr.getValue(Attributes.Name.MAIN_CLASS) : null;
    }

    public void invokeClass(String name, String[] args) throws ClassNotFoundException,
            NoSuchMethodException, InvocationTargetException {
        Class c = Class.forName(name, true, this);
        Method m = c.getMethod("main", new Class[]{args.getClass()});
        m.setAccessible(true);
        int mods = m.getModifiers();
        if (m.getReturnType() != void.class || !Modifier.isStatic(mods) || !Modifier.isPublic(mods)) {
            throw new NoSuchMethodException("main");
        }
        try {
            m.invoke(null, new Object[]{args});
        } catch (IllegalAccessException e) {

        }
    }
}