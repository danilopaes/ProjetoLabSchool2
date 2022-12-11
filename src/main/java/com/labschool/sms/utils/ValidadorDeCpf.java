package com.labschool.sms.utils;

public class ValidadorDeCpf {

  public static boolean isCpfValido(String cpf) {
    if (cpf.equals("00000000000") ||
        cpf.equals("11111111111") ||
        cpf.equals("22222222222") ||
        cpf.equals("33333333333") ||
        cpf.equals("44444444444") ||
        cpf.equals("55555555555") ||
        cpf.equals("66666666666") ||
        cpf.equals("77777777777") ||
        cpf.equals("88888888888") ||
        cpf.equals("99999999999") ||
        (cpf.length() != 11)) {
      return (false);
    }

    char decimoDigito, decimoPrimeiroDigito;
    int soma, caracterAtual, restoDaDivisao, numero, peso;

    try {
      soma = 0;
      peso = 10;

      for (caracterAtual = 0; caracterAtual < 9; caracterAtual++) {
        numero = cpf.charAt(caracterAtual) - 48;
        soma = soma + (numero * peso);
        peso = peso - 1;
      }

      restoDaDivisao = 11 - (soma % 11);

      if ((restoDaDivisao == 10) || (restoDaDivisao == 11)) {
        decimoDigito = '0';
      } else {
        decimoDigito = (char) (restoDaDivisao + 48);
      }

      soma = 0;
      peso = 11;

      for (caracterAtual = 0; caracterAtual < 10; caracterAtual++) {
        numero = cpf.charAt(caracterAtual) - 48;
        soma = soma + (numero * peso);
        peso = peso - 1;
      }

      restoDaDivisao = 11 - (soma % 11);

      if ((restoDaDivisao == 10) || (restoDaDivisao == 11)) {
        decimoPrimeiroDigito = '0';
      } else {
        decimoPrimeiroDigito = (char) (restoDaDivisao + 48);
      }

      return (decimoDigito == cpf.charAt(9)) && (decimoPrimeiroDigito == cpf.charAt(10));
    } catch (Exception erro) {
      return (false);
    }
  }

  public static boolean isCpfInvalido(String cpf) {
    return !isCpfValido(cpf);
  }

}
