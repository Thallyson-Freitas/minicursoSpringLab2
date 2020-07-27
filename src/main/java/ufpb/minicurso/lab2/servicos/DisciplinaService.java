package ufpb.minicurso.lab2.servicos;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ufpb.minicurso.lab2.entidades.Disciplina;
import ufpb.minicurso.lab2.repositorios.DisciplinaRepository;

@Service
public class DisciplinaService {

	@Autowired
	private DisciplinaRepository<Disciplina, Integer> disciplinaDAO;
	
	
	public List<Disciplina> getTodasDisciplinas(){
		return disciplinaDAO.findAll();
	}
	
	public Disciplina getDisciplinaPeloID (int id) {
		if (disciplinaDAO.count() == 0 || id <= 0 || id > (int) disciplinaDAO.count()) {
			throw new NoSuchElementException();
		}
		if (disciplinaDAO.findById(id).isEmpty()){
			throw new NoSuchElementException();
		}
		Disciplina disciplina  = disciplinaDAO.findById(id).get();
		return disciplina;
	}
	
	public Disciplina setLikeDisciplinaId(int id) {
		if (disciplinaDAO.count() == 0 || id <= 0 || id > (int) disciplinaDAO.count()) {
			throw new NoSuchElementException();
		}
		if (disciplinaDAO.findById(id).isEmpty()){
			throw new NoSuchElementException();
		}
		int temp = (disciplinaDAO.findById(id).get().getLikes()) + 1;
		disciplinaDAO.findById(id).get().setLikes(temp);
		Disciplina disciplina  = disciplinaDAO.findById(id).get();
		return disciplina;
	}
	
	public Disciplina uppdateNodaDisciplin(int id, double nota) {
		if (disciplinaDAO.count() == 0 || id <= 0 || id > (int) disciplinaDAO.count()) {
			throw new NoSuchElementException();
		}
		if (disciplinaDAO.findById(id).isEmpty()){
			throw new NoSuchElementException();
		}
		if (disciplinaDAO.findById(id).get().getNota() == 0) {
			disciplinaDAO.findById(id).get().setNota(nota);
		}
		else {
			double temp = disciplinaDAO.findById(id).get().getNota();
			temp = (temp + nota) / 2;
			disciplinaDAO.findById(id).get().setNota(temp);
		}
		Disciplina disciplina = disciplinaDAO.findById(id).get();
		return disciplina;
	}
	public Disciplina uppdateComentarioDisciplina(int id, String comentario) {
		if (disciplinaDAO.count() == 0 || id <= 0 || id > (int) disciplinaDAO.count()) {
			throw new NoSuchElementException();
		}
		if (disciplinaDAO.findById(id).isEmpty()){
			throw new NoSuchElementException();
		}
		String temp = disciplinaDAO.findById(id).get().getComentarios();
		temp += "/n" + comentario;
		disciplinaDAO.findById(id).get().setComentarios(temp);
		Disciplina disciplina = disciplinaDAO.findById(id).get();
		return disciplina;
	}
	
	
	
}
