package pl.coderslab.spring01hibernatekrkw07.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import pl.coderslab.spring01hibernatekrkw07.converter.AuthorConverter;
import pl.coderslab.spring01hibernatekrkw07.converter.PublisherConverter;

import javax.persistence.EntityManagerFactory;

@Configuration
@ComponentScan("pl.coderslab.spring01hibernatekrkw07")
@EnableWebMvc
@EnableTransactionManagement
public class AppConfig implements WebMvcConfigurer {
    @Override
    public void configureDefaultServletHandling(
            DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/views/", ".jsp");
    }

    @Bean
    public LocalEntityManagerFactoryBean entityManagerFactory() {
        LocalEntityManagerFactoryBean entityManagerFactoryBean
                = new LocalEntityManagerFactoryBean();
        entityManagerFactoryBean.setPersistenceUnitName("myFirstPersistenceUnit");
        return entityManagerFactoryBean;
    }
    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager jpaTransactionManager =
                new JpaTransactionManager(entityManagerFactory);
        return jpaTransactionManager;
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(publisherConverter());
        registry.addConverter(authorConverter());
    }

    @Bean
    public PublisherConverter publisherConverter (){
        return new PublisherConverter();
    }

    @Bean
    public AuthorConverter authorConverter (){
        return new AuthorConverter();
    }

}