package com.bracits.langchain4j;

import dev.langchain4j.model.ollama.OllamaChatModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class OllamaAIService {

  private final OllamaChatModel chatModel;

  @Value("${system.command.ollama}")
  private String systemCommand;

  public OllamaAIService(@Value("${ollama.api.url}") String apiUrl,
                         @Value("${ollama.model.name}") String modelName,
                         @Value("${ollama.temperature}") double temperature) {
    this.chatModel = OllamaChatModel.builder()
        .baseUrl(apiUrl)
        .modelName(modelName)
        .temperature(temperature)
        .build();
  }

  /**
   * Generate a response from the Ollama AI model using LangChain4j.
   */
  public String generateResponse(String prompt) {
    try {
      String finalPrompt = systemCommand + " " + prompt;
      return chatModel.chat(finalPrompt);
    } catch (Exception e) {
      return "Error: " + e.getMessage();
    }
  }
}