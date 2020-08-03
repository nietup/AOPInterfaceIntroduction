package aop.example.introduction;

public class KafkaMessagerImpl implements KafkaMessager {
    @Override
    public void sendToKafka(String message) {
        System.out.println("Sending { \"text\": \"" + message + "\" } to Kafka...");
    }
}
