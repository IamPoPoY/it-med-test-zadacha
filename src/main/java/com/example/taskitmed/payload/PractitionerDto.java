package com.example.taskitmed.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class PractitionerDto {
    private Long id;

    private String fullName;

    private String description;

    private String type;
}
