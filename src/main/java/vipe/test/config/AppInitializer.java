package vipe.test.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * Returns the root application context configurations.
     * @return an array of classes each contains root application context configurations
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{RootApplicationContextConfig.class};
    }

    /**
     * Returns web context configurations.
     * @return an array of classes, each contains web application context configurations.
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] {WebContextConfig.class};
    }

    /**
     * Returns the mapping used for springs dispatcher servlet.
     * @return
     */
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }


}
