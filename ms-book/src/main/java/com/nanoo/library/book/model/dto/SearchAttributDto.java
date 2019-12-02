package com.nanoo.library.book.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author nanoo
 * @create 02/12/2019 - 12:01
 */
@Getter @Setter
@NoArgsConstructor
public class SearchAttributDto {
    
    private String title;
    private String author;
    private boolean available;
    
    public SearchAttributDto(String title, String author, boolean available) {
    }
    
    @Override
    public String toString() {
        return "SearchAttributDto{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", available=" + available +
                '}';
    }
}
