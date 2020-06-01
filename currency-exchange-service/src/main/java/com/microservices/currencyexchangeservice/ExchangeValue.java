package com.microservices.currencyexchangeservice;



import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class ExchangeValue {


    @Id
    private Long id;

    @Column(name="currency_from")
    private String from;

    @Column(name="currency_to")
    private String to;

    private BigDecimal convertion_multible;
    private int port;

    public ExchangeValue(){}
    public ExchangeValue(Long id, String from, String to, BigDecimal convertion_multible,int port) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.convertion_multible = convertion_multible;
        this.port=0;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public BigDecimal getconvertion_multible() {
        return convertion_multible;
    }

    public void setconvertion_multible(BigDecimal convertion_multible) {
        this.convertion_multible = convertion_multible;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
