package service;

import entity.Abastecimento;
import entity.BombasDeCombustivel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import repository.AbastecimentoRepository;
import repository.BombaDeCombustivelRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AbastecimentoService {

    private final AbastecimentoRepository abastecimentoRepository;

    private final BombaDeCombustivelService bombaDeCombustivelService;

    public void abastecer(Integer idBomba, Long litros) {
        BombasDeCombustivel bomba = bombaDeCombustivelService.buscarBombaCombustivelPorId(idBomba);
        BigDecimal valorTotal = bomba.getTiposDeCombustivel().getPrecoPorLitro().multiply(BigDecimal.valueOf(litros));

        Abastecimento abastecimento = Abastecimento.builder()
                .dataAbastecimento(LocalDate.now())
                .bombasDeCombustivel(bomba)
                .valorTotal(valorTotal)
                .quantidadeLitros(litros)
                .build();

        abastecimentoRepository.save(abastecimento);
    }

    public List<Abastecimento> buscarAbastecimentos(){
        return abastecimentoRepository.findAll();
    }

}

