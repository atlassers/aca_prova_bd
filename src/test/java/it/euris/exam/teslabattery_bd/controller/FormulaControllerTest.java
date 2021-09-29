package it.euris.exam.teslabattery_bd.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import it.euris.exam.teslabattery_bd.data.dto.FormulaDto;
import it.euris.exam.teslabattery_bd.data.model.Formula;
import it.euris.exam.teslabattery_bd.repository.FormulaRepository;
import it.euris.exam.teslabattery_bd.service.FormulaService;
import it.euris.exam.teslabattery_bd.utils.TestSupport;

/**
 * @author Busterna Davide
 * @since 2021-09-29
 */

@SpringBootTest
public class FormulaControllerTest {
  
  @Autowired
  FormulaService formulaService;
  
  @MockBean
  FormulaRepository formulaRepository;

  @Test
  void getAll() {
    List<Formula> mockedFormulas = TestSupport.createFormulaList();
    when(formulaRepository.findAll()).thenReturn(mockedFormulas);
    
    List<FormulaDto> formulas = formulaService.getAll();
    
    assertEquals(mockedFormulas.size(), formulas.size());
    for(int i = 0; i < mockedFormulas.size(); i++)
      assertEquals(mockedFormulas.get(i).toDto(), formulas.get(i));
  }
  
  @Test
  void get() {
    final Long ID = 1L;
    Formula mockedFormula = TestSupport.createFormula(ID);
    when(formulaRepository.findById(ID)).thenReturn(Optional.of(mockedFormula));
  
    FormulaDto formula = formulaService.get(ID);
    
    assertEquals(mockedFormula.toDto(), formula);
  }

  @Test
  void add() {
    Formula formulaToAdd = TestSupport.createFormula(null);
    Formula formulaToReturn = TestSupport.createFormula(11L);
    when(formulaRepository.save(any())).thenReturn(formulaToReturn);
    
    FormulaDto formula = formulaService.add(formulaToAdd.toDto());
    
    assertEquals(formulaToReturn.toDto(), formula);
  }

  @Test
  void update() {
    Formula formulaToUpdate = TestSupport.createFormula(1L);
    Formula formulaToReturn = TestSupport.createFormula(11L);
    when(formulaRepository.save(any())).thenReturn(formulaToReturn);
    
    FormulaDto formula = formulaService.update(formulaToUpdate.toDto());
    
    assertEquals(formulaToReturn.toDto(), formula); 
  }

  @Test
  void delete() {
    final Long ID = 1L;
    doNothing().when(formulaRepository).deleteById(ID);
    when(formulaRepository.findById(ID)).thenReturn(Optional.empty());
    
    Boolean deleted = formulaService.delete(ID);
    
    assertTrue(deleted);
  }
}
