package repository;

import entity.TiposDeCombustivel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoDeCombustivelRepository extends JpaRepository<TiposDeCombustivel, Integer> {
}
