package io.sokovets.lllm_test;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.ollama.api.OllamaOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LllmTestApplication {

  //Автоматически подтягивает конфигурацию из application props.
  @Bean
  public ChatClient chatClient(ChatClient.Builder builder) {
    return builder.build();
    //return builder.defaultOptions(OllamaOptions.builder().topK())build();
    //ChatClient - все будется через ChatClient
    //defaultAdvisors - обогощают контекст перед тем как мы идем в ЛЛМ (
  }

  public static void main(String[] args) {
    ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(
        LllmTestApplication.class, args);
    ChatClient chatClient = configurableApplicationContext.getBean(ChatClient.class);
    System.out.println(chatClient.prompt().user("Дай первую строчку богемской рапсодии").call().content());

  }

}
