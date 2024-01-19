package fr.CornelisJ.exam.exception;

import lombok.Getter;

@Getter
public class NotFoundInstantFrancingException extends RuntimeException {

    private final String type;

    private final String field;

    private final Object value;

    public NotFoundInstantFrancingException(String type, String field, Object value) {
        super("Entity not found");
        this.type = type;
        this.field = field;
        this.value = value;
    }
}
