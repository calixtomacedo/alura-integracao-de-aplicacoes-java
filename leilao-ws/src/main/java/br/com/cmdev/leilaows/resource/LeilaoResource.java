package br.com.cmdev.leilaows.resource;
/*
import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.validator.ValidationMessage;
import br.com.caelum.vraptor.view.Results;
import br.com.cmdev.leilaows.model.Leilao;
import br.com.cmdev.leilaows.repository.LeilaoRepository;

@Resource
public class LeilaoResource {

	private final Result result;
	private final LeilaoRepository leiloes;
	private final Validator validator;
	
	LeilaoResource(Result result, LeilaoRepository leiloes, Validator validator) {
		this.result = result;
		this.leiloes = leiloes;
		this.validator = validator;
	}
	
	@Get("/leiloes")
	public void index() {
		result.use(Results.representation()).from(leiloes.findAll()).recursive().serialize();
	}

	@Get("/leiloes/total")
	public void total() {
		result.use(Results.representation()).from(leiloes.findAll().size()).serialize();
	}

	
	@Post("/leiloes")
	@Consumes
	public void create(final Leilao leilao) {

		if (leilao.getNome().isEmpty()) {
		    validator.add(new ValidationMessage("Nome obrigatorio!", "error"));
		}
		if (leilao.getValorInicial() == null || leilao.getValorInicial() <= 0) {
		    validator.add(new ValidationMessage("Valor inicial deve ser maior que zero!", "error"));
		}

		validator.onErrorSendBadRequest();
		
		leiloes.create(leilao);
		result.use(Results.representation()).from(leilao).recursive().serialize();
	}
	
	@Get("/leiloes/show")
	public void show(Leilao leilao) {
		result.use(Results.representation()).from(leiloes.find(leilao.getId())).recursive().serialize();
	}
	
	@Delete("/leiloes/deletar")
	@Consumes
	public void destroy(Leilao leilao) {
		leiloes.destroy(leilao);
		result.nothing();  
	}


}
*/