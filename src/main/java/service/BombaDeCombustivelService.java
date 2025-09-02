package service;

import entity.BombasDeCombustivel;
import jakarta.persistence.Entity;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import repository.BombaDeCombustivelRepository;

@Entity
@RequiredArgsConstructor
public class BombaDeCombustivelService {

    private final BombaDeCombustivelRepository bombaDeCombustivelRepository;

    public void criar(BombasDeCombustivel bombasDeCombustivel){
        bombaDeCombustivelRepository.save(bombasDeCombustivel);
    }

    public BombasDeCombustivel buscarBombaCombustivelPorId(Integer id){
       return bombaDeCombustivelRepository.findById(id).orElseThrow(() ->
                new NullPointerException("Bomba de combustivel nao encontrada pelo id" + id));
    }
    @Transactional
    public void deletarBombaCombustivel(Integer id){
        bombaDeCombustivelRepository.deleteById(id);
    }

    public void alterarBombaCombustivel(Integer id,BombasDeCombustivel bombasDeCombustivel){
        BombasDeCombustivel bomba = buscarBombaCombustivelPorId(id);
        bombasDeCombustivel.setId(bomba.getId());
        bombaDeCombustivelRepository.save(bombasDeCombustivel);
    }
}


