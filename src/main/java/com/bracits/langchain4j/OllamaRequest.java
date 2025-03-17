package com.bracits.langchain4j;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OllamaRequest {
  @JsonProperty("model")
  private String modelName;

  @JsonProperty("prompt")
  private String prompt;

  @JsonProperty("temperature")
  private double temperature;

  public OllamaRequest(String modelName, String prompt, double temperature) {
    this.modelName = modelName;
    this.prompt = prompt;
    this.temperature = temperature;
  }

  public String getModelName() {
    return modelName;
  }

  public void setModelName(String modelName) {
    this.modelName = modelName;
  }

  public String getPrompt() {
    return prompt;
  }

  public void setPrompt(String prompt) {
    this.prompt = prompt;
  }

  public double getTemperature() {
    return temperature;
  }

  public void setTemperature(double temperature) {
    this.temperature = temperature;
  }
}