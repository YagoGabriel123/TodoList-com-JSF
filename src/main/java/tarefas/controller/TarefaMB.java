package tarefas.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

import tarefas.model.Tarefa;
import tarefas.service.TarefaService;
import utility.Message;
import utility.NegocioException;

@Named
@ViewScoped
public class TarefaMB implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Tarefa tarefa;

    @Inject
    private TarefaService service;

    private List<Tarefa> tarefas;

    @PostConstruct
    public void carregar() {
        tarefas = service.todasAsTarefas();
    }

    public void adicionar() {
        try {
            service.salvar(tarefa);
            tarefa = new Tarefa();
            carregar();
            Message.info("Salvo com sucesso");

        } catch (NegocioException e) {
            Message.erro(e.getMessage());

        }
    }

    public void excluir() {
        try {
            service.remover(tarefa);
            carregar();
            Message.info(tarefa.getTitulo() + " foi removido");

        } catch (NegocioException e) {
            Message.erro(e.getMessage());

        }
    }

    public Tarefa getTarefa() {
        return tarefa;
    }

    public void setTarefa(Tarefa tarefa) {
        this.tarefa = tarefa;
    }

    public TarefaService getService() {
        return service;
    }

    public void setService(TarefaService service) {
        this.service = service;
    }

    public void setTarefas(List<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }

    public List<Tarefa> getTarefas() {
        return tarefas;
    }
}
