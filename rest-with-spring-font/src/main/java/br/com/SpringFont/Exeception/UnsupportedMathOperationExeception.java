package br.com.SpringFont.Exeception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsupportedMathOperationExeception extends RuntimeException {
    public UnsupportedMathOperationExeception(String ex) {
        super(ex);
    }
    private static final long serialVersionUID = 1L;


}
