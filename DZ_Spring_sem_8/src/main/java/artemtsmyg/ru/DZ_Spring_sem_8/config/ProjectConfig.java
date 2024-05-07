package artemtsmyg.ru.DZ_Spring_sem_8.config;

import artemtsmyg.ru.DZ_Spring_sem_8.aspect.LoggingAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan
@EnableAspectJAutoProxy

/**
 * Конфигурационный класс для проекта.
 */
public class ProjectConfig {
    @Bean
    /**
     * Метод, создающий и возвращающий экземпляр LoggingAspect.
     */
    public LoggingAspect loggingAspect(){
        return new LoggingAspect();
    }
}
