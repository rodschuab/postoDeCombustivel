package service;

import entity.TiposDeCombustivel;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import repository.TipoDeCombustivelRepository;

@Service
@RequiredArgsConstructor
public class TipoDeCombustivelService {

    private final TipoDeCombustivelRepository tipoDeCombustivelRepository;

    public void criar(TiposDeCombustivel tiposDeCombustivel){
        tipoDeCombustivelRepository.save(tiposDeCombustivel);
    }

    public TiposDeCombustivel buscarTipoDeCombustivelPorId(Integer id){
        return tipoDeCombustivelRepository.findById(id).orElseThrow(() ->
                new NullPointerException("Tipo de combustivel não encontrada pelo id" + id));
    }
    @Transactional
    private void deletarTipoDeCombustivel(Integer id){
        tipoDeCombustivelRepository.deleteById(id);
    }

    private void alterarTipoDeCombustivel(Integer id, TiposDeCombustivel tiposDeCombustivel){
        TiposDeCombustivel bomba = buscarTipoDeCombustivelPorId(id);
        tiposDeCombustivel.setId(bomba.getId());
        tipoDeCombustivelRepository.save(tiposDeCombustivel);
    }

}
