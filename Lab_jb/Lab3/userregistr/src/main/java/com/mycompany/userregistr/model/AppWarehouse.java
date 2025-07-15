package com.mycompany.userregistr.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class AppWare implements Serializable{
    private static final long serialVersionUID = -8216534840561913340L;
    private Long id;
    private String productName;
    private String manufacturer;
    private BigDecimal pricePerUnit;
    private int quantity;
    private String warehouseNumber;
    private int minimumBatch;

    public AppWare() {}

    public AppWare(Long id, String productName, String manufacturer, BigDecimal pricePerUnit, int quantity, String warehouseNumber, int minimumBatch) {
        this.id = id;
        this.productName = productName;
        this.manufacturer = manufacturer;
        this.pricePerUnit = pricePerUnit;
        this.quantity = quantity;
        this.warehouseNumber = warehouseNumber;
        this.minimumBatch = minimumBatch;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public BigDecimal getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(BigDecimal pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getWarehouseNumber() {
        return warehouseNumber;
    }

    public void setWarehouseNumber(String warehouseNumber) {
        this.warehouseNumber = warehouseNumber;
    }

    public int getMinimumBatch() {
        return minimumBatch;
    }

    public void setMinimumBatch(int minimumBatch) {
        this.minimumBatch = minimumBatch;
    }
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
    @Override
    public String toString() {
        return "Ware{" +
                "wareId=" + id +
                ", productName='" + productName + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", pricePerUnit=" + pricePerUnit +
                ", quantity=" + quantity +
                ", warehouseNumber=" + warehouseNumber +
                ", minimumBatch=" + minimumBatch +
                '}';
    }
}
