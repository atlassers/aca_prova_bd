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
import it.euris.exam.teslabattery_bd.data.dto.AssemblyLineDto;
import it.euris.exam.teslabattery_bd.data.model.AssemblyLine;
import it.euris.exam.teslabattery_bd.repository.AssemblyLineRepository;
import it.euris.exam.teslabattery_bd.service.AssemblyLineService;
import it.euris.exam.teslabattery_bd.utils.TestSupport;

/**
 * @author Busterna Davide
 * @since 2021-09-29
 */

@SpringBootTest
public class AssemblyLineControllerTest {
  
  @Autowired
  AssemblyLineService assemblyLineService;
  
  @MockBean
  AssemblyLineRepository assemblyLineRepository;

  @Test
  void getAll() {
    List<AssemblyLine> mockedAssemblyLines = TestSupport.createAssemblyLineList();
    when(assemblyLineRepository.findAll()).thenReturn(mockedAssemblyLines);
    
    List<AssemblyLineDto> assemblyLines = assemblyLineService.getAll();
    
    assertEquals(mockedAssemblyLines.size(), assemblyLines.size());
    for(int i = 0; i < mockedAssemblyLines.size(); i++)
      assertEquals(mockedAssemblyLines.get(i).toDto(), assemblyLines.get(i));
  }
  
  @Test
  void get() {
    final Long ID = 1L;
    AssemblyLine mockedAssemblyLine = TestSupport.createAssemblyLine(ID);
    when(assemblyLineRepository.findById(ID)).thenReturn(Optional.of(mockedAssemblyLine));
  
    AssemblyLineDto assemblyLine = assemblyLineService.get(ID);
    
    assertEquals(mockedAssemblyLine.toDto(), assemblyLine);
  }

  @Test
  void add() {
    AssemblyLine assemblyLineToAdd = TestSupport.createAssemblyLine(null);
    AssemblyLine assemblyLineToReturn = TestSupport.createAssemblyLine(11L);
    when(assemblyLineRepository.save(any())).thenReturn(assemblyLineToReturn);
    
    AssemblyLineDto assemblyLine = assemblyLineService.add(assemblyLineToAdd.toDto());
    
    assertEquals(assemblyLineToReturn.toDto(), assemblyLine);
  }

  @Test
  void update() {
    AssemblyLine assemblyLineToUpdate = TestSupport.createAssemblyLine(1L);
    AssemblyLine assemblyLineToReturn = TestSupport.createAssemblyLine(11L);
    when(assemblyLineRepository.save(any())).thenReturn(assemblyLineToReturn);
    
    AssemblyLineDto assemblyLine = assemblyLineService.update(assemblyLineToUpdate.toDto());
    
    assertEquals(assemblyLineToReturn.toDto(), assemblyLine); 
  }

  @Test
  void delete() {
    final Long ID = 1L;
    doNothing().when(assemblyLineRepository).deleteById(ID);
    when(assemblyLineRepository.findById(ID)).thenReturn(Optional.empty());
    
    Boolean deleted = assemblyLineService.delete(ID);
    
    assertTrue(deleted);
  }
}
