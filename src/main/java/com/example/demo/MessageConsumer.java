package com.example.demo;

import model.ProductData;
import model.WarehouseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.kafka.annotation.KafkaListener;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class MessageConsumer {

    @Autowired
    private MassageService massageService;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    /*
    String[] topics The topics for this listener. The entries can be
    'topic name', 'property-placeholder keys' or 'expressions'. An expression
    must be resolved to the topic name. This uses group management and Kafka will
    assign partitions to group members.

    Es hat doch nur nachteile für mich?
     */
    @KafkaListener(topics = "warehouse-wien")
    public void processMessage(WarehouseData warehouseData) {
        massageService.addOrUpdateWarehouse(warehouseData);
        String feedbackTopic = "warehouse-reserve"; // Topic für Rückmeldung
        String ausgabe = "SUCCESS: " + warehouseData.getWarehouseID() + ", " + warehouseData.getWarehouseName();

        kafkaTemplate.send(feedbackTopic, warehouseData.getWarehouseID(), "SUCCESS: " + warehouseData.getWarehouseID() + ", " + warehouseData.getWarehouseName());


        try (FileWriter fw = new FileWriter("warehouse_output.txt", true);
             PrintWriter pw = new PrintWriter(fw)) {
            pw.println(ausgabe);
            pw.println("Read from Message Queue: " + warehouseData.getWarehouseName());
            for (ProductData p : warehouseData.getProducts()) {
                pw.println("Product: " + p.getProductName() + " - Quantity: " + p.getProductQuantity());
            }
            pw.println("-------------------------------------------------");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

