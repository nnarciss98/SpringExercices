package be.wyrthh.housekeeping.configuration;

import be.wyrthh.housekeeping.services.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

/**
 * It doesn't need to be called "AppConfig", as long as it has the annotation "@Configuration", Spring knows it's a configuration class
 */
@Configuration
public class AppConfig {

    @Bean
    //This annotation is the default state for scope, it creates one instance, and that instance is the only one that will be given when we ask to get this bean
    @Scope("singleton")
    public CleaningTool broom(){
        return new Broom();
    }

    //This allows us to give a name to the bean, and when it'll be "get" later, it'll have this name instead of the method name
    @Bean(name="aspirator")
    public CleaningTool vacuum(){
        return new VacuumCleaner();
    }

    @Bean
    //This annotation will tell Spring to create a new instance each time we ask for this bean (be careful when you use this, it's not necessarily always a good idea)
    @Scope("prototype")
    public CleaningTool sponge(){
        return new Sponge();
    }

    @Bean
    //This annotation changes when the bean is created. Instead of being created when the appContext is made, it'll be created when the bean is explicitly needed (only for singleton type)
    @Lazy
    public CleaningService broomCleaningService(){
        CleaningServiceImpl cs = new CleaningServiceImpl();
        cs.setCleaningTool(broom());
        return cs;
    }

    @Bean
    public CleaningService vacuumCleaningService(){
        CleaningServiceImpl cs = new CleaningServiceImpl();
        cs.setCleaningTool(vacuum());
        return cs;
    }

    @Bean
    public CleaningService spongeCleaningService(){
        CleaningServiceImpl cs = new CleaningServiceImpl();
        cs.setCleaningTool(sponge());
        return cs;
    }
}
