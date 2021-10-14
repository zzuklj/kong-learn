package com.klj.konglearn.demo.kafka;

import com.klj.konglearn.tool.YamlProperties;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class Producer {

    static final String TOPIC = "test-klj";
    static String BOOTSTRAP_SERVERS;
    static {
        BOOTSTRAP_SERVERS = YamlProperties.readTiledProperties().getProperty("kafka.bootstrap-servers");
    }

    public static void main(String[] args) {
        KafkaProperties kafkaProperties = new KafkaProperties(BOOTSTRAP_SERVERS);
        org.apache.kafka.clients.producer.Producer<String, String> producer = new KafkaProducer<>(kafkaProperties);
        for (int i = 0; i < 5; i++)
            producer.send(new ProducerRecord<String, String>(TOPIC, Integer.toString(i), Integer.toString(i)));
        producer.close();
    }
}
