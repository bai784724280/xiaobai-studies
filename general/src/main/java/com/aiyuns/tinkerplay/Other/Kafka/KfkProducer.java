package com.aiyuns.tinkerplay.Other.Kafka;

import org.apache.kafka.clients.producer.*;

import java.util.Date;
import java.util.Properties;
import java.util.Random;

/**
 * @Author: aiYunS
 * @Date: 2023年6月1日, 0001 下午 6:10:50
 * @Description: kafka生产者
 */

public class KfkProducer {

    public static void main(String[] args) {
        long events = 30;
        Random rnd = new Random();

        Properties props = new Properties();
        props.put("bootstrap.servers", "192.168.1.7:9093");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("message.timeout.ms", "3000");

        Producer<String, String> producer = new KafkaProducer<>(props);

        String topic = "kafeidou";

        for (long nEvents = 0; nEvents < events; nEvents++) {
            long runtime = new Date().getTime();
            String ip = "192.168.2." + rnd.nextInt(255);
            String msg = runtime + ",www.example.com," + ip;
            System.out.println(msg);
            ProducerRecord<String, String> data = new ProducerRecord<String, String>(topic, ip, msg);
            producer.send(data,
                    new Callback() {
                        @Override
                        public void onCompletion(RecordMetadata metadata, Exception e) {
                            if(e != null) {
                                e.printStackTrace();
                            } else {
                                System.out.println("The offset of the record we just sent is: " + metadata.offset());
                            }
                        }
                    });
        }
        System.out.println("send message done");
        producer.close();
        System.exit(-1);
    }
}
