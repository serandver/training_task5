package ua.kpi.tef;

import java.lang.reflect.Method;

public class Runner {
    public static void main(String[] args) throws Exception{

        String bookClassName = "ua.kpi.tef.Book";
        Class clazz1 = Class.forName(bookClassName);
//        Object book = clazz1.newInstance();
        Book book1 = new Book("1984", "George Orwell", "1860", 1234567890L, 500);

        for (Method method: clazz1.getDeclaredMethods()) {
            if(method.isAnnotationPresent(MyAnnotation.class)) {
                Object result;
                if (method.isAccessible()) {
                    result = method.invoke(book1);
                }
                else {
                    method.setAccessible(true);
                    result = method.invoke(book1);
                }
                System.out.println(method.getName() + ": " + result);
            }
        }

        String libraryBookName = "ua.kpi.tef.LibraryBook";
        Class clazz2 = Class.forName(libraryBookName);
//        Object libraryBook = clazz2.newInstance();
        Book libraryBook1 = new LibraryBook("1812", "Pushkin", "1850", 987654321L, 300, 1041220000L, "Petya");

        for (Method method: clazz2.getDeclaredMethods()) {
            if(method.isAnnotationPresent(MyAnnotation.class)) {
                Object result;
                if (method.isAccessible()) {
                    result = method.invoke(libraryBook1);
                }
                else {
                    method.setAccessible(true);
                    result = method.invoke(libraryBook1);
                }
                System.out.println(method.getName() + ": " + result);
            }
        }

        System.out.println("Class libraryBook1: " + libraryBook1.getClass().getName());
        System.out.println("Interfaces of libraryBook1: " );
        Class[] interfaces =  libraryBookName.getClass().getInterfaces();
        for (Class c: interfaces) {
            System.out.println(c + " ");
        }

    }
}
