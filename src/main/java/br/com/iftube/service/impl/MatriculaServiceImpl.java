package br.com.iftube.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.iftube.exception.service.ServiceException;
import br.com.iftube.model.daos.MatriculaDAO;
import br.com.iftube.model.entities.Matricula;
import br.com.iftube.model.entities.Usuario;
import br.com.iftube.service.MatriculaService;
import br.com.iftube.service.UsuarioService;

@Service
public class MatriculaServiceImpl implements MatriculaService, Converter<String, Matricula>{

	@Autowired
	private MatriculaDAO matriculaDao;
	
	@Autowired
	private UsuarioService usuarioService;
	
	
	@Transactional
	public Matricula adicionar(Matricula matricula) throws ServiceException{
		Matricula matriculaEncontrado = matriculaDao.obterMatriculaPorNome(matricula.getMatriculaAluno());
		if(matriculaEncontrado != null){
			throw new ServiceException("Matricula já existe!");
		}

		return matriculaDao.adicionar(matricula);
	}

	@Transactional
	public Matricula editar(Matricula matricula) throws ServiceException {
		Matricula matriculaEncontrado = matriculaDao.obterMatriculaPorNome(matricula.getMatriculaAluno());
		if(matriculaEncontrado != null){
			throw new ServiceException("Matricula já existe!");
		}
		
		return matriculaDao.editar(matricula);
	}

	@Transactional
	public void deletar(Matricula matricula) {
		matriculaDao.deletar(matricula);
	}

	@Transactional
	public Matricula obterMatriculaPorId(int matriculaId) {
		return matriculaDao.obterMatriculaPorId(matriculaId);
	}
	
	@Transactional
	public Matricula obterMatriculaPorNome(String matricula) {
		return matriculaDao.obterMatriculaPorNome(matricula);
	}

	@SuppressWarnings("rawtypes")
	@Transactional
	public List obterTodosMatricula() {
		return matriculaDao.obterTodosMatricula();
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public boolean validarMatricula(String matriculaStr) throws ServiceException {
		
		List<Usuario> todosUsuarios = usuarioService.obterTodosUsuario();
		
		List<Matricula> todosMatriculas = matriculaDao.obterTodosMatricula();
		boolean matriculaExiste = false;
		boolean matriculaAlunoExiste = false;
		
		for (Usuario u : todosUsuarios) {
			if(u.getIdMatriculaAlunoFk().getMatriculaAluno().equals(matriculaStr)){
				matriculaAlunoExiste = true;
				break;
			}
		}
		
		for (Matricula m : todosMatriculas) {
			if(m.getMatriculaAluno().equals(matriculaStr)){
				matriculaExiste = true;
				break;
			}
		}
		
		if(matriculaAlunoExiste){
			throw new ServiceException("Esta Matrícula já tem usuário Cadastrado!");
		}else if(!matriculaExiste){
			throw new ServiceException("Esta Matrícula Não Existe!");
		}
		
		return matriculaExiste;
	}
	
	
	@Transactional
	public Matricula convert(String matriculaAluno) {
		
		if (!matriculaAluno.equals("")) {
			return matriculaDao.obterMatriculaPorNome(String.valueOf(matriculaAluno));
		} else {
		    return null;
		}
	}

	
}
