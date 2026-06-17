package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.cadastropedido.dto;

import java.time.LocalDate;
import java.util.List;

public class CadastroPedidoDTO {
    private Integer customerId;
    private String zipCode;
    private List<CadastroPedidoProdutoDTO> orderItems;
    private String origin;
    private LocalDate occurredAt;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public LocalDate getOccurredAt() {
        return occurredAt;
    }

    public void setOccurredAt(LocalDate occurredAt) {
        this.occurredAt = occurredAt;
    }

    public List<CadastroPedidoProdutoDTO> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<CadastroPedidoProdutoDTO> orderItems) {
        this.orderItems = orderItems;
    }
}
