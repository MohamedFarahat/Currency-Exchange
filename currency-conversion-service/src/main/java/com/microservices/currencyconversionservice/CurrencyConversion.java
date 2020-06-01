package com.microservices.currencyconversionservice;

import java.math.BigDecimal;

public class CurrencyConversion {
    private Long id;
    private String to;
    private String from;
    private BigDecimal convertion_multible;
    private BigDecimal quantity;
    private BigDecimal total;
    private int port;

    CurrencyConversion(){}
    public CurrencyConversion(Long id, String from,String to, BigDecimal conversion_multiple, BigDecimal quantity, BigDecimal total, int port) {
        this.to = to;
        this.id = id;
        this.from = from;
        this.convertion_multible = conversion_multiple;
        this.quantity = quantity;
        this.total = total;
        this.port = port;
    }

    public String getTo() {
        return to;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public BigDecimal getConvertion_multible() {
        return convertion_multible;
    }

    public void setConvertion_multible(BigDecimal convertion_multible) {
        this.convertion_multible = convertion_multible;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
