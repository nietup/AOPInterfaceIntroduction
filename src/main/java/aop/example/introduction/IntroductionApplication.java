package aop.example.introduction;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@ComponentScan
@EnableAspectJAutoProxy
public class IntroductionApplication {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(IntroductionApplication.class);
        TopicAspect topic = context.getBean(TopicAspect.class);
        Service service = context.getBean(Service.class);
        ((KafkaMessager) service).sendToKafka("BBB"); //introductions allow you to cast objects to new interfaces
        topic.getTopic().forEach(System.out::println); //I don't know how to put a pointcut on an introduced method
    }
}
