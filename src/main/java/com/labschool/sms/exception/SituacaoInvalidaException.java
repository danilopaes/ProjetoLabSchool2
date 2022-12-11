package com.labschool.sms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "A situação cadastral informada é inválida!", value = HttpStatus.BAD_REQUEST)
public class SituacaoInvalidaException extends RuntimeException {

}
