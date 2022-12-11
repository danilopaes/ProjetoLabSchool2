package com.labschool.sms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Há algo errado com os dados submetidos, confira os dados e tente novamente!", value = HttpStatus.BAD_REQUEST)
public class DadosInvalidosException extends RuntimeException {

}
