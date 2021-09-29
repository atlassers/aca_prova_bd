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
import it.euris.exam.teslabattery_bd.data.dto.ProductionCycleDto;
import it.euris.exam.teslabattery_bd.data.model.ProductionCycle;
import it.euris.exam.teslabattery_bd.repository.ProductionCycleRepository;
import it.euris.exam.teslabattery_bd.service.ProductionCycleService;
import it.euris.exam.teslabattery_bd.utils.TestSupport;

/**
 * @author Busterna Davide
 * @since 2021-09-29
 */

@SpringBootTest
public class ProductionCycleControllerTest {
  
  @Autowired
  ProductionCycleService productionCycleService;
  
  @MockBean
  ProductionCycleRepository productionCycleRepository;

  @Test
  void getAll() {
    List<ProductionCycle> mockedProductionCycles = TestSupport.createProductionCycleList();
    when(productionCycleRepository.findAll()).thenReturn(mockedProductionCycles);
    
    List<ProductionCycleDto> productionCycles = productionCycleService.getAll();
    
    assertEquals(mockedProductionCycles.size(), productionCycles.size());
    for(int i = 0; i < mockedProductionCycles.size(); i++)
      assertEquals(mockedProductionCycles.get(i).toDto(), productionCycles.get(i));
  }
  
  @Test
  void get() {
    final Long ID = 1L;
    ProductionCycle mockedProductionCycle = TestSupport.createProductionCycle(ID);
    when(productionCycleRepository.findById(ID)).thenReturn(Optional.of(mockedProductionCycle));
  
    ProductionCycleDto productionCycle = productionCycleService.get(ID);
    
    assertEquals(mockedProductionCycle.toDto(), productionCycle);
  }

  @Test
  void add() {
    ProductionCycle productionCycleToAdd = TestSupport.createProductionCycle(null);
    ProductionCycle productionCycleToReturn = TestSupport.createProductionCycle(11L);
    when(productionCycleRepository.save(any())).thenReturn(productionCycleToReturn);
    
    ProductionCycleDto productionCycle = productionCycleService.add(productionCycleToAdd.toDto());
    
    assertEquals(productionCycleToReturn.toDto(), productionCycle);
  }

  @Test
  void update() {
    ProductionCycle productionCycleToUpdate = TestSupport.createProductionCycle(1L);
    ProductionCycle productionCycleToReturn = TestSupport.createProductionCycle(11L);
    when(productionCycleRepository.save(any())).thenReturn(productionCycleToReturn);
    
    ProductionCycleDto productionCycle = productionCycleService.update(productionCycleToUpdate.toDto());
    
    assertEquals(productionCycleToReturn.toDto(), productionCycle); 
  }

  @Test
  void delete() {
    final Long ID = 1L;
    doNothing().when(productionCycleRepository).deleteById(ID);
    when(productionCycleRepository.findById(ID)).thenReturn(Optional.empty());
    
    Boolean deleted = productionCycleService.delete(ID);
    
    assertTrue(deleted);
  }
}
