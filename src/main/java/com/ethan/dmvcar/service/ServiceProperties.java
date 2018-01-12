package com.ethan.dmvcar.service;


import javax.validation.constraints.NotNull;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/*
 * demonstrates how service-specific properties can be injected
 */
@ConfigurationProperties(prefix = "car.service", ignoreUnknownFields = false)
@Component
public class ServiceProperties {

    @NotNull // you can also create configurationPropertiesValidator
    private String name = "Empty";

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
