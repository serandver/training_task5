package ua.kpi.tef;

import ua.kpi.tef.controller.Controller;
import ua.kpi.tef.controller.ReflectionUtils;
import ua.kpi.tef.view.View;


public class Runner {
    public static void main(String[] args) {

        // Initialization
        View view = new View();
        ReflectionUtils reflectionUtils = new ReflectionUtils(view);
        Controller controller = new Controller(reflectionUtils, view);

        // Run
        controller.processUser();
    }
}
