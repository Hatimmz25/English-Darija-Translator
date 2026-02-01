package com.translator.service;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import okhttp3.*;

public class GeminiService {
    
  
    private static final String API_KEY = "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"; 
    
    
    private static final String URL = "https://api.groq.com/openai/v1/chat/completions";
    
    private final OkHttpClient client = new OkHttpClient();
    private final Gson gson = new Gson();

    public String translate(String text) {
        try {
            System.out.println(">>> 🦁 Requesting Groq (Darija Arabic Script): " + text);

            JsonObject jsonBody = new JsonObject();
           
            jsonBody.addProperty("model", "llama-3.3-70b-versatile"); 
            
            JsonArray messages = new JsonArray();
            
            // 
            JsonObject systemMessage = new JsonObject();
            systemMessage.addProperty("role", "system");
            systemMessage.addProperty("content", 
                "You are a professional Moroccan translator. Translate the text to **Moroccan Darija** using **Arabic Script** only. " +
                "❌ Do NOT use Latin/Chat script (no 'kifach', 'salam'). " +
                "❌ Do NOT use Modern Standard Arabic (Fusha) grammar (no 'Ohibbu', 'Limada', 'Jiddan'). " +
                "✅ USE Arabic Alphabet. " +
                "✅ USE Darija words: 'بزاف', 'ديال', 'شنو', 'دابا', 'واخا', 'كي داير'. " +
                "Examples: " +
                "'How are you?' -> 'كي داير لباس؟' " +
                "'I want to eat' -> 'بغيت ناكل' " +
                "'It is very good' -> 'هادشي زوين بزاف'. " +
                "Keep it natural and short."
            );
            
            JsonObject userMessage = new JsonObject();
            userMessage.addProperty("role", "user");
            userMessage.addProperty("content", text);
            
            messages.add(systemMessage);
            messages.add(userMessage);
            
            jsonBody.add("messages", messages);

            String jsonString = gson.toJson(jsonBody);
            
            RequestBody body = RequestBody.create(jsonString, MediaType.get("application/json"));
            
            Request request = new Request.Builder()
                    .url(URL)
                    .addHeader("Authorization", "Bearer " + API_KEY)
                    .post(body)
                    .build();

            try (Response response = client.newCall(request).execute()) {
                if (!response.isSuccessful()) {
                    String err = response.body().string();
                    System.err.println("!!! Groq Error: " + err);
                    return "Error (" + response.code() + "): " + err; 
                }

                String responseBody = response.body().string();
                JsonObject responseJson = gson.fromJson(responseBody, JsonObject.class);
                
                String result = responseJson.getAsJsonArray("choices")
                        .get(0).getAsJsonObject()
                        .getAsJsonObject("message")
                        .get("content").getAsString();
                
                // 
                System.out.println("<<< 🇲🇦 Natija: " + result);
                return result.trim();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Server Error: " + e.getMessage();
        }
    }
}