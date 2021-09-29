package it.euris.exam.teslabattery_bd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import it.euris.exam.teslabattery_bd.data.model.Robot;

/**
 * @author Busterna Davide
 * @since 2021-09-29
 */

public interface RobotRepository extends JpaRepository<Robot, Long> {

}
