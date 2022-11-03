package ru.midni.api.config;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;
import reactor.netty.tcp.TcpClient;

import java.util.concurrent.TimeUnit;

@Configuration
public class WebClientConfig {

  @Value("${http.request-timeout}")
  private Integer requestTimeout;

  @Bean
  public WebClient initWebClient() {
    final TcpClient tcpClient = TcpClient.create()
        .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, requestTimeout)
        .doOnConnected(connection -> {
          connection.addHandlerLast(new ReadTimeoutHandler(requestTimeout, TimeUnit.MILLISECONDS));
          connection.addHandlerLast(new WriteTimeoutHandler(requestTimeout, TimeUnit.MILLISECONDS));
        });

    return WebClient.builder()
        .clientConnector(new ReactorClientHttpConnector(HttpClient.from(tcpClient)))
        .build();
  }
}
