package aop.example.introduction;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class KafkaIntroducer {
    @DeclareParents(value = "aop.example.introduction.Service+",
            defaultImpl = KafkaMessagerImpl.class)
    public static KafkaMessager kafkaMessager;
}
