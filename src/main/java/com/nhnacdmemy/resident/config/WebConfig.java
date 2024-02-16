package com.nhnacdmemy.resident.config;

import com.nhnacdmemy.resident.controller.ControllerBase;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses = ControllerBase.class)
public class WebConfig {
}
