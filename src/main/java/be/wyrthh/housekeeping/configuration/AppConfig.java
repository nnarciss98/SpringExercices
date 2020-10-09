package be.wyrthh.housekeeping.configuration;

import be.wyrthh.housekeeping.cleaningServices.*;
import org.springframework.context.annotation.*;

/**
 * It doesn't need to be called "AppConfig", as long as it has the annotation "@Configuration", Spring knows it's a configuration class
 */
@Configuration
public class AppConfig {

    @Bean
    //This annotation creates a "proxy" that implements the same interface as the object (DisposableDuster), and assures us that each time an instance is needed in a singleton bean, the singleton gets a new instance of this bean
    @Scope(value = "prototype",proxyMode = ScopedProxyMode.INTERFACES)
    public DisposableDuster duster(){
        return new DisposableDuster();
    }

    @Bean(name="Broom")
    @Scope("prototype")
    public CleaningTool broom(){
        return new Broom();
    }

    //This allows us to give a name to the bean, and when it'll be "get" later, it'll have this name instead of the method name
    @Bean(name="VacuumCleaner")
    @Scope("prototype")
    public CleaningTool vacuum(){
        return new VacuumCleaner();
    }

    @Bean(name="Sponge")
    //This annotation will tell Spring to create a new instance each time we ask for this bean (be careful when you use this, it's not necessarily always a good idea)
    @Scope("prototype")
    public CleaningTool sponge(){
        return new Sponge();
    }

    @Bean(name="Jill")
    //This annotation changes when the bean is created. Instead of being created when the appContext is made, it'll be created when the bean is explicitly needed (only for singleton type)
    @Lazy
    public CleaningService broomCleaningService(){
        CleaningServiceImpl cs = new CleaningServiceImpl();
        cs.setCleaningTool(broom());
        return cs;
    }

    @Bean(name="SuckingService")
    @Lazy
    //This annotation is the default state for scope, it creates one instance, and that instance is the only one that will be given when we ask to get this bean
    @Scope("singleton")
    public CleaningService vacuumCleaningService(){
        CleaningServiceImpl cs = new CleaningServiceImpl();
        cs.setCleaningTool(vacuum());
        return cs;
    }

    @Bean
    @Lazy
    public CleaningService spongeCleaningService(){
        CleaningServiceImpl cs = new CleaningServiceImpl();
        cs.setCleaningTool(sponge());
        return cs;
    }
}
