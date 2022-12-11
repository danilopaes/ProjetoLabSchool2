package com.labschool.sms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Não existe nenhum pedagogo cadastrado!", value = HttpStatus.NOT_FOUND)
public class NenhumPedagogoException extends RuntimeException {

}
