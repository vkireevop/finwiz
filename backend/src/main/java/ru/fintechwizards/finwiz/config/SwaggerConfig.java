package ru.fintechwizards.finwiz.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @OpenAPIDefinition(
            info = @Info(
                    title = "Loyalty System Api",
                    description = "Loyalty System", version = "1.0.0",
                    contact = @Contact(
                            name = "Struchkov Mark",
                            email = "mark@struchkov.dev",
                            url = "https://mark.struchkov.dev"
                    )
            )
    )
    public class OpenApiConfig {

    }
}
