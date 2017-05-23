package ua.kpi.tef.model;

import ua.kpi.tef.model.entity.Book;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Model {

    public void invokeAnnotatedMethods(Class bookClass, Class annotationClass, Book bookInstance) throws IllegalAccessException, InvocationTargetException {
        for (Method method: bookClass.getDeclaredMethods()) {
            if(method.isAnnotationPresent(annotationClass)) {
                Object result;
                if (method.isAccessible()) {
                    result = method.invoke(bookInstance);
                }
                else {
                    method.setAccessible(true);
                    result = method.invoke(bookInstance);
                }
                System.out.println(method.getName() + ": " + result);
            }
        }
    }

    public void printInterfaces(Class clazz) {
        System.out.println("Class libraryBook1: " + clazz.getName());
        System.out.println("Interfaces of libraryBook1: " );
        Class[] interfaces =  clazz.getInterfaces();
        for (Class c: interfaces) {
            System.out.println(c + " ");
        }
    }
}
