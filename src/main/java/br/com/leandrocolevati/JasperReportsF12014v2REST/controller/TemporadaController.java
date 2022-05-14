package br.com.leandrocolevati.JasperReportsF12014v2REST.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.leandrocolevati.JasperReportsF12014v2REST.model.dto.TempDTO;
import br.com.leandrocolevati.JasperReportsF12014v2REST.model.dto.TemporadaDTO;
import br.com.leandrocolevati.JasperReportsF12014v2REST.model.entity.Temp;
import br.com.leandrocolevati.JasperReportsF12014v2REST.model.entity.Temporada;
import br.com.leandrocolevati.JasperReportsF12014v2REST.peristence.TempRepository;
import br.com.leandrocolevati.JasperReportsF12014v2REST.peristence.TemporadaRepository;

@RestController
@RequestMapping("/api")
public class TemporadaController {

	@Autowired
	private TemporadaRepository tRep;

	@Autowired
	private TempRepository tempRep;

	@Autowired
	private PilotoController pCont;

	@Autowired
	private CorridaController cCont;

	@GetMapping("/temporada")
	public List<TemporadaDTO> listaTemporada() {
		List<Temporada> temporadas = tRep.findAll();
		List<TemporadaDTO> temporadasDTO = convertListTemporadaListTemporadaDTO(temporadas);
		return temporadasDTO;
	}

	@GetMapping("/temporada/{codigoCorrida}")
	public List<TemporadaDTO> listaPorCorrida(@PathVariable(value = "codigoCorrida") int codigoCorrida) {
		List<Temporada> temporadas = tRep.findByCorridaCodigo(codigoCorrida);
		List<TemporadaDTO> temporadasDTO = convertListTemporadaListTemporadaDTO(temporadas);
		return temporadasDTO;
	}

	@GetMapping("/temp/{codigoCorrida}")
	public List<TempDTO> resultadoCorrida(@PathVariable(value = "codigoCorrida") int codigoCorrida) {
		List<Temp> temps = tempRep.listaFinalCorrida(codigoCorrida);
		List<TempDTO> tempsDTO = convertListTempListTempDTO(temps);
		return tempsDTO;
	}

	private List<TempDTO> convertListTempListTempDTO(List<Temp> temps) {
		List<TempDTO> tempsDTO = new ArrayList<TempDTO>();

		for (Temp temp : temps) {
			TempDTO tempDTO = new TempDTO();
			tempDTO.setCodigoCorrida(temp.getCodigoCorrida());
			tempDTO.setNomeEquipe(temp.getNomeEquipe());
			tempDTO.setNomePiloto(temp.getNomePiloto());
			tempDTO.setNumeroPiloto(temp.getNumeroPiloto());
			tempDTO.setPais(temp.getPais());
			tempDTO.setPontos(temp.getPontos());
			tempDTO.setPosicao(temp.getPosicao());
			
			tempsDTO.add(tempDTO);
		}
		return tempsDTO;
	}

	private List<TemporadaDTO> convertListTemporadaListTemporadaDTO(List<Temporada> temporadas) {
		List<TemporadaDTO> temporadasDTO = new ArrayList<TemporadaDTO>();

		for (Temporada t : temporadas) {
			TemporadaDTO tDTO = new TemporadaDTO();
			tDTO.setPontos(t.getPontos());
			tDTO.setPosicao(t.getPosicao());
			tDTO.setPiloto(pCont.convertPilotoPilotoDTO(t.getPiloto()));
			tDTO.setCorrida(cCont.convertCorridaCorridaDTO(t.getCorrida()));

			temporadasDTO.add(tDTO);
		}
		return temporadasDTO;
	}
}
