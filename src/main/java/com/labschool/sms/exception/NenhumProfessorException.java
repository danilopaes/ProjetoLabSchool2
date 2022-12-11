package com.labschool.sms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Não existe nenhum professor cadastrado!", value = HttpStatus.NOT_FOUND)
public class NenhumProfessorException extends RuntimeException {

}
