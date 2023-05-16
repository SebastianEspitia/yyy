
package com.porvenir;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

//@EnableCaching | Se puede habilitar en caso de que el servicio requiera cache
//@EnableScheduling | Se puede habilitar en caso de que el servicio requiera cache
@EnableFeignClients
@SpringBootApplication
public class AhlMsDetallePeriodoHlJavaApplication {
    public static void main(String[] args) {
        SpringApplication.run(AhlMsDetallePeriodoHlJavaApplication.class, args);
    }
}