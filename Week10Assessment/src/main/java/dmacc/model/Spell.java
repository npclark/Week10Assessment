/**
 * @author Noah Clark - npclark
 * CIS175 Fall 2022
 * Nov 3, 2022
 */

package dmacc.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
public class Spell {
	@Id
	@GeneratedValue
	private long id;
	private String name;      // Name of the spell
	private String tradition; // What traditions the spell belongs to; arcane, divine, primal, or occult
	private int level;	  // level of the spell, 1 to 10
	private boolean cantrip;  // whether the spell is a cantrip or not; true = cantrip
}
