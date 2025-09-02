package repository;

import entity.BombasDeCombustivel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BombaDeCombustivelRepository extends JpaRepository<BombasDeCombustivel, Integer> {
}
