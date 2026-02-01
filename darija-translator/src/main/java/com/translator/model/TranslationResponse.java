package com.translator.model; 

public class TranslationResponse { 
    private String translatedText;

    public TranslationResponse() {} 

    public TranslationResponse(String translatedText) {
        this.translatedText = translatedText;
    }

    public String getTranslatedText() {
        return translatedText;
    }

    public void setTranslatedText(String text) {
        this.translatedText = text;
    }
}