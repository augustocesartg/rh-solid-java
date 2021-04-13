package br.com.augustogiacomini.rh.service.promocao;

import br.com.augustogiacomini.rh.ValidacaoException;
import br.com.augustogiacomini.rh.model.Cargo;
import br.com.augustogiacomini.rh.model.Funcionario;

public class PromocaoService {

    public void promover(Funcionario funcionario, boolean metaBatida) {

        Cargo cargoAtual = funcionario.getDadosPessoais().getCargo();

        if (Cargo.GERENTE.equals(cargoAtual)) {
            throw new ValidacaoException("Gerentes não podem ser promovidos!");
        }

        if (metaBatida) {
            Cargo novoCargo = cargoAtual.getProximoCargo();
            funcionario.promover(novoCargo);
        } else {
            throw new ValidacaoException("Funcionário não bateu a meta!");
        }
    }
}
