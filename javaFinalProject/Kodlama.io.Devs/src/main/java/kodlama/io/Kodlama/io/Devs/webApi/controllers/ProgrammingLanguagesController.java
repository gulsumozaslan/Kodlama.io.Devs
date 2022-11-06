package kodlama.io.Kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@RestController
@RequestMapping("/api/programmingLanguages")
public class ProgrammingLanguagesController {
	private ProgrammingLanguageService languageService;

	@Autowired
	public ProgrammingLanguagesController(ProgrammingLanguageService programmingLanguageService) {

		this.languageService = programmingLanguageService;
	}

	@GetMapping("/getall")
	public List<ProgrammingLanguage> getAll() {
		return languageService.getAll();
	}

	@PostMapping("/add")
	public void add(ProgrammingLanguage programmingLanguage) throws Exception {
		languageService.add(programmingLanguage);
	}

	@DeleteMapping("/delete")
	public void delete(ProgrammingLanguage programmingLanguage) {
		languageService.delete(programmingLanguage);
	}

	@PutMapping("/update")
	public void update(ProgrammingLanguage programmingLanguage) {
		languageService.update(programmingLanguage);
	}

}
