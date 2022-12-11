package com.labschool.sms.repository;

import com.labschool.sms.model.Professor;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface ProfessorRepository extends CrudRepository<Professor, Long> {

  List<Professor> findAll();

}
