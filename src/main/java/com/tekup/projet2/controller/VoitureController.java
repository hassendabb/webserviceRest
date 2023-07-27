package com.tekup.projet2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tekup.projet2.model.Voiture;
import com.tekup.projet2.repository.VoitureRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import springfox.documentation.annotations.ApiIgnore;

@Tag(name = "VoitureController", description = "the voiture API")

@RestController

@RequestMapping("voitures")

public class VoitureController {

	@Autowired


	private VoitureRepository repository;

	@Operation(summary = "Get list of Voitures in the System ", tags = "getVoitures")

	@ApiResponses(value = {

			@ApiResponse(responseCode = "200", description = "Success|OK", content = {

			@Content(mediaType = "application/json", schema = @Schema(implementation = Voiture.class)) }),

			@ApiResponse(responseCode = "401", description = "notauthorized!"),

			@ApiResponse(responseCode = "403", description = "forbidden!!!"),

			@ApiResponse(responseCode = "404", description = "not found!!!") })

	@GetMapping()

	ResponseEntity<List<Voiture>> all() {

		return ResponseEntity.ok(repository.selectAll());

	}





	@Operation(summary = "Add a new Voiture to the System ", tags = "postVoiture")

	@PostMapping()

	ResponseEntity<Boolean> newVoiture(@RequestBody Voiture newVoiture) {
		

		return ResponseEntity.ok(repository.addVoiture(newVoiture));
      
	}

	@Operation(summary = "Get Voiture By Name", description = "Voituremust exist", tags = "getVoiture")

	@GetMapping("/{name}")

	ResponseEntity<Voiture> one(@PathVariable String name) {
        Voiture voiture = repository.recherche(name);
		
		return ResponseEntity.ok(repository.recherche(name));
		
	}

	@Operation(summary = "Delete a specific Voiture from the System ", description = "Voiture must exist", tags = "deleteVoiture", hidden = true)

	@DeleteMapping("/{name}")

	ResponseEntity deleteVoiture(@PathVariable String name) {
     

		if (repository.supprimer(name)) {
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
			
		}

	}

}
