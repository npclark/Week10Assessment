/**
 * @author Noah Clark - npclark
 * CIS175 Fall 2022
 * Nov 3, 2022
 */

package dmacc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import dmacc.model.Spell;
import dmacc.repository.SpellRepository;

@Controller
public class WebController {
	@Autowired
	SpellRepository repo;
	
	@GetMapping({ "/", "viewAll" })
	public String viewAllSpells(Model model) {
		if(repo.findAll().isEmpty()) {
			return addNewSpell(model);
		}
		
		model.addAttribute("spells", repo.findAll());
		return "results";
	}
	
	@GetMapping("/inputSpell")
	public String addNewSpell(Model model) {
		Spell s = new Spell();
		model.addAttribute("newSpell", s);
		return "input";
	}
	
	@PostMapping("/inputSpell")
	public String addNewSpell(@ModelAttribute Spell s, Model model) {
		repo.save(s);
		return viewAllSpells(model);
	}
	
	@GetMapping("/edit/{id}")
	public String showUpdateSpell(@PathVariable("id") long id, Model model) {
		Spell s = repo.findById(id).orElse(null);
		model.addAttribute("newSpell", s);
		return "input";
	}
	
	@PostMapping("/update/{id}")
	public String reviseSpell(Spell s, Model model) {
		repo.save(s);
		return viewAllSpells(model);
	}
	
	@GetMapping("/delete/{id}")
	public String deleteSpell(@PathVariable("id") long id, Model model) {
		Spell s = repo.findById(id).orElse(null);
		repo.delete(s);
		return viewAllSpells(model);
	}

}
