/**
 * @author Noah Clark - npclark
 * CIS175 Fall 2022
 * Nov 3, 2022
 */

package dmacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dmacc.model.Spell;

@Repository
public interface SpellRepository extends JpaRepository<Spell, Long>{

}
