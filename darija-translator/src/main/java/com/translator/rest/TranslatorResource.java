package com.translator.rest;


import com.translator.model.TranslationRequest;
import com.translator.model.TranslationResponse;
// Daba ghadi n-importiw GeminiService (li semmitiha jdida)
import com.translator.service.GeminiService;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/translate")
public class TranslatorResource {

    
    private GeminiService geminiService = new GeminiService();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response translate(TranslationRequest request) {
        try {
            // Vérification
            if (request == null || request.getText() == null || request.getText().isEmpty()) {
                return Response.status(Response.Status.BAD_REQUEST)
                        .entity(new TranslationResponse("Error: Text is empty"))
                        .build();
            }

            // Appel Service
            String translatedText = geminiService.translate(request.getText());
            
            // Response
            return Response.ok(new TranslationResponse(translatedText)).build();

        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError()
                    .entity(new TranslationResponse("Error: " + e.getMessage()))
                    .build();
        }
    }
}