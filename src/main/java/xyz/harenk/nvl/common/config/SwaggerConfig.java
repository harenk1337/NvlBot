package xyz.harenk.nvl.common.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author harenk.xyz @harenk1337
 * @description
 * @create 2024-05-29 17:50
 */
@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi botApi() {
        return GroupedOpenApi.builder().group("v1").pathsToMatch("/**").build();
    }

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info().title("NvlBot API")
                        .description("NvlBot API")
                        .version("1.0.0"))
                .externalDocs(new ExternalDocumentation()
                        .description("Github源码地址")
                        .url("https://github.com/harenk1337?tab=repositories"));
    }


}
