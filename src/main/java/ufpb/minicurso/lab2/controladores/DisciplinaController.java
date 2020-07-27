package ufpb.minicurso.lab2.controladores;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import ufpb.minicurso.lab2.servicos.DisciplinaService;
import ufpb.minicurso.lab2.entidades.Disciplina;


/**
 * GET /api/disciplinas Retorna um JSON (com campos id, nome) com todas as disciplinas inseridas no sistema e código 200.
 * 
 * GET /api/disciplinas/{id} Retorna um JSON que representa a disciplina completa (id, nome, nota, likes e comentarios) 
 *     cujo identificador único é id e código 200. Ou não retorna JSON e código 404 (not found) caso o id passado não tenha 
 *     sido encontrado.
 * 
 * PUT /api/disciplinas/likes/{id} Incrementa em um o número de likes da disciplina cujo identificador é id. Retorna a disciplina que 
 *     foi atualizada (incluindo o id, nome e likes) e código 200. Ou não retorna JSON e código 404 (not found) caso o id passado não 
 *     tenha sido encontrado.
 *     
 * PUT /api/disciplinas/nota/{id} Atualiza a nota da disciplina de identificador id no sistema. No corpo da requisição HTTP deve estar
 *     um JSON com uma nova nota atribuída à disciplina. A nova nota da disciplina é a média aritmética da nota anterior da disciplina
 *     e da nova nota passada nesta chamada. Se for a primeira nota sendo adicionada então esta nota é a que vai valer para a disciplina.
 *     Retorna a disciplina que foi atualizada (incluindo o id, nome e nota) e código 200. Ou não retorna JSON e código 404 (not found) 
 *     caso o id passado não tenha sido encontrado.
 *     
 * PUT /api/disciplinas/comentarios/{id} Insere um novo comentário na disciplina de identificador id. No corpo da requisição HTTP deve 
 *     estar um JSON com o novo comentário (chave “comentario”) a ser adicionado na disciplina a ser atualizada no sistema. Retorna a 
 *     disciplina que foi atualizada (incluindo o id, nome e os comentarios atualizados) e código 200. Ou não retorna JSON e código 404 
 *     (not found) caso o id passado não tenha sido encontrado.
 *     
 * GET /api/disciplinas/ranking/notas Retorna todas as disciplinas inseridas no sistema ordenadas pela nota (da maior para a menor) e código 200.
 * 
 * GET /api/disciplinas/ranking/likes Retorna todas as disciplinas inseridas no sistema ordenadas pelo número de likes (da que tem mais
 *     likes para a que tem menos likes) e código 200.
 *     
 *@author Thallyson Oliveira
 */


@RestController
public class DisciplinaController {

	@Autowired
	private DisciplinaService disciplinaService;
	
	// Pede para retornar todas as disciplinas cadastrada
	@GetMapping("/api/disciplinas")
	public ResponseEntity<List<Disciplina>> getTodasDisciplinas() {
		return new ResponseEntity<List<Disciplina>>(disciplinaService.getTodasDisciplinas(), HttpStatus.OK);
	}
	
	@GetMapping("/api/disciplinas/{id}")
	public ResponseEntity<Disciplina> getDisciplinaID(@PathVariable Integer id){
		try {
			return new ResponseEntity<Disciplina>(disciplinaService.getDisciplinaPeloID(id),HttpStatus.OK);
		} catch (NoSuchElementException aiobe) {
			return new ResponseEntity<Disciplina>(new Disciplina(null),HttpStatus.NOT_FOUND);
		}	
	}
	
	@PutMapping("/api/disciplinas/likes/{id}")
	public ResponseEntity<Disciplina> setLikeDisciplinaId(@PathVariable Integer id){
		try {
			return new ResponseEntity<Disciplina>(disciplinaService.setLikeDisciplinaId(id),HttpStatus.OK);
		} catch (NoSuchElementException aiobe) {
			return new ResponseEntity<Disciplina>(new Disciplina(null),HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/api/disciplinas/nota/{id}")
	public ResponseEntity<Disciplina> uppdateNota(@PathVariable Integer id, Double nota){
		try {
			return new ResponseEntity<Disciplina>(disciplinaService.uppdateNodaDisciplin(id, nota),HttpStatus.OK);
		} catch (NoSuchElementException aiobe) {
			return new ResponseEntity<Disciplina>(new Disciplina(null),HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/api/disciplinas/comentarios/{id}")
	public ResponseEntity<Disciplina> uppdateComentario(@PathVariable Integer id, String comentario){
		try {
			return new ResponseEntity<Disciplina>(disciplinaService.uppdateComentarioDisciplina(id, comentario),HttpStatus.OK);
		} catch (NoSuchElementException aiobe) {
			return new ResponseEntity<Disciplina>(new Disciplina(null),HttpStatus.NOT_FOUND);
		}
	}
	
	//@GetMapping("/api/disciplinas/ranking/nota")
	//public ResponseEntity<List<Disciplina>>
	
	//@GetMapping("/api/disciplinas/ranking/likes")
		//public ResponseEntity<List<Disciplina>>
	
}
