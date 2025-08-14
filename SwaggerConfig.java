package com.TrainTicketBooking.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI trainTicketBookingOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Train Ticket Booking API")
                        .description("Swagger documentation for Train Ticket Booking application")
                        .version("1.0"));
    }
}
