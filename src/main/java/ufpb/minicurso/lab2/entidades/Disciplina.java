package ufpb.minicurso.lab2.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Disciplina {

	@Id@GeneratedValue
	private long id;
	private String nome;
	private Double nota;
	private String comentarios;
	private int likes;
	
	
	public Disciplina() {
		super();
		this.nome = "Materia";
		this.nota = 0.0;
		this.comentarios = "";
		this.likes = 0;
	}
	
	public Disciplina(String nome, Double nota, String comentario, int like) {
		super();
		this.nome=nome;
		this.nota = nota;
		this.comentarios = comentario;
		this.likes = like;
	}
	public Disciplina(String nome) {
		super();
		this.nome=nome;
		this.nota = 0.0;
		this.comentarios = "";
		this.likes = 0;
	}
	
	
	public String getNome() {
		return this.nome;
	}
	public void setNome(String n) {
		this.nome = n;
	}
	public Double getNota() {
		return this.nota;
	}
	public void setNota(Double n) {
		this.nota = n;
	}
	public String getComentarios() {
		return this.comentarios;
	}
	public void setComentarios(String comentario) {
		this.comentarios = comentario;
	}
	public int getLikes() {
		return this.likes;
	}
	public void setLikes(int like) {
		this.likes = like;
	}

	
	
}
