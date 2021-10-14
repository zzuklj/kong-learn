package com.klj.konglearn.demo.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.openjdk.jmh.util.FileUtils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;

import static com.klj.konglearn.demo.kafka.Producer.BOOTSTRAP_SERVERS;
import static com.klj.konglearn.demo.kafka.Producer.TOPIC;

public class Consumer {

    static final String filePath = "D:\\klj\\kafka-data.txt";

    public static void main(String[] args) {
        KafkaProperties kafkaProperties = new KafkaProperties(BOOTSTRAP_SERVERS);
        kafkaProperties.put("group.id", "testKljGroup");
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(kafkaProperties);
        consumer.subscribe(Collections.singleton(TOPIC));

        while (true) {
            ConsumerRecords<String, String> consumerRecords = consumer.poll(Duration.ofSeconds(1));
            consumerRecords.forEach(c ->
                    {
                        try {
                            FileUtils.appendLines(
                                    new File(filePath),
                                    Collections.singleton(
                                            String.format("time = %s, partition = %d,offset = %d, key = %s, value = %s%n",
                                                    LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME),
                                                    c.partition(),
                                                    c.offset(),
                                                    c.key(),
                                                    c.value())));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
            );
        }
    }
}
