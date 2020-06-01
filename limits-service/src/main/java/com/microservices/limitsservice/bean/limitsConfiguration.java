package com.microservices.limitsservice.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
public class limitsConfiguration {

    private int maximum;
    private int minimum;

    public limitsConfiguration(){}
    public limitsConfiguration(int max, int min) {
        this.maximum = max;
        this.minimum = min;
    }

    public int getMaximum() {
        return maximum;
    }

    public void setMaximum(int maximum) {
        this.maximum = maximum;
    }

    public int getMinimum() {
        return minimum;
    }

    public void setMinimum(int minimum) {
        this.minimum = minimum;
    }
}
