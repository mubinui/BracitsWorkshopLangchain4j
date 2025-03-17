package com.bracits.langchain4j;

public class SimilarityRequest {

  private String sentence1;
  private String sentence2;

  // Getters and setters
  public String getSentence1() {
    return sentence1;
  }

  public void setSentence1(String sentence1) {
    this.sentence1 = sentence1;
  }

  public String getSentence2() {
    return sentence2;
  }

  public void setSentence2(String sentence2) {
    this.sentence2 = sentence2;
  }
}