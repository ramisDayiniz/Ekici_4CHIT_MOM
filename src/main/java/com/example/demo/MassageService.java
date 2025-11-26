package com.example.demo;

import model.WarehouseData;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

@Service
public class MassageService {

    // Thread-safe Map für alle Lagerstandorte
    private final Map<String, WarehouseData> allWarehouses = new ConcurrentHashMap<>();

    public void addOrUpdateWarehouse(WarehouseData warehouseData) {
        allWarehouses.put(warehouseData.getWarehouseID(), warehouseData);
    }

    public Map<String, WarehouseData> getAllWarehouses() {
        return allWarehouses;
    }
}
