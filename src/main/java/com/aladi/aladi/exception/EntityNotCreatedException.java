package com.aladi.aladi.exception;

public class EntityNotCreatedException extends RuntimeException {
    public EntityNotCreatedException(Class<?> entity) {
        super(entity.getSimpleName() + " no se puede crear. Por favor, intente de nuevo más tarde.");
    }

}
