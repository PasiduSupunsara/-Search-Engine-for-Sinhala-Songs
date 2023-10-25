package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(indexName = "songs")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Song {
    private int id;
    private int year;
    private String songNameInSinahala;
    private String lyrics;
    private String lyricists;
    private List<Metaphor> metaphors;

    public static class Metaphor {
        private String metaphor;
        private String meaning;

        public String getMetaphor() {
            return metaphor;
        }

        public void setMetaphor(String metaphor) {
            this.metaphor = metaphor;
        }

        public String getMeaning() {
            return meaning;
        }

        public void setMeaning(String meaning) {
            this.meaning = meaning;
        }
    }
}
