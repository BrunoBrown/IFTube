package br.com.iftube.service;

import java.util.List;

import br.com.iftube.exception.service.ServiceException;
import br.com.iftube.model.entities.Curso;

public interface CursoService {

	public Curso adicionar(Curso curso) throws ServiceException;
	public Curso editar(Curso curso) throws ServiceException;
	//public Curso desabilitarHabilitar(Curso curso);
	public void deletar(Curso curso);
	public Curso obterCursoPorId(int cursoId);
	public Curso obterCursoPorNome(String nomeCurso);
	public Curso alterarEstadoCurso(int id, String estadoCurso);
	@SuppressWarnings("rawtypes")
	public List obterTodosCurso();

	
}
