package br.com.leandrocolevati.JasperReportsF12014v2REST.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.leandrocolevati.JasperReportsF12014v2REST.model.dto.EquipeDTO;
import br.com.leandrocolevati.JasperReportsF12014v2REST.model.entity.Equipe;
import br.com.leandrocolevati.JasperReportsF12014v2REST.peristence.EquipeRepository;

@RestController
@RequestMapping("/api")
public class EquipeController {


	@Autowired
	private EquipeRepository eRep;
	
	@GetMapping("/equipe")
	public List<EquipeDTO> listaEquipes() {
		List<Equipe> equipes = eRep.findAll();
		List<EquipeDTO> equipesDTO = convertListEquipeListEquipeDTO(equipes);
		return equipesDTO;
	}
	
	@GetMapping("/equipe/{codigoEquipe}")
	public ResponseEntity<EquipeDTO> consultaEquipe(
			@PathVariable(value = "codigoEquipe") int codigoEquipe) {
		Equipe equipe = eRep.findById(codigoEquipe).orElseThrow(
				() -> new ResourceNotFoundException(codigoEquipe+" inválido"));
		EquipeDTO equipeDTO = convertEquipeEquipeDTO(equipe);
		return ResponseEntity.ok().body(equipeDTO);
	}
	
	@PostMapping("/equipe")
	public ResponseEntity<String> adicionaEquipe(
			@Valid @RequestBody Equipe e) {
		eRep.save(e);
		String saida = "Equipe adicionada com sucesso";
		return ResponseEntity.ok().body(saida);
	}

	@PatchMapping("/equipe")
	public ResponseEntity<String> atualizaEquipe(
			@Valid @RequestBody Equipe e) {
		eRep.save(e);
		String saida = "Equipe atualizada com sucesso";
		return ResponseEntity.ok().body(saida);
	}

	@DeleteMapping("/equipe")
	public ResponseEntity<String> excluiEquipe(
			@Valid @RequestBody Equipe e) {
		eRep.delete(e);
		String saida = "Equipe excluida com sucesso";
		return ResponseEntity.ok().body(saida);
	}

	private List<EquipeDTO> convertListEquipeListEquipeDTO(List<Equipe> equipes) {
		List<EquipeDTO> equipesDTO = new ArrayList<EquipeDTO>();
		for (Equipe e : equipes) {
			EquipeDTO eDTO = new EquipeDTO();
			eDTO.setCodigo(e.getCodigo());
			eDTO.setNome(e.getNome());
			
			equipesDTO.add(eDTO);
		}
		return equipesDTO;
	}
	
	public EquipeDTO convertEquipeEquipeDTO(Equipe e) {
		EquipeDTO eDTO = new EquipeDTO();
		eDTO.setCodigo(e.getCodigo());
		eDTO.setNome(e.getNome());
			
		return eDTO;
	}
	
}
