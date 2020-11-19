package br.com.daysesoares.ajax.services;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import br.com.daysesoares.ajax.domain.Promocao;
import br.com.daysesoares.ajax.repository.PromocaoRepository;

public class PromocaoDataTablesService {

	private String[] cols = {
			"id", "titulo", "site", "linkPromocao", "descricao", "linkImagem", 
			"preco", "likes", "dtCadastro", "categoria" 
	};
	
	public Map<String, Object> execute(PromocaoRepository repository, HttpServletRequest request){
		
		int start = Integer.parseInt(request.getParameter("start"));
		int length = Integer.parseInt(request.getParameter("length"));
		int draw = Integer.parseInt(request.getParameter("draw"));
		
		int current = currentPage(start, length);
		
		String column = columnName(request);
		Sort.Direction direction = orderBy(request) ;
		
		PageRequest pageRequest = PageRequest.of(current, length, direction, column);
		Page<Promocao> page = queryBy(repository, pageRequest);
		
		Map<String, Object> json = new LinkedHashMap<>();
		json.put("draw", draw);
		json.put("recordsTotal", page.getTotalElements());
		json.put("recordsFiltered", page.getTotalElements());
		json.put("data", page.getContent());
		
		return json;
	}
	
	private Page<Promocao> queryBy(PromocaoRepository repository, PageRequest pageRequest) {
		return repository.findAll(pageRequest);
	}

	private Direction orderBy(HttpServletRequest request) {
		String order = request.getParameter("order[0][dir]");
		Sort.Direction sort = Sort.Direction.ASC;
		if(order.equalsIgnoreCase("desc")) {
			sort = Sort.Direction.DESC;
		}
		return sort;
	}

	private String columnName(HttpServletRequest request) {
		int iCol = Integer.parseInt(request.getParameter("order[0][column]"));
		return cols[iCol];
	}

	private int currentPage(int start, int length) {
		return 0;
	}
	
}
