package com.heima.kafka.sample;

import org.apache.kafka.clients.producer.*;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

/**
 * 生产者
 */
public class ProducerQuickStart {

    public static void main(String[] args) {
        //1.kafka链接配置信息
        Properties prop = new Properties();
        //kafka链接地址
        prop.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.200.130:9092");
        //key和value序列化
        prop.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        prop.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");

        //ack配置，消息确认机制
        prop.put(ProducerConfig.ACKS_CONFIG, "all");

        //重试次数   如果未收到ack确定，会重新发送10次，还未收到就表示失败
        prop.put(ProducerConfig.RETRIES_CONFIG, 10);

        //数据压缩     有三种类型，snappy（推荐），lz4，gzip
        prop.put(ProducerConfig.COMPRESSION_TYPE_CONFIG, "snappy");

        //2.创建kafka生产者对象
        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(prop);

        //3.发送消息
        /**
         * 第一个参数：topic
         * 第二个参数：消息的key
         * 第三个参数：消息的value
         */
        ProducerRecord<String, String> kvProducerRecord = new ProducerRecord<String, String>("topic-first",0, "key-001", "hello kafka");
//        producer.send(kvProducerRecord); //之前的发送信息的方式

//        //同步发送信息（消息多了延时就高了，可能产生阻塞）
//        try {
//            RecordMetadata recordMetadata = producer.send(kvProducerRecord).get();
//            System.out.println("偏移量为："+recordMetadata.offset());    //打印便宜量，他是一个连续只增的数值
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }

        //异步消息发送
        producer.send(kvProducerRecord, new Callback() {
            @Override
            public void onCompletion(RecordMetadata recordMetadata, Exception e) { //这里拿到了RecordMetadata消息
                if (e != null){
                    System.out.println("记录异常信息到日志表中");
                }
                System.out.println("偏移量为："+recordMetadata.offset());
            }
        });

        //4.关闭消息通道  必须要关闭，否则消息发送不成功
        producer.close();
    }

}
