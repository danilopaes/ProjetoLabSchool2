package com.labschool.sms.service;

import com.labschool.sms.exception.AlunoNaoEncontradoException;
import com.labschool.sms.exception.PedagogoNaoEncontradoException;
import com.labschool.sms.model.dto.AtendimentoDtoSaida;
import com.labschool.sms.model.enums.SituacaoMatricula;
import com.labschool.sms.repository.AlunoRepository;
import com.labschool.sms.repository.PedagogoRepository;
import org.springframework.stereotype.Service;

@Service
public class AtendimentoService {

  private final AlunoRepository alunoRepository;
  private final PedagogoRepository pedagogoRepository;

  public AtendimentoService(AlunoRepository alunoRepository,
      PedagogoRepository pedagogoRepository) {
    this.alunoRepository = alunoRepository;
    this.pedagogoRepository = pedagogoRepository;
  }

  public AtendimentoDtoSaida realizaAtendimento(Long codigoAluno, Long codigoPedagogo) {
    var aluno = alunoRepository.findById(codigoAluno).orElseThrow(AlunoNaoEncontradoException::new);
    var pedagogo = pedagogoRepository.findById(codigoPedagogo)
        .orElseThrow(PedagogoNaoEncontradoException::new);

    aluno.setSituacaoDaMatricula(SituacaoMatricula.ATENDIMENTO_PEDAGOGICO.toString());
    aluno.setTotalAtendimentosPedagogicos(aluno.getTotalAtendimentosPedagogicos() + 1);
    pedagogo.setQntAtendimentos(pedagogo.getQntAtendimentos() + 1);

    var alunoAtualizado = alunoRepository.save(aluno);
    var pedagogoAtualizado = pedagogoRepository.save(pedagogo);

    var dtoSaida = new AtendimentoDtoSaida();
    dtoSaida.setAluno(alunoAtualizado);
    dtoSaida.setPedagogo(pedagogoAtualizado);

    return dtoSaida;
  }
}
