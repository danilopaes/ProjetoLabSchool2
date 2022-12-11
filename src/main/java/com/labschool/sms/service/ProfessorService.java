package com.labschool.sms.service;

import com.labschool.sms.model.Professor;
import com.labschool.sms.repository.ProfessorRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ProfessorService {

  private final ProfessorRepository repository;

  public ProfessorService(ProfessorRepository repository) {
    this.repository = repository;
  }

  public List<Professor> buscarTodos() {
    return repository.findAll();
  }
  
}
