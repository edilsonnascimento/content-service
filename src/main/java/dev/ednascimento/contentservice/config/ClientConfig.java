package dev.ednascimento.contentservice.config;

import dev.ednascimento.contentservice.service.ArticleClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

public class ClientConfig {

    @Bean
    ArticleClient articleClient() {
        WebClient client = WebClient.builder()
                .baseUrl("http://localhost:8081/api")
                .build();
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builder(WebClientAdapter.forClient(client)).build();
        return factory.createClient(ArticleClient.class);
    }
}