
package com.mendonca.xptoSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mendonca.xptoSystem.entities.Cidades;


@Transactional(readOnly = true)
@Repository
public interface CidadesRepository extends JpaRepository<Cidades, Integer> {

	@Query("SELECT obj FROM Cidades obj WHERE obj.capital = 'true' order by obj.name")
	List<Cidades> findByCapital(); // Retornando capitais.

	@Query("SELECT obj.uf,COUNT(obj.uf)  FROM Cidades obj GROUP BY obj.uf ")
	List<Object[]> findCidadeUf(); // Retornando cidades por Uf.

	@Query("SELECT  obj.uf, COUNT(obj.uf)  FROM Cidades obj GROUP BY obj.uf ORDER BY COUNT(obj.uf)")
	Object[] findByMenor();// Retornando uf com menor numero de cidades.


	@Query("SELECT  obj.uf, COUNT(obj.uf)  FROM Cidades obj GROUP BY obj.uf ORDER BY COUNT(obj.uf) DESC")	
	Object[] findByMaior();// Retornando uf com maior numero de cidades.
	
	@Query("SELECT Count(obj) FROM Cidades obj ")
	Long findByTotal(); // Retornando numero total de registro.
	
	@Query("SELECT obj  FROM Cidades obj WHERE obj.ibge_id = :ibge")	
	List<Cidades> findByIbge(@Param("ibge")String ibge);// Retornando cidade por numero IBGE.
	
	@Query("SELECT obj  FROM Cidades obj WHERE obj.uf = :uf")	
	List<Cidades> findByCidadePorEstado(@Param("uf")String uf);// Retornando cidade por numero Estado.
	
	
}


