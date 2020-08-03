package aop.example.introduction;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Aspect
public class TopicAspect {
    private List<String> topic = new ArrayList<>();

    @Pointcut("execution(* aop.example.introduction.KafkaMessager.sendToKafka(String)) " +
            "&& args(message)")
    public void sendToKafka(String message) {}

    @After("sendToKafka(message)")
    public void addMessageToTopic(String message) {
        System.out.println("Adding message to topic");
        topic.add(message);
    }

    public List<String> getTopic() {
        return topic;
    }
}
