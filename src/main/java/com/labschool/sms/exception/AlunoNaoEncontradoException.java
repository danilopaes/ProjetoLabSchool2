package com.labschool.sms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Não existe nenhum aluno com este código!", value = HttpStatus.NOT_FOUND)
public class AlunoNaoEncontradoException extends RuntimeException {

}
