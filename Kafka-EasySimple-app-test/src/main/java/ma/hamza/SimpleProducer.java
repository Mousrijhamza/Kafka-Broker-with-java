package ma.hamza;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class SimpleProducer {
    public static void main(String[] args) {
        // Configuration des propriétés du producteur
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        // Créer le producteur
        KafkaProducer<String, String> producer = new KafkaProducer<>(props);

        // Envoyer des messages
        for (int i = 0; i < 10; i++) {
            ProducerRecord<String, String> record = new ProducerRecord<>("test-topic", "key" + i, "value" + i);
            producer.send(record);
        }

        // Fermer le producteur
        producer.close();
    }
}
