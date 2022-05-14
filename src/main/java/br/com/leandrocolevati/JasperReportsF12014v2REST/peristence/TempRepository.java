package br.com.leandrocolevati.JasperReportsF12014v2REST.peristence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import br.com.leandrocolevati.JasperReportsF12014v2REST.model.entity.Temp;

public interface TempRepository extends JpaRepository<Temp, Integer> {

	@Modifying
    @Query(value = "SELECT c.codigo, c.pais, p.numero, p.nome, e.nome AS equipe, t.posicao, t.pontos "
			+ " FROM corrida c INNER JOIN temporada t "
			+ " ON c.codigo = t.codigo_corrida "
			+ " INNER JOIN piloto p "
			+ "	ON p.numero = t.numero_piloto "
			+ " INNER JOIN equipe e "
			+ "	ON p.equipe = e.codigo "
			+ "	WHERE t.posicao != 0 "
			+ "	AND c.codigo = ?1 "
			+ " ORDER BY posicao ASC", 
            nativeQuery = true)
	List<Temp> listaFinalCorrida(int codigoCorrida);
    
}
