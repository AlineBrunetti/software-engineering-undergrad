package com.auditor.dlqservice.dto;

import java.util.List;

public class OrderMessageDto {
    public String zipCode;
    public Long customerId;
    public List<OrderItem> orderItems;
    public String origin;
    public String occurredAt;

    public static class OrderItem {
        public Long sku;
        public Integer amount;
    }
}