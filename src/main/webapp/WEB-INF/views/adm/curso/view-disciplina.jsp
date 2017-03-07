<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


	<h1>IFTube - Adm</h1>
	<hr>
	<h3>Visualizar - Disciplina</h3>
	<hr>

	ID:
	<input type="text" readonly="readonly" value="${disciplina.id}"><br/>
	Curso:<input type="text" readonly="readonly" value="${disciplina.idCursoFk.nomeCurso}">
	<br /> Disciplina:
	<input type="text" readonly="readonly"
		value="${disciplina.nomeDisciplina}">
	<br /> Período:
	<input type="text" readonly="readonly" value="${disciplina.periodo}">
	<input type="hidden" value="${disciplina.estadoDisciplina}">
	
	<br /> Tags:
	<input type="text" readonly="readonly" value="${palavraChave.tag}">
	<br />
	<hr>
	<a href="home"><button>Voltar</button></a>
	<a href="exibirPaginaAlterar?id=${c.id}"><button>Alterar</button></a>
	<a href="delete?id=${c.id}"><button>Desabilitar</button></a>
	<hr>

</body>
</html>