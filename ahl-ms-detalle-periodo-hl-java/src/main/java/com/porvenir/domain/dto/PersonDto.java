package com.porvenir.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PersonDto {
    private Integer id;
    private String nombre;
    private String apellido;
    private String edad;
}