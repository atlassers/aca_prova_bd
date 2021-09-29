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
import it.euris.exam.teslabattery_bd.data.dto.FormulaComponentDto;
import it.euris.exam.teslabattery_bd.data.model.FormulaComponent;
import it.euris.exam.teslabattery_bd.data.model.key.FormulaComponentKey;
import it.euris.exam.teslabattery_bd.repository.FormulaComponentRepository;
import it.euris.exam.teslabattery_bd.service.FormulaComponentService;
import it.euris.exam.teslabattery_bd.utils.TestSupport;

/**
 * @author Busterna Davide
 * @since 2021-09-29
 */

@SpringBootTest
public class FormulaComponentControllerTest {
  
  @Autowired
  FormulaComponentService formulaComponentService;
  
  @MockBean
  FormulaComponentRepository formulaComponentRepository;

  @Test
  void getAll() {
    List<FormulaComponent> mockedFormulaComponents = TestSupport.createFormulaComponentList();
    when(formulaComponentRepository.findAll()).thenReturn(mockedFormulaComponents);
    
    List<FormulaComponentDto> formulaComponents = formulaComponentService.getAll();
    
    assertEquals(mockedFormulaComponents.size(), formulaComponents.size());
    for(int i = 0; i < mockedFormulaComponents.size(); i++)
      assertEquals(mockedFormulaComponents.get(i).toDto(), formulaComponents.get(i));
  }
  
  @Test
  void get() {
    final Long FORMULA_ID = 1L;
    final Long COMPONENT_ID = 2L;
    final FormulaComponentKey ID = new FormulaComponentKey(FORMULA_ID, COMPONENT_ID);
    FormulaComponent mockedFormulaComponent = TestSupport.createFormulaComponent(ID);
    when(formulaComponentRepository.findById(ID)).thenReturn(Optional.of(mockedFormulaComponent));
  
    FormulaComponentDto formulaComponent = formulaComponentService.get(FORMULA_ID, COMPONENT_ID);
    
    assertEquals(mockedFormulaComponent.toDto(), formulaComponent);
  }

  @Test
  void add() {
    FormulaComponentKey idToSave = new FormulaComponentKey(1L, 1L);
    FormulaComponent formulaComponentToAdd = TestSupport.createFormulaComponent(idToSave); // You can't create a FormulaComponent with a Null id
    FormulaComponentKey idToReturn = new FormulaComponentKey(2L, 2L);    
    FormulaComponent formulaComponentToReturn = TestSupport.createFormulaComponent(idToReturn);
    when(formulaComponentRepository.save(any())).thenReturn(formulaComponentToReturn);
    
    FormulaComponentDto formulaComponent = formulaComponentService.add(formulaComponentToAdd.toDto());
    
    assertEquals(formulaComponentToReturn.toDto(), formulaComponent);
  }

  @Test
  void update() {
    FormulaComponentKey idToUpdate = new FormulaComponentKey(1L, 1L);
    FormulaComponent formulaComponentToUpdate = TestSupport.createFormulaComponent(idToUpdate);
    FormulaComponentKey idToReturn = new FormulaComponentKey(1L, 1L);
    FormulaComponent formulaComponentToReturn = TestSupport.createFormulaComponent(idToReturn);
    when(formulaComponentRepository.save(any())).thenReturn(formulaComponentToReturn);
    
    FormulaComponentDto formulaComponent = formulaComponentService.update(formulaComponentToUpdate.toDto());
    
    assertEquals(formulaComponentToReturn.toDto(), formulaComponent); 
  }

  @Test
  void delete() {
    final Long FORMULA_ID = 1L;
    final Long COMPONENT_ID = 2L;
    final FormulaComponentKey ID = new FormulaComponentKey(FORMULA_ID, COMPONENT_ID);
    doNothing().when(formulaComponentRepository).deleteById(ID);
    when(formulaComponentRepository.findById(ID)).thenReturn(Optional.empty());
    
    Boolean deleted = formulaComponentService.delete(FORMULA_ID, COMPONENT_ID);
    
    assertTrue(deleted);
  }
}
