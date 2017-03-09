package br.com.caelum.financas.mb;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.financas.dao.ContaDao;

@Named
@RequestScoped
public class OperacaoEmLoteBean {

	@Inject
	ContaDao contaDao;

	private String antigoNomeBanco;
	private String novoNomeBanco;
	private int contasAlteradas;

	public void atualizar() {

		System.out
				.println("Quantidade de contas alteradas: " + contasAlteradas);
		this.contasAlteradas = contaDao.trocaNomeDoBancoEmLote(antigoNomeBanco,
				novoNomeBanco);
		this.limpaFormularioDoJSF();
	}

	public String getAntigoNomeBanco() {
		return antigoNomeBanco;
	}

	public void setAntigoNomeBanco(String antigoNomeBanco) {
		this.antigoNomeBanco = antigoNomeBanco;
	}

	public String getNovoNomeBanco() {
		return novoNomeBanco;
	}

	public void setNovoNomeBanco(String novoNomeBanco) {
		this.novoNomeBanco = novoNomeBanco;
	}

	public int getContasAlteradas() {
		return contasAlteradas;
	}

	private void limpaFormularioDoJSF() {
		this.antigoNomeBanco = "";
		this.novoNomeBanco = "";
	}

}
