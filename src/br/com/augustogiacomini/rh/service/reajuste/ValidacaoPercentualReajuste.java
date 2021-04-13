package br.com.augustogiacomini.rh.service.reajuste;

import br.com.augustogiacomini.rh.ValidacaoException;
import br.com.augustogiacomini.rh.model.Funcionario;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ValidacaoPercentualReajuste implements ValidacaoReajuste {

    @Override
    public void validar(Funcionario funcionario, BigDecimal aumento) {

        BigDecimal percentualMaximo = new BigDecimal("0.4");

        BigDecimal salario = funcionario.getDadosPessoais().getSalario();

        BigDecimal percentualReajuste = aumento.divide(salario, RoundingMode.HALF_UP);

        if (percentualReajuste.compareTo(percentualMaximo) > 0) {
            throw new ValidacaoException("Reajuste nao pode ser superior a " + percentualMaximo.multiply(BigDecimal.valueOf(100)) + "% do salario!");
        }
    }
}
