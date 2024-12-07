package com.medvoll.apirest.inf.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

    //tratar error 404, errores de parte de request del cliente
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity tratarError404(){
    return ResponseEntity.notFound().build();
    }

    //tratar error 400, de validaciones de datos
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity tratarErrorValidacion(MethodArgumentNotValidException e){
            var errores = e.getFieldErrors().stream().map(DatosErrorValidacion::new).toList();
            return ResponseEntity.badRequest().body(errores);
    }

    private record DatosErrorValidacion(String campo, String error){
        public DatosErrorValidacion(FieldError error){
            this(error.getField(), error.getDefaultMessage());
        }
    }

}
