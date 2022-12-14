import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class KafkaDemoApplication implements ApplicationRunner {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public static void main(String[] args) {
        SpringApplication.run(KafkaDemoApplication.class, args);
    }

    public void sendMessage(String msg) {
        kafkaTemplate.send("sweta", msg);
    }

    @KafkaListener(topics = "sweta", groupId = "group-id")
    public void listen(String message) {
        System.out.println("Received Messasge in group - group-id: " + message);
    }
    @Override
    public void run(ApplicationArguments args) throws Exception {
        sendMessage("Hi lets understand processing of apache kafka");
    }
}