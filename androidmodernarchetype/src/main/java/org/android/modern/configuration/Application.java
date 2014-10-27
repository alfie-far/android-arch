package org.android.modern.configuration;

import dagger.ObjectGraph;

/**
 * @author amin rahimi farzin
 * @version 1.0
 */
@SuppressWarnings("UnusedDeclaration")
public class Application extends android.app.Application {

    /*
    Singleton pattern for application class
     */
    private static Application applicationSingleInstance;
    /**
     * This is used to handle dependency injection
     */
    private ObjectGraph objectGraph;
    /////////////////////////////////////////////////////////////////


    /*
    Application class specific properties and methods
     */

    public static Application getApplication() {
        return applicationSingleInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        applicationSingleInstance = this;
        configureDependencyInjectionGraph();

    }

    private void configureDependencyInjectionGraph() {
        objectGraph = ObjectGraph
                .create(new ApplicationProviderModule())
        ;
    }

    /**
     * Used to add dependency resolver outside of application class
     *
     * @param dependencyResolver
     */
    public void addDependencyResolver(Object dependencyResolver) {
        objectGraph = objectGraph.plus(dependencyResolver);
    }

    /**
     * Used to register objects that depend on dependency injection
     *
     * @param instance The object instance that is going to have it's properties injected
     * @param <T>
     * @return
     */
    public <T> T inject(T instance) {
        return objectGraph.inject(instance);
    }
}