package com.bracits.langchain4j;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;

@Service
public class GeminiAiService {

  private final ChatLanguageModel geminiModel;
  @Value("${system.command.gemini}")
  private String systemCommand ;

  public GeminiAiService(@Value("${gemini.api.key}") String apiKey,
                         @Value("${gemini.temperature}") double temperature,
                         @Value("${gemini.model.name}") String modelName) {
    this.geminiModel = GoogleAiGeminiChatModel.builder()
        .apiKey(apiKey)
        .temperature(temperature)
        .modelName(modelName)
        .build();
    RestTemplate restTemplate = new RestTemplate();
    restTemplate.getMessageConverters().addFirst(new StringHttpMessageConverter(StandardCharsets.UTF_8));
  }

  /**
   * Generate a response from the Gemini AI model.
   */
  public String generateResponse(String prompt) {
    String finalPrompt = systemCommand + " " + prompt;
    try {
      return geminiModel.chat(finalPrompt);
    } catch (Exception e) {
      return "Error: " + e.getMessage();
    }
  }
}