package ma.hamza;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.IntegerSerializer;

import java.util.Properties;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;



public class StreamProducer{
    private int counter;
    private String KAFKA_BROKER_URL="127.0.0.1:9092";
    private String TOPIC_NAME="test-1";
    private String clientID="client_prod_1";
    public static void main(String[] args) {
        new StreamProducer();
    }
    public StreamProducer() {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", KAFKA_BROKER_URL);
        properties.put("client.id", clientID);
        properties.put("key.serializer", IntegerSerializer.class.getName());
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        KafkaProducer<Integer, String> producer = new KafkaProducer<>(properties);
        Executors.newScheduledThreadPool(1).scheduleAtFixedRate(()->{
            System.out.println("gegi \n");
            ++counter;String msg=String.valueOf(Math.random()*1000);
            producer.send(new ProducerRecord<Integer, String>(TOPIC_NAME,++counter,msg),
                    (metadata,ex)->{
                        System.out.println("Sending Message key=>"+counter+" Value =>"+msg);
                        System.out.println("Partition => "+metadata.partition()+" Offset=>"+metadata.offset());
                    });
        },1000,1000, TimeUnit.MILLISECONDS);
    }
}