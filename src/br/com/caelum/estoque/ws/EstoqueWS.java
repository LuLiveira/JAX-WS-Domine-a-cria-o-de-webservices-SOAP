package br.com.caelum.estoque.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import br.com.caelum.estoque.modelo.item.Filtro;
import br.com.caelum.estoque.modelo.item.Filtros;
import br.com.caelum.estoque.modelo.item.Item;
import br.com.caelum.estoque.modelo.item.ItemDao;
import br.com.caelum.estoque.modelo.item.ListaItens;

@WebService
public class EstoqueWS {

	private ItemDao dao = new ItemDao();

	@WebMethod(operationName = "todosOsItens")
	@ResponseWrapper(localName="itens")
	@RequestWrapper(localName="listaItens")
	@WebResult(name = "item")
	public ListaItens getItens(@WebParam(name = "filtros") Filtros filtros) {

		List<Filtro> lista = filtros.getLista();
		List<Item> itensResultado = dao.todosItens(lista);
		
		return new ListaItens(itensResultado);
	}
}
