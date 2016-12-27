package vipe.test.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * All web layer configurations such as REST controllers and other support beans should be done here. This is used by the
 * spring to create the web application context.
 *
 * Created by viraj on 5/19/16.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"vipe.test.web"})
public class WebContextConfig extends WebMvcConfigurerAdapter {



    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        // Serve static resources (*.html, ...) from src/main/webapp/
        configurer.enable();
    }

//    @Bean
//    public ViewResolver viewResolver() {
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        registry.viewResolver(viewResolver);
    }

}
