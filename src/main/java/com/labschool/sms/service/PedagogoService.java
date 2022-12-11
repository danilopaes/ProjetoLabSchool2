package com.labschool.sms.service;

import com.labschool.sms.model.Pedagogo;
import com.labschool.sms.repository.PedagogoRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PedagogoService {

  private final PedagogoRepository repository;

  public PedagogoService(PedagogoRepository repository) {
    this.repository = repository;
  }

  public List<Pedagogo> buscarTodos() {
    return repository.findAll();
  }
  
}
