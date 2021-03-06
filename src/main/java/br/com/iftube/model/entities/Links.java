package br.com.iftube.model.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="links")
public class Links implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2846403149994104824L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(unique=true, nullable=false, length=150)
	private String link;
	
	@Column(length=100)
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name = "id_disciplina_fk")
	private Disciplina idDisciplinaFk;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario_fk")
	private Usuario idUsuarioFk;
	
	@ManyToMany
	@JoinTable(name="palavras_chaves_links", joinColumns={@JoinColumn(name="link_id")}, inverseJoinColumns={@JoinColumn(name="palavra_chave_id")})
	private List<PalavraChave> palavraChaveId;
	
	//private Views views;
	//private Comentario comentario;
	//private Likes likes;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Disciplina getIdDisciplinaFk() {
		return idDisciplinaFk;
	}

	public void setIdDisciplinaFk(Disciplina idDisciplinaFk) {
		this.idDisciplinaFk = idDisciplinaFk;
	}

	public Usuario getIdUsuarioFk() {
		return idUsuarioFk;
	}

	public void setIdUsuarioFk(Usuario idUsuarioFk) {
		this.idUsuarioFk = idUsuarioFk;
	}

	public List<PalavraChave> getPalavraChaveId() {
		return palavraChaveId;
	}

	public void setPalavraChaveId(List<PalavraChave> palavraChaveId) {
		this.palavraChaveId = palavraChaveId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((idDisciplinaFk == null) ? 0 : idDisciplinaFk.hashCode());
		result = prime * result + ((idUsuarioFk == null) ? 0 : idUsuarioFk.hashCode());
		result = prime * result + ((link == null) ? 0 : link.hashCode());
		result = prime * result + ((palavraChaveId == null) ? 0 : palavraChaveId.hashCode());
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
		Links other = (Links) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idDisciplinaFk == null) {
			if (other.idDisciplinaFk != null)
				return false;
		} else if (!idDisciplinaFk.equals(other.idDisciplinaFk))
			return false;
		if (idUsuarioFk == null) {
			if (other.idUsuarioFk != null)
				return false;
		} else if (!idUsuarioFk.equals(other.idUsuarioFk))
			return false;
		if (link == null) {
			if (other.link != null)
				return false;
		} else if (!link.equals(other.link))
			return false;
		if (palavraChaveId == null) {
			if (other.palavraChaveId != null)
				return false;
		} else if (!palavraChaveId.equals(other.palavraChaveId))
			return false;
		return true;
	}

}
