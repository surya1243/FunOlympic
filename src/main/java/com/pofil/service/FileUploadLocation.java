package com.pofil.service;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan ({"com.pofil.service"})
@ConfigurationProperties("storage")
public class FileUploadLocation {
	
	private String UPLOAD_LOCATION = "sports-dir";

    public String getLocation() {
        return UPLOAD_LOCATION;
    }
    
    public void setLocation(String location) {
        this.UPLOAD_LOCATION = location;
    }
}
