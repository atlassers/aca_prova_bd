package it.euris.exam.teslabattery_bd.utils;

import java.util.List;
import org.springframework.boot.test.context.SpringBootTest;
import it.euris.exam.teslabattery_bd.data.model.Component;

/**
 * @author Busterna Davide
 * @since 2021-09-29
 */

@SpringBootTest
public class TestSupport {

  public static Component createComponent(Long id) {
    return Component.builder()
        .id(id)
        .name("Alluminio")
        .dangerous(false)
        .build();
  }

  public static List<Component> createComponentList() {
    return List.of(createComponent(1L), createComponent(2L));
  }
}
