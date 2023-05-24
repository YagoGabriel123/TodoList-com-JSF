package tarefas.service;

import dao.TarefaDao;
import tarefas.model.Tarefa;
import utility.NegocioException;

import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

public class TarefaService implements Serializable {
	private static final long serialVersionUID = 1L;
	@Inject
	private TarefaDao tarefaDao;
	public TarefaService() {
	}

	public void salvar(Tarefa m) throws NegocioException{
		if(m.getTitulo().length() < 3) {
			throw new NegocioException("O Titulo da tarefa não pode conter apenas 3 caracteres");
		}

		tarefaDao.salvar(m);
	}
	
	public void remover( Tarefa m) throws NegocioException {
		tarefaDao.remover( m.getId());
	}
	
	public List<Tarefa> todasAsTarefas(){
		return  tarefaDao.buscarTodos();
	}
}