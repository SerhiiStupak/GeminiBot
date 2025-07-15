package com.example.GPT;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public record GeminiResponse (
        @JsonProperty("candidates") List<Candidate> candidates
) {
    public record Candidate(
            @JsonProperty("content") Content content
    ) {}

    public record Content(
            @JsonProperty("parts") List<Part> parts
    ) {}

    public record Part(
            @JsonProperty("text") String text
    ) {}
}
