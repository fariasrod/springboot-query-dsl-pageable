package com.dsl.filter;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookFilter {
    private Long id;
    private String name;
    private Boolean free;
    private String author;
    private Integer year;
}
