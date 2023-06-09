package tarefas.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity 
@Table(name="tarefas")
public class Tarefa implements Serializable  , Base{
		@Id
		@GeneratedValue
		private Long id;
		private String titulo;
		private String descricao;
		private String responsavel;
		private String prioridade;
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Tarefa other = (Tarefa) obj;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			return true;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getTitulo() {
			return titulo;
		}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
		public void setTitulo(String titulo) {
			this.titulo = titulo;
		}
		public String getDescricao() {
			return descricao;
		}
		public void setDescrição(String descricao) {
			this.descricao = descricao;
		}
		public String getResponsavel() {
			return responsavel;
		}
		public void setResponsavel(String responsavel) {
			this.responsavel = responsavel;
		}
		public String getPrioridade() {
			return prioridade;
		}
		public void setPrioridade(String prioridade) {
			this.prioridade = prioridade;
		}
		
}
