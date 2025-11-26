package com.example.demo;

import model.ProductData;
import model.WarehouseData;
import org.springframework.stereotype.Component;
import org.springframework.kafka.annotation.KafkaListener;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class MessageConsumer {

    @KafkaListener(topics = "warehouse-wien")
    public void processMessage(WarehouseData warehouseData) {
        try (FileWriter fw = new FileWriter("warehouse_output.txt", true);
             PrintWriter pw = new PrintWriter(fw)) {
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

