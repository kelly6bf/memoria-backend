package site.memoria.common.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(apiInfo())
                .components(securitySchemeComponents())
                .addSecurityItem(securityRequirement());
    }

    private Info apiInfo() {
        return new Info()
                .title("Memoria API 문서")
                .description("켈리의 Memoria 프로젝트 API 문서")
                .version("1.0.0");
    }

    private Components securitySchemeComponents() {
        final SecurityScheme bearerAuth = new SecurityScheme()
                .type(SecurityScheme.Type.HTTP)
                .scheme("bearer")
                .bearerFormat(HttpHeaders.AUTHORIZATION)
                .in(SecurityScheme.In.HEADER)
                .name(HttpHeaders.AUTHORIZATION);

        return new Components().addSecuritySchemes(HttpHeaders.AUTHORIZATION, bearerAuth);
    }

    private SecurityRequirement securityRequirement() {
        return new SecurityRequirement().addList(HttpHeaders.AUTHORIZATION);
    }
}
