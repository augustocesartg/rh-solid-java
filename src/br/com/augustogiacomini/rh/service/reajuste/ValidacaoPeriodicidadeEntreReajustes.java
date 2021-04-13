package br.com.augustogiacomini.rh.service.reajuste;

import br.com.augustogiacomini.rh.ValidacaoException;
import br.com.augustogiacomini.rh.model.Funcionario;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ValidacaoPeriodicidadeEntreReajustes implements ValidacaoReajuste {

    @Override
    public void validar(Funcionario funcionario, BigDecimal aumento) {

        long intervaloMinimo = 6;

        LocalDate dataUltimoReajuste = funcionario.getDataUltimoReajuste();
        LocalDate dataAtual = LocalDate.now();

        long mesesDesdeUltimoReajuste = ChronoUnit.MONTHS.between(dataUltimoReajuste, dataAtual);

        if (mesesDesdeUltimoReajuste < intervaloMinimo) {
            throw new ValidacaoException("Intervalo entre reajuste deve ser de no mínimo " + intervaloMinimo + " mêses!");
        }
    }
}
