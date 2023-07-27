package com.tekup.projet2.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.tekup.projet2.model.Voiture;


@Component
public class VoitureRepository {
	private static final List<Voiture> voitures = new ArrayList<Voiture>();

	@PostConstruct
	public void initData() {
		Voiture voiture = new Voiture();
		voiture.setName("BMW");
		voiture.setStandard(123456);
		voiture.setAddress("local");
		voitures.add(voiture);
		voiture = new Voiture();
		voiture.setName("Audi");
		voiture.setStandard(777889);
		voiture.setAddress("local");
		voitures.add(voiture);
		voiture = new Voiture();
		voiture.setName("Toyota");
		voiture.setStandard(444446);
		voiture.setAddress("tunis bardo");
		voitures.add(voiture);
		voiture = new Voiture();
		voiture.setName("toyota");
		voiture.setStandard(147857);
		voiture.setAddress("sfax");
		voitures.add(voiture);
	}

	public List<Voiture> selectAll() {
		return voitures;
	}

	public boolean addVoiture(Voiture newVoiture) {
		return voitures.add(newVoiture);
	}

	public Voiture recherche(String name) {
		List<Voiture> data = voitures.stream().filter(x -> x.getName().equalsIgnoreCase(name))
				.collect(Collectors.toList());
		if (!data.isEmpty()) {
			return data.get(0);
		}
		return null;
	}

	public boolean supprimer(String name) {
		return voitures.removeIf(x -> x.getName().equalsIgnoreCase(name));
	}

}
