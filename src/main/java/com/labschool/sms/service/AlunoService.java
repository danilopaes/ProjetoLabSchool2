package com.labschool.sms.service;

import com.labschool.sms.exception.AlunoDuplicadoException;
import com.labschool.sms.exception.AlunoNaoEncontradoException;
import com.labschool.sms.exception.SituacaoInvalidaException;
import com.labschool.sms.model.Aluno;
import com.labschool.sms.model.enums.SituacaoMatricula;
import com.labschool.sms.repository.AlunoRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {

  private final AlunoRepository repository;

  public AlunoService(AlunoRepository repository) {
    this.repository = repository;
  }

  public Aluno criarNovoAluno(Aluno aluno) {
    if (repository.findByCpf(aluno.getCpf()) != null) {
      throw new AlunoDuplicadoException();
    }

    aluno.validar();

    return repository.save(aluno);
  }
  
  public Aluno atualizarSituacaoCadastral(Long codigoDoAluno, String novaSituacao) {
    if (novaSituacao.isBlank() || novaSituacao.isEmpty() || situacaoInvalida(novaSituacao)) {
      throw new SituacaoInvalidaException();
    }

    var aluno = repository.findById(codigoDoAluno).orElseThrow(AlunoNaoEncontradoException::new);

    aluno.setSituacaoDaMatricula(novaSituacao);
    return repository.save(aluno);
  }

  private boolean situacaoInvalida(String situacao) {
    for (SituacaoMatricula situacaoValida : SituacaoMatricula.values()) {
      if (situacao.equals(situacaoValida.name())) {
        return false;
      }
    }
    return true;
  }

  public List<Aluno> buscarTodos() {
    return repository.findAll();
  }

  public Aluno buscarPeloCodigo(Long codigoDoAluno) {
    return repository.findById(codigoDoAluno).orElseThrow(AlunoNaoEncontradoException::new);
  }

  public void excluirAluno(Long codigoDoAluno) {
    var aluno = repository.findById(codigoDoAluno).orElseThrow(AlunoNaoEncontradoException::new);
    repository.delete(aluno);
  }
}
