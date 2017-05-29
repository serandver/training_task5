package ua.kpi.tef.controller;

import ua.kpi.tef.model.entity.Book;
import ua.kpi.tef.model.entity.LibraryBook;
import ua.kpi.tef.view.View;

public class Controller {
    private ReflectionUtils reflectionUtils;
    private View view;

    public Controller(ReflectionUtils reflectionUtils, View view) {
        this.reflectionUtils = reflectionUtils;
        this.view = view;
    }

    // The Work method
    public void processUser(){
        Class parentClass = reflectionUtils.getClassFromString(view.getParentClassName());
        Class childClass = reflectionUtils.getClassFromString(view.getChildClassName());
        Class methodAnnotationClass = reflectionUtils.getClassFromString(view.getAnnotationClassName());

        Book book = getParentInstance();
        Book libraryBook = getChildInstance();

        reflectionUtils.invokeAnnotatedMethods(parentClass, methodAnnotationClass, book);
        reflectionUtils.invokeAnnotatedMethods(childClass, methodAnnotationClass, libraryBook);

        reflectionUtils.printInterfaces(parentClass);
        reflectionUtils.printInterfaces(childClass);

        reflectionUtils.printFields(parentClass);
        reflectionUtils.printFields(childClass);

        reflectionUtils.printConstructors(parentClass);
        reflectionUtils.printConstructors(childClass);
    }

    private Book getChildInstance() {
        View.print("Create child instance:");
        return new LibraryBook("1812", "Pushkin", "1850", 987654321L,
                300, 1041220000L, "Petya");
    }

    private Book getParentInstance() {
        View.print("Create parent instance:");
        return new Book("1984", "George Orwell", "1960", 1234567890L, 500);
    }
}
