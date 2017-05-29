package ua.kpi.tef.view;

import java.util.Locale;
import java.util.ResourceBundle;

public class View {
    public static final String MESSAGES_BUNDLE_PATH = "ua.kpi.tef.resources.messages";
    public static final ResourceBundle bundle = ResourceBundle.getBundle(MESSAGES_BUNDLE_PATH);

    private static String PARENT_CLASS_NAME = "parent.class.name";
    private static String CHILD_CLASS_NAME = "child.class.name";
    private static String ANNOTATION_CLASS_NAME = "annotation.class.name";

    public static void print(String message) {
        System.out.println(message);
    }

    public static String concat(String... message) {
        StringBuilder concatString = new StringBuilder();
        for (String v : message) {
            concatString = concatString.append(v);
        }
        return new String(concatString);
    }

    public String getParentClassName() {
        return bundle.getString(PARENT_CLASS_NAME);
    }

    public String getChildClassName() {
        return bundle.getString(CHILD_CLASS_NAME);
    }

    public String getAnnotationClassName() {
        return bundle.getString(ANNOTATION_CLASS_NAME);
    }
}
