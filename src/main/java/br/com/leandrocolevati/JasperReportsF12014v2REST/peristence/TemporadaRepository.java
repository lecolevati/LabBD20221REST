package br.com.leandrocolevati.JasperReportsF12014v2REST.peristence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.leandrocolevati.JasperReportsF12014v2REST.model.entity.Temporada;

public interface TemporadaRepository extends JpaRepository<Temporada, Integer> {

	List<Temporada> findByCorridaCodigo(int CodigoCorrida);
}
