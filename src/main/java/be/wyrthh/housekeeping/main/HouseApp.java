package be.wyrthh.housekeeping.main;

import be.wyrthh.housekeeping.configuration.AppConfig;
import be.wyrthh.housekeeping.cleaningServices.CleaningService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HouseApp {
    public static void main(String[] args) {

        // Here we create the application context
        ConfigurableApplicationContext appContext =
                new AnnotationConfigApplicationContext(AppConfig.class);

        CleaningService jill = appContext.getBean("Jill", CleaningService.class);

        jill.cleaning();
    }
}
