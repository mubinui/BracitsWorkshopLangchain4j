### Test Gemini Assistant
``` bash 
curl -X POST http://localhost:9090/api/assistant/gemini \
-H "Content-Type: application/json" \
-d '{"prompt": "write me a poem about the moon"}'
```

### Test Ollama Assistant
``` bash
curl -X POST http://localhost:9090/api/assistant/ollama \
     -H "Content-Type: application/json" \
     -d '{"prompt": "write me a poem about the sun"}'
```

### Test Similarity of Two Sentences
``` bash
curl -X POST http://localhost:9090/api/assistant/cosine \
     -H "Content-Type: application/json" \
     -d '{"sentence1": "First sentence here", "sentence2": "Second sentence here"}'
```

### Visit this website to download the Ollama software for your operating system
`https://ollama.com/download`

### For Docker installation

### Suggested Installation for the workshop
#### The CPU Only version of ollama
#### Gemma 3, llama 3.2,  1b models
```bash
# Pull the official Ollama Docker image
docker pull ollama/ollama

# Run the Ollama container (CPU only)
docker run -d -v ollama:/root/.ollama -p 11434:11434 --name ollama ollama/ollama

# Run the Ollama container (with NVIDIA GPU support)
docker run -d --gpus=all -v ollama:/root/.ollama -p 11434:11434 --name ollama ollama/ollama

# Verify installation by listing available models
docker exec -it ollama ollama list
```

### Now run the models you want to use
```bash 
 docker exec -it ollama [copy and paste from ollama models list]
 # Gemma 3
 docker exec -it ollama ollama run gemma3:1b
 docker exec -it ollama ollama run gemma3:4b
 # Deep Seek r1
 docker exec -it ollama ollama run deepseek-r1:1.5b
 # llama 3.2
 docker exec -it ollama ollama run llama3.2:1b
```
