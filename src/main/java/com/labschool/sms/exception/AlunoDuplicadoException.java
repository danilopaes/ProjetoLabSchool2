package com.labschool.sms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "Já existe um aluno com este CPF!", value = HttpStatus.CONFLICT)
public class AlunoDuplicadoException extends RuntimeException {

}
