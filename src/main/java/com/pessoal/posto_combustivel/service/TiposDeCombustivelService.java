package service;

import entity.TiposDeCombustivel;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import repository.TipoDeCombustivelRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TiposDeCombustivelService {

    private final TipoDeCombustivelRepository tipoDeCombustivelRepository;

    public void criar(TiposDeCombustivel tiposDeCombustivel){
        tipoDeCombustivelRepository.save(tiposDeCombustivel);
    }

    public TiposDeCombustivel buscarTipoDeCombustivelPorId(Integer id){
        return tipoDeCombustivelRepository.findById(id).orElseThrow(() ->
                new NullPointerException("Tipo de combustivel não encontrada pelo id" + id));
    }

    public List<TiposDeCombustivel> buscarTiposDeCombustivel(){
        return tipoDeCombustivelRepository.findAll();
    }

    @Transactional
    public void deletarTipoDeCombustivel(Integer id){
        tipoDeCombustivelRepository.deleteById(id);
    }

    public void alterarTipoDeCombustivel(Integer id, TiposDeCombustivel tiposDeCombustivel){
        TiposDeCombustivel bomba = buscarTipoDeCombustivelPorId(id);
        tiposDeCombustivel.setId(bomba.getId());
        tipoDeCombustivelRepository.save(tiposDeCombustivel);
    }

}
