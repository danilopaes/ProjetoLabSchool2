package com.labschool.sms.repository;

import com.labschool.sms.model.Pedagogo;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface PedagogoRepository extends CrudRepository<Pedagogo, Long> {

  List<Pedagogo> findAll();

}
