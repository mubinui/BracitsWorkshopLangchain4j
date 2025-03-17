package com.bracits.langchain4j;

import dev.langchain4j.data.embedding.Embedding;
import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.model.embedding.onnx.allminilml6v2.AllMiniLmL6V2EmbeddingModel;
import org.springframework.stereotype.Service;

@Service
public class SentenceSimilarityService {

    private final EmbeddingModel embeddingModel;

    public SentenceSimilarityService() {
        this.embeddingModel = new AllMiniLmL6V2EmbeddingModel();
    }

    /**
     * Calculate the similarity score between two sentences.
     */
    public double calculateSimilarity(String sentence1, String sentence2) {
        Embedding embedding1 = embeddingModel.embed(sentence1).content();
        Embedding embedding2 = embeddingModel.embed(sentence2).content();
        return cosineSimilarity(embedding1, embedding2);
    }

    /**
     * Calculate the cosine similarity between two embeddings.
     */
    private double cosineSimilarity(Embedding embedding1, Embedding embedding2) {
        float[] vector1 = embedding1.vector();
        float[] vector2 = embedding2.vector();

        double dotProduct = 0.0;
        double normA = 0.0;
        double normB = 0.0;

        for (int i = 0; i < vector1.length; i++) {
            dotProduct += vector1[i] * vector2[i];
            normA += Math.pow(vector1[i], 2);
            normB += Math.pow(vector2[i], 2);
        }

        normA = Math.sqrt(normA);
        normB = Math.sqrt(normB);

        return (normA == 0 || normB == 0) ? 0 : dotProduct / (normA * normB);
    }
}
