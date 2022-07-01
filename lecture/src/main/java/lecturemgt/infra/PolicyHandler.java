package lecturemgt.infra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import lecturemgt.config.kafka.KafkaProcessor;
import lecturemgt.domain.LectureRepository;

@Service
public class PolicyHandler {

    @Autowired
    LectureRepository classRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}
    // keep

}
