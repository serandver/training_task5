package ua.kpi.tef.controller;

import ua.kpi.tef.model.Model;
import ua.kpi.tef.model.entity.Book;
import ua.kpi.tef.model.entity.LibraryBook;
import ua.kpi.tef.view.View;

import java.util.Scanner;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model  = model;
        this.view = view;
    }

    // The Work method
    public void processUser(){
        Class parentClass = getClassFromString(view.getParentClassName());
        Class childClass = getClassFromString(view.getChildClassName());
        Class annotationClass = getClassFromString(view.getAnnotationClassName());

        Book book = getParentInstance();
        Book libraryBook = getChildInstance();

        model.invokeAnnotatedMethods(parentClass, annotationClass, book);
        model.invokeAnnotatedMethods(childClass, annotationClass, libraryBook);

        model.printInterfaces(parentClass);
        model.printInterfaces(childClass);
    }

    private Book getChildInstance() {
        //TODO invoke constructor via reflection & parameters in properties
        return getChildInstance();
    }

    private Book getParentInstance() {
        //TODO invoke constructor via reflection & parameters in properties
        return getParentInstance();
    }

    private Class getClassFromString (String className) {
        Class clazz = null;
        try {
            clazz = Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return clazz;
    }
}
