package ua.kpi.tef.controller;

import ua.kpi.tef.model.entity.Book;
import ua.kpi.tef.view.View;

import java.lang.reflect.*;
import java.util.Arrays;

import static ua.kpi.tef.view.View.*;

public class ReflectionUtils {

    private View view;

    public ReflectionUtils(View view) {
        this.view = view;
    }

    void invokeAnnotatedMethods(Class bookClass, Class annotationClass, Book bookInstance) {
        print(concat(view.getInvokeMethodMessage(), annotationClass.getName(), COLON));
        for (Method method: bookClass.getDeclaredMethods()) {
            if(method.isAnnotationPresent(annotationClass)) {
                method.setAccessible(true);
                Object result = null;
                try {
                    result = method.invoke(bookInstance);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
                print(concat(TAB, method.getName(), COLON, result.toString()));
            }
        }
    }

    void printInterfaces(Class clazz) {
        print(concat(view.getPrintInterfacesMessage(), clazz.getName(), COLON));
        print(concat(TAB, Arrays.toString(clazz.getGenericInterfaces())));
    }

    void printFields(Class clazz) {
        print(concat(view.getPrintFieldsMessage(), clazz.getName(), COLON));
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            print(concat(TAB, getModifiers(field.getModifiers()),
                    getType(field.getType()), SPACE, field.getName(), SEMICOLON));
        }
    }

    void printConstructors (Class clazz) {
        print(concat(view.getPrintConstructorMessage(), clazz.getName(), COLON));
        Constructor[] constructors = clazz.getDeclaredConstructors();
        for (Constructor c : constructors) {
            print(concat(TAB, getModifiers(c.getModifiers()), clazz.getSimpleName(),
                    Arrays.toString(c.getParameterTypes())));
        }
    }

    private String getModifiers(int m) {
        String modifiers = "";
        if (Modifier.isPublic(m)) modifiers += "public ";
        if (Modifier.isProtected(m)) modifiers += "protected ";
        if (Modifier.isPrivate(m)) modifiers += "private ";
        if (Modifier.isStatic(m)) modifiers += "static ";
        if (Modifier.isAbstract(m)) modifiers += "abstract ";
        return modifiers;
    }

    private String getType(Class clazz) {
        String type = clazz.isArray()
                ? clazz.getComponentType().getSimpleName()
                : clazz.getSimpleName();
        if (clazz.isArray()) type += "[]";
        return type;
    }

    Class getClassFromString(String className) {
        Class clazz = null;
        try {
            clazz = Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return clazz;
    }
}
