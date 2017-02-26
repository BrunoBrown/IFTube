package br.com.iftube.controller.curso;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.iftube.exception.service.ServiceException;
import br.com.iftube.model.entities.Curso;
import br.com.iftube.service.CursoService;


@Controller
public class CursoController {

	@Autowired
	private CursoService cursoService;


	@RequestMapping("exibirPaginaCadastrarCurso")
	public String exibirPaginaCadastrarCurso(Model model) {
		model.addAttribute("listarCurso", cursoService.obterTodosCurso());
		return "adm/curso/addCursoTemp";
	}
	
	@Transactional
	@RequestMapping("addCurso")
	public String cadastrarCurso(Curso curso) {
		
			try {
				cursoService.adicionar(curso);
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		return "forward:exibirPaginaCadastrarCurso";
	}

	@RequestMapping("editCurso")
	@Transactional
	public String alterarCurso(int id, Curso curso){
		cursoService.editar(curso);
		return "forward:exibirPaginaCadastrarCurso";
	}
	
	@RequestMapping("deleteCurso")
	@Transactional
	public String removeCurso(int id, Curso curso){
		
		cursoService.deletar(cursoService.obterCursoPorId(curso.getId()));
		return "forward:exibirPaginaCadastrarCurso";
	}
	
	@RequestMapping("searchCurso")
	@Transactional
	public String searchCurso(String nomeCurso, Model model){
		Curso cursoLocalizado = cursoService.obterCursoPorNome(nomeCurso);
		model.addAttribute("listarCurso", cursoLocalizado);
		return "adm/curso/addCursoTemp";
	}

}
