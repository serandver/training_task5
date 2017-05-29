package ua.kpi.tef.controller;

import ua.kpi.tef.model.entity.Book;

import java.lang.reflect.*;
import java.util.Arrays;

import static ua.kpi.tef.view.View.concat;
import static ua.kpi.tef.view.View.print;

public class ReflectionUtils {

    void invokeAnnotatedMethods(Class bookClass, Class annotationClass, Book bookInstance) {
        print(concat("Invoke methods, annotated with ", annotationClass.getName()));
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
                print(concat(method.getName(), ": ", result.toString()));
            }
        }
    }

    void printInterfaces(Class clazz) {
        print(concat("Interfaces of ", clazz.getName(), ": "));
        Type[] interfaces = clazz.getGenericInterfaces();
        print(Arrays.toString(interfaces));
    }

    void printFields(Class clazz) {
        print(concat("All fields of ", clazz.getName(), ": "));
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            print(concat("\t", getModifiers(field.getModifiers()),
                    getType(field.getType()), " ", field.getName(), ";"));
        }
    }

    void printConstructors (Class clazz) {
        print(concat("Constructors of ", clazz.getName(), ": "));
        Constructor[] constructors = clazz.getDeclaredConstructors();
        for (Constructor c : constructors) {
            print(concat("\t", getModifiers(c.getModifiers()), clazz.getSimpleName(),
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
