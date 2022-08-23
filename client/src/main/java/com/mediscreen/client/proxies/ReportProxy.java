package com.mediscreen.client.proxies;

import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "report", url = "localhost:8083/reports/assess")
public interface ReportProxy {

    @PostMapping(value = "/id")
    ResponseEntity<String> getDiabetesReport(@RequestBody Long patId);

    class Configuration {

        @Bean
        Encoder feignFormEncoder(ObjectFactory<HttpMessageConverters> converters) {

            return new SpringFormEncoder(new SpringEncoder(converters));
        }
    }
}
