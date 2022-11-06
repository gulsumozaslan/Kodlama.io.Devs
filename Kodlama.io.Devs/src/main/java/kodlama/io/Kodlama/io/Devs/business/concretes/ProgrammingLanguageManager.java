package kodlama.io.Kodlama.io.Devs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {

	private ProgrammingLanguageRepository programmingLanguageRepository;

	@Autowired
	public ProgrammingLanguageManager(ProgrammingLanguageRepository programmingLanguageRepository) {

		this.programmingLanguageRepository = programmingLanguageRepository;
	}

	@Override
	public List<ProgrammingLanguage> getAll() {
		return programmingLanguageRepository.getAll();

	}

	@Override
	public void add(ProgrammingLanguage programmingLanguage) throws Exception {
		if (programmingLanguage.getName().isEmpty()) {
			throw new Exception("Programlama dili boş olamaz");
		}
		if (languageIsExist(programmingLanguage.getName())) {
			throw new Exception("Bu programlama dili zaten kayıtlı");
		} else {
			programmingLanguageRepository.add(programmingLanguage);
		}

	}

	@Override
	public void delete(ProgrammingLanguage programmingLanguage) {
		programmingLanguageRepository.delete(programmingLanguage);

	}

	@Override
	public void update(ProgrammingLanguage programmingLanguage) {
		programmingLanguageRepository.update(programmingLanguage);

	}

	private boolean languageIsExist(String name) {
		for (ProgrammingLanguage language : programmingLanguageRepository.getAll()) {
			if (language.getName().equals(name)) {
				return true;
			}
		}
		return false;

	}

}
