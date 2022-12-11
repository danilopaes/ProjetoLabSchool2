package com.labschool.sms.repository;

import com.labschool.sms.model.Aluno;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface AlunoRepository extends CrudRepository<Aluno, Long> {

  Aluno findByCpf(Long cpf);

  List<Aluno> findAll();

}
