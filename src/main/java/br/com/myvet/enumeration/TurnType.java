package br.com.myvet.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TurnType {

    MORNING("MANHÃ"),
    AFTERNOON("TARDE"),
    NIGHT("NOITE");

    private final String label;

}
