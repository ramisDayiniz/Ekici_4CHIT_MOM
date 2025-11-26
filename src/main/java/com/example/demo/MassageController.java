package com.example.demo;

import model.WarehouseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class MassageController {

    @Autowired
    private MassageService warehouseService;

    @GetMapping("/all-warehouses")
    public Collection<WarehouseData> getAllWarehouses() {
        return warehouseService.getAllWarehouses().values();
    }

    @GetMapping(value="/all-warehouses.xml", produces= MediaType.APPLICATION_XML_VALUE)
    public Collection<WarehouseData> getAllWarehousesXml() {
        return warehouseService.getAllWarehouses().values();
    }

}
