package artemtsmyg.ru.DZ_Spring_sem_8.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
/**
 * Аспект для логирования действий пользователей.
 */
@Aspect
public class LoggingAspect {
    /**
     * Логирование после успешного выполнения метода с аннотацией TrackUserAction.
     * @param joinPoint точка соединения
     * @param returning возвращаемое значение
     */
    @AfterReturning(value = "@annotation(TrackUserAction)", returning = "returning")
    public void logAfterReturning(JoinPoint joinPoint, Object returning) {
        System.out.println("Метод " + joinPoint.getSignature().getName() + " был вызван\nВернуть "
                + returning.getClass());
    }
    /**
     * Логирование при возникновении исключения в методе с аннотацией TrackUserAction.
     * @param joinPoint точка соединения
     * @param ex исключение, выбрасываемые методом.
     */
    @AfterThrowing(value = "@annotation(TrackUserAction)", throwing = "ex")
    public void logException(JoinPoint joinPoint, Exception ex) {
        System.out.println("Метод " + joinPoint.getSignature().getName() + " вернул исключение "
                + ex.getClass() + " " + ex.getMessage());

    }
}