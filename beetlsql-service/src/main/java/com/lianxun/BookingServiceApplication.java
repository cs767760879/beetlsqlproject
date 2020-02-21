package com.lianxun;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookingServiceApplication.class, args);
    }

   /* @RestController
    class TestController{
        @GetMapping("/test")
        public String test(){
            return "{\"code\":\"200\",\"message\":\"ok\",\"data\":\"test\"}";
        }
    }*/
}
