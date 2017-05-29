package ua.kpi.tef.view;

import java.util.Locale;
import java.util.ResourceBundle;

public class View {
    public static final String MESSAGES_BUNDLE_PATH = "ua.kpi.tef.resources.messages";
    public static final ResourceBundle bundle = ResourceBundle.getBundle(MESSAGES_BUNDLE_PATH);

    //Text constants
    public static String COLON = ": ";
    public static String SEMICOLON = ";";
    public static String TAB = "\t";
    public static String SPACE = " ";

    //Bundle messages
    private static String PARENT_CLASS_NAME = "parent.class.name";
    private static String CHILD_CLASS_NAME = "child.class.name";
    private static String ANNOTATION_CLASS_NAME = "annotation.class.name";
    private static String INVOKE_METHOD_MESSAGE = "print.invoke.methods";
    private static String PRINT_INTERFACES_MESSAGE = "print.interfaces";
    private static String PRINT_FIELDS_MESSAGE = "print.fields";
    private static String PRINT_CONSTRUCTOR_MESSAGE = "print.constructors";
    private static String CREATE_PARENT_OBJECT = "print.parent.object";
    private static String CREATE_CHILD_OBJECT = "print.child.object";

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

    public String getInvokeMethodMessage() {
        return bundle.getString(INVOKE_METHOD_MESSAGE);
    }

    public String getPrintInterfacesMessage() {
        return bundle.getString(PRINT_INTERFACES_MESSAGE);
    }

    public String getPrintFieldsMessage(){
        return bundle.getString(PRINT_FIELDS_MESSAGE);
    }

    public String getPrintConstructorMessage() {
        return bundle.getString(PRINT_CONSTRUCTOR_MESSAGE);
    }

    public String getCreateParentObjectMessage() {
        return bundle.getString(CREATE_PARENT_OBJECT);
    }

    public String getCreateChildObjectMessage() {
        return bundle.getString(CREATE_CHILD_OBJECT);
    }
}
