package dao;

import tarefas.model.Tarefa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class TarefaDao {
    public TarefaDao() {
    }
    public Tarefa buscarPorId( Long id) {
        try {
            String jpql = "SELECT * FROM Tarefa  t WHERE t.id = :id";
            Query query = manager.createQuery(jpql, Tarefa.class);
            query.setParameter("id", id);
            return (Tarefa) query.getSingleResult();
        } catch (Exception e) {
            return null;
        }

    }
    @PersistenceContext(name = "prova-java")
    private EntityManager manager;

    public void salvar(Tarefa t) {

        try {
            manager.getTransaction().begin();

            if (t.getId() == null) {
                manager.persist(t);
            } else {
                manager.merge(t);
            }
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
        }
    }
    public void remover( Long id) {
        Tarefa t = buscarPorId( id);
        try {
            manager.getTransaction().begin();
            manager.remove(t);
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
        }

    }

    public List<Tarefa> buscarTodos() {
        return manager.createQuery("FROM Tarefa", Tarefa.class).getResultList();
    }
}
