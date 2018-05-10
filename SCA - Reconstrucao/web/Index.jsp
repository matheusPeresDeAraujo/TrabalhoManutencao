<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu</title>
    </head>
    <body>
        <a href="FrontController?action=PesquisarCurso">Manter Cursos</a> </br>
        <a href="FrontController?action=PesquisarDisciplina&filtro=0">Manter Disciplinas</a> </br>
        <a href="FrontController?action=PesquisarProfessor">Manter Professores</a> </br>
        <a href="FrontController?action=PesquisarAluno">Manter Alunos</a> </br>
        <a href="FrontController?action=PesquisarTurma">Manter Turmas</a><br/>
        ---<br/>
        <a href="FrontController?action=PesquisarMatrizCurricular&acao=prepararOperacao">Consultar Matriz Curricular</a> <br />
        <a href="FrontController?action=PesquisarProfessorPorCurso&acao=prepararOperacao"> Consultar Professores Vinculados a cada Curso</a> <br />
        <a href="FrontController?action=PesquisarNotaFrequencia&acao=prepararOperacao"> Manter Nota e Frequência</a> <br />
        <a href=""> Calcular Resultado de Rendimento do Aluno</a> <br />
        --- Relatórios ---<br/>
        <a href="FrontController?action=RelatorioCursos&acao=prepararOperacao">Relatório de Cursos</a></br>
        <a href="FrontController?action=RelatorioProfessor&acao=prepararOperacao">Relatório de Professores Por Titulação</a></br>
        <a href="FrontController?action=RelatorioDisciplinaPorCurso&acao=prepararOperacao">Relatório de Disciplina Por Cursos</a></br>
        <a href="FrontController?action=RelatorioAlunoAnoSemestre&acao=prepararOperacao">Relatório de Aluno Ano/Semestre</a></br>
        <a href="FrontController?action=RelatorioDiarioDeClasse&acao=prepararOperacao">Diário de Classe</a></br>
        <a href="FrontController?action=ReatorioHistoricoAluno&acao=prepararOperacao">Historico</a></br>
    </body>
</html>
