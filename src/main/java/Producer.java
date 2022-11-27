import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class Producer {

    @Autowired
    KafkaTemplate<String,String> kafkaTemplate;

    public void send(String msg){
        kafkaTemplate.send("sweta","this produced data will send to kafka topic");
    }
}
