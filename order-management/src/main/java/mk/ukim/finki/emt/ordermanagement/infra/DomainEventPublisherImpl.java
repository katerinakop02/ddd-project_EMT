package mk.ukim.finki.emt.ordermanagement.infra;
import mk.ukim.finki.emt.sharedkernel.domain.events.DomainEvent;
import mk.ukim.finki.emt.sharedkernel.domain.infra.DomainEventPublisher;
import org.springframework.kafka.core.KafkaTemplate;
public class DomainEventPublisherImpl implements DomainEventPublisher {


    private final KafkaTemplate<String,String> kafkaTemplate;

    public DomainEventPublisherImpl(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void publish(DomainEvent event) {
        this.kafkaTemplate.send(event.topic(),event.toJson());
    }

}
