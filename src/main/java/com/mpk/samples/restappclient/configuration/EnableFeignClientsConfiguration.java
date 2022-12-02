package com.mpk.samples.restappclient.configuration;

import com.mpk.samples.restappclient.feign.StubRunnerClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@EnableFeignClients(basePackageClasses = { StubRunnerClient.class })
@Configuration
public class EnableFeignClientsConfiguration {

}