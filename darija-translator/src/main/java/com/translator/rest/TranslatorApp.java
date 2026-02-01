package com.translator.rest;

import org.glassfish.jersey.server.ResourceConfig;


public class TranslatorApp extends ResourceConfig {
    public TranslatorApp() {
        
        packages("com.translator.rest");
        register(com.translator.security.CorsFilter.class);
    }
}