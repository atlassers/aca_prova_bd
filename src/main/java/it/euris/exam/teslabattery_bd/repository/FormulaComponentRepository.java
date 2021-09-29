package it.euris.exam.teslabattery_bd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import it.euris.exam.teslabattery_bd.data.model.FormulaComponent;
import it.euris.exam.teslabattery_bd.data.model.key.FormulaComponentKey;

/**
 * @author Busterna Davide
 * @since 2021-09-29
 */

public interface FormulaComponentRepository extends JpaRepository<FormulaComponent, FormulaComponentKey> {

}
