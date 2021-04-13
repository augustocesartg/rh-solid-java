package br.com.augustogiacomini.rh.service.reajuste;

import br.com.augustogiacomini.rh.model.Funcionario;

import java.math.BigDecimal;

public interface ValidacaoReajuste {

    void validar(Funcionario funcionario, BigDecimal aumento);
}
