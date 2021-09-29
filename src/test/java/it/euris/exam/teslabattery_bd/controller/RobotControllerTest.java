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
import it.euris.exam.teslabattery_bd.data.dto.RobotDto;
import it.euris.exam.teslabattery_bd.data.model.Robot;
import it.euris.exam.teslabattery_bd.repository.RobotRepository;
import it.euris.exam.teslabattery_bd.service.RobotService;
import it.euris.exam.teslabattery_bd.utils.TestSupport;

/**
 * @author Busterna Davide
 * @since 2021-09-29
 */

@SpringBootTest
public class RobotControllerTest {
  
  @Autowired
  RobotService robotService;
  
  @MockBean
  RobotRepository robotRepository;

  @Test
  void getAll() {
    List<Robot> mockedRobots = TestSupport.createRobotList();
    when(robotRepository.findAll()).thenReturn(mockedRobots);
    
    List<RobotDto> robots = robotService.getAll();
    
    assertEquals(mockedRobots.size(), robots.size());
    for(int i = 0; i < mockedRobots.size(); i++)
      assertEquals(mockedRobots.get(i).toDto(), robots.get(i));
  }
  
  @Test
  void get() {
    final Long ID = 1L;
    Robot mockedRobot = TestSupport.createRobot(ID);
    when(robotRepository.findById(ID)).thenReturn(Optional.of(mockedRobot));
  
    RobotDto robot = robotService.get(ID);
    
    assertEquals(mockedRobot.toDto(), robot);
  }

  @Test
  void add() {
    Robot robotToAdd = TestSupport.createRobot(null);
    Robot robotToReturn = TestSupport.createRobot(11L);
    when(robotRepository.save(any())).thenReturn(robotToReturn);
    
    RobotDto robot = robotService.add(robotToAdd.toDto());
    
    assertEquals(robotToReturn.toDto(), robot);
  }

  @Test
  void update() {
    Robot robotToUpdate = TestSupport.createRobot(1L);
    Robot robotToReturn = TestSupport.createRobot(11L);
    when(robotRepository.save(any())).thenReturn(robotToReturn);
    
    RobotDto robot = robotService.update(robotToUpdate.toDto());
    
    assertEquals(robotToReturn.toDto(), robot); 
  }

  @Test
  void delete() {
    final Long ID = 1L;
    doNothing().when(robotRepository).deleteById(ID);
    when(robotRepository.findById(ID)).thenReturn(Optional.empty());
    
    Boolean deleted = robotService.delete(ID);
    
    assertTrue(deleted);
  }
}
