package com.bracits.langchain4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/assistant")
public class AssistantController {

  private final GeminiAiService geminiAiService;
  private final OllamaAIService ollamaAiService;
  private final SentenceSimilarityService sentenceSimilarityService;

  @Autowired
  public AssistantController(GeminiAiService geminiAiService, OllamaAIService ollamaAiService,
                             SentenceSimilarityService sentenceSimilarityService) {
    this.geminiAiService = geminiAiService;
    this.ollamaAiService = ollamaAiService;
    this.sentenceSimilarityService = sentenceSimilarityService;
  }

  @PostMapping("/gemini")
  public ResponseEntity<String> generateGeminiResponse(@RequestBody String prompt) {
    String response = geminiAiService.generateResponse(prompt);
    return ResponseEntity.ok(response);
  }

  @PostMapping("/ollama")
  public ResponseEntity<String> generateOllamaResponse(@RequestBody String prompt) {
    String response = ollamaAiService.generateResponse(prompt);
    return ResponseEntity.ok(response);
  }

  @PostMapping("/cosine")
  public ResponseEntity<Double> calculateCosineSimilarity(@RequestBody SimilarityRequest request) {
    double similarityScore = sentenceSimilarityService.calculateSimilarity(request.getSentence1(), request.getSentence2());
    return ResponseEntity.ok(similarityScore);
  }
}