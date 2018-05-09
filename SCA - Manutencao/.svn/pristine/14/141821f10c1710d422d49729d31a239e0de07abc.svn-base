-- phpMyAdmin SQL Dump
-- version 3.4.5
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tempo de Geração: 07/03/2013 às 16h36min
-- Versão do Servidor: 5.5.16
-- Versão do PHP: 5.3.8

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Banco de Dados: `sca`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `aluno`
--

CREATE TABLE IF NOT EXISTS `aluno` (
  `matricula` int(11) NOT NULL,
  `nome` varchar(80) DEFAULT NULL,
  `dtNascimento` date DEFAULT NULL,
  `endLogradouro` varchar(60) DEFAULT NULL,
  `endNumero` int(11) DEFAULT NULL,
  `endComplemento` varchar(10) DEFAULT NULL,
  `endBairro` varchar(35) DEFAULT NULL,
  `endCEP` varchar(15) DEFAULT NULL,
  `endCidade` varchar(45) DEFAULT NULL,
  `endEstado` varchar(45) DEFAULT NULL,
  `rg` varchar(15) DEFAULT NULL,
  `cpf` varchar(20) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `anoIngresso` int(11) DEFAULT NULL,
  `semestreIngresso` int(11) DEFAULT NULL,
  `status` varchar(25) DEFAULT NULL,
  `posicaoVestibular` int(11) DEFAULT NULL,
  `codCurso` int(11) DEFAULT NULL,
  PRIMARY KEY (`matricula`),
  KEY `fk_Aluno_Curso_idx` (`codCurso`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `aluno`
--

INSERT INTO `aluno` (`matricula`, `nome`, `dtNascimento`, `endLogradouro`, `endNumero`, `endComplemento`, `endBairro`, `endCEP`, `endCidade`, `endEstado`, `rg`, `cpf`, `email`, `anoIngresso`, `semestreIngresso`, `status`, `posicaoVestibular`, `codCurso`) VALUES
(3, 'Heleno de Souza  Junior', '2000-02-01', '', 123, '3041', 'sao pedro', '36033-290', 'Juiz de Fora', 'MG', '16487858', '116.744.286-50', 'heleno_scj@hotmail.com', 2013, 1, 'trancado', 1, 2122),
(311, 'Rogerio', '1999-03-10', 'Rua B', 123, '3041', 'lalalal', '36033-290', 'Juiz de Fora', 'MG', '16487858', '116.744.286-50', 'heleno_scj@hotmail.com', 2013, 1, 'matriculado', 1, 1),
(1311, 'vania rabelo campos', '2013-03-07', '', 0, '', '', '', '', '', '', '', '', 2013, 1, 'matriculado', 1, 1),
(12111, 'Matheus', '1992-01-09', 'Rua Olegario', 10, '3041', 'sao pedro', '36033-290', 'Juiz de Fora', 'MS', '16487858', '59917716672', 'heleno_scj@hotmail.com', 2013, 1, 'matriculado', 1, 2122),
(130101, 'Diego Peres LourenÃ§o', '2013-03-07', '', 0, '', '', '36016140', 'Juiz de Fora', 'MG', '', '', '', 2013, 1, 'matriculado', 1, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `avaliacao`
--

CREATE TABLE IF NOT EXISTS `avaliacao` (
  `matriculaAluno` int(11) NOT NULL,
  `codTurma` int(11) NOT NULL,
  `nota1` float DEFAULT NULL,
  `nota2` float DEFAULT NULL,
  `numFaltas` int(11) DEFAULT NULL,
  `notaProvaFinal` float DEFAULT NULL,
  PRIMARY KEY (`matriculaAluno`,`codTurma`),
  KEY `fk_Avaliacao_Turma1_idx` (`codTurma`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `curso`
--

CREATE TABLE IF NOT EXISTS `curso` (
  `codCurso` int(11) NOT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `cargaHoraria` int(11) DEFAULT NULL,
  `tipoCurso` varchar(45) DEFAULT NULL,
  `totalPeriodos` int(11) DEFAULT NULL,
  `professorCoordenador` int(11) DEFAULT NULL,
  PRIMARY KEY (`codCurso`),
  KEY `fk_Curso_Professor1_idx` (`professorCoordenador`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `curso`
--

INSERT INTO `curso` (`codCurso`, `nome`, `cargaHoraria`, `tipoCurso`, `totalPeriodos`, `professorCoordenador`) VALUES
(1, 'BACHARELADO SI', 1, 'superior', 23, NULL),
(2122, 'Edificacoes', 29, 'tecnicoIntegrado', 9, 4),
(120232, 'Curso Teste II', 4, 'doutorado', 15, 4);

-- --------------------------------------------------------

--
-- Estrutura da tabela `disciplina`
--

CREATE TABLE IF NOT EXISTS `disciplina` (
  `codDisciplina` int(11) NOT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `ementa` text,
  `periodo` int(11) DEFAULT NULL,
  `qtdeCreditos` int(11) DEFAULT NULL,
  `codCurso` int(11) DEFAULT NULL,
  PRIMARY KEY (`codDisciplina`),
  KEY `fk_Disciplina_Curso1_idx` (`codCurso`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `disciplina`
--

INSERT INTO `disciplina` (`codDisciplina`, `nome`, `ementa`, `periodo`, `qtdeCreditos`, `codCurso`) VALUES
(1, 'disciplina teste', 'varias materias', 1, 4, 1),
(2, '21', '                           \r\n         1231               ', 1, 12, 1),
(5, '5555', '12321321                           \r\n                        ', 1, 12, 1),
(10, '4', 'sss', 4, 4, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `horario`
--

CREATE TABLE IF NOT EXISTS `horario` (
  `codHorario` int(11) NOT NULL AUTO_INCREMENT,
  `diaSemana` int(11) DEFAULT NULL,
  `horarioInicio` varchar(15) DEFAULT NULL,
  `codTurma` int(11) NOT NULL,
  PRIMARY KEY (`codHorario`),
  KEY `fk_Horario_Turma1_idx` (`codTurma`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `prerequisito`
--

CREATE TABLE IF NOT EXISTS `prerequisito` (
  `codDisciplinaPreRequisito` int(11) NOT NULL,
  `codDisciplinaPreRequisitada` int(11) NOT NULL,
  PRIMARY KEY (`codDisciplinaPreRequisito`,`codDisciplinaPreRequisitada`),
  KEY `fk_PreRequisito_Disciplina2_idx` (`codDisciplinaPreRequisitada`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `prerequisito`
--

INSERT INTO `prerequisito` (`codDisciplinaPreRequisito`, `codDisciplinaPreRequisitada`) VALUES
(10, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `professor`
--

CREATE TABLE IF NOT EXISTS `professor` (
  `matricula` int(11) NOT NULL,
  `nome` varchar(80) DEFAULT NULL,
  `dtNascimento` date DEFAULT NULL,
  `endLogradouro` varchar(60) DEFAULT NULL,
  `endNumero` int(11) DEFAULT NULL,
  `endComplemento` varchar(10) DEFAULT NULL,
  `endBairro` varchar(45) DEFAULT NULL,
  `endCEP` varchar(20) DEFAULT NULL,
  `endCidade` varchar(45) DEFAULT NULL,
  `endEstado` varchar(25) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `dtIngresso` date DEFAULT NULL,
  `titulacao` varchar(45) DEFAULT NULL,
  `cursoAtuacao` int(11) DEFAULT NULL,
  PRIMARY KEY (`matricula`),
  KEY `fk_Professor_Curso1_idx` (`cursoAtuacao`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `professor`
--

INSERT INTO `professor` (`matricula`, `nome`, `dtNascimento`, `endLogradouro`, `endNumero`, `endComplemento`, `endBairro`, `endCEP`, `endCidade`, `endEstado`, `email`, `dtIngresso`, `titulacao`, `cursoAtuacao`) VALUES
(2, 'Diego Peres Lourenco', '2000-01-01', 'adsa', 264, 'Paineiras', 'Cascatinha', '36016140', 'Juiz de Fora', 'MG', 'heleno_scj@hotmail.com', '2000-01-01', 'graduacao', 1),
(4, 'Veronica Castro', '2000-01-01', 'Rua Olegario', 1935, '4012', 'Paineiras', '23021-001', 'juiz de fora', 'MG', 'veronica.castro.9.7@gmail.com', '2000-01-01', 'doutorado', 1),
(5, 'Heleno de Souza Campos Junior', '1992-12-09', 'Rua B', 123, '304', 'sao pedro', '36033-290', 'Juiz de Fora', 'MG', 'heleno_scj@hotmail.com', '2013-04-10', 'graduacao', 120232);

-- --------------------------------------------------------

--
-- Estrutura da tabela `turma`
--

CREATE TABLE IF NOT EXISTS `turma` (
  `codTurma` int(11) NOT NULL,
  `semestre` int(11) DEFAULT NULL,
  `ano` int(11) DEFAULT NULL,
  `numVagas` int(11) DEFAULT NULL,
  `numSala` varchar(25) DEFAULT NULL,
  `codDisciplina` int(11) NOT NULL,
  `matriculaProfessor` int(11) NOT NULL,
  PRIMARY KEY (`codTurma`),
  KEY `fk_Turma_Disciplina1_idx` (`codDisciplina`),
  KEY `fk_Turma_Professor1_idx` (`matriculaProfessor`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Restrições para as tabelas dumpadas
--

--
-- Restrições para a tabela `aluno`
--
ALTER TABLE `aluno`
  ADD CONSTRAINT `fk_Aluno_Curso` FOREIGN KEY (`codCurso`) REFERENCES `curso` (`codCurso`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Restrições para a tabela `avaliacao`
--
ALTER TABLE `avaliacao`
  ADD CONSTRAINT `fk_Avaliacao_Aluno1` FOREIGN KEY (`matriculaAluno`) REFERENCES `aluno` (`matricula`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Avaliacao_Turma1` FOREIGN KEY (`codTurma`) REFERENCES `turma` (`codTurma`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Restrições para a tabela `curso`
--
ALTER TABLE `curso`
  ADD CONSTRAINT `fk_Curso_Professor1` FOREIGN KEY (`professorCoordenador`) REFERENCES `professor` (`matricula`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Restrições para a tabela `disciplina`
--
ALTER TABLE `disciplina`
  ADD CONSTRAINT `fk_Disciplina_Curso1` FOREIGN KEY (`codCurso`) REFERENCES `curso` (`codCurso`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Restrições para a tabela `horario`
--
ALTER TABLE `horario`
  ADD CONSTRAINT `fk_Horario_Turma1` FOREIGN KEY (`codTurma`) REFERENCES `turma` (`codTurma`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Restrições para a tabela `prerequisito`
--
ALTER TABLE `prerequisito`
  ADD CONSTRAINT `fk_PreRequisito_Disciplina1` FOREIGN KEY (`codDisciplinaPreRequisito`) REFERENCES `disciplina` (`codDisciplina`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_PreRequisito_Disciplina2` FOREIGN KEY (`codDisciplinaPreRequisitada`) REFERENCES `disciplina` (`codDisciplina`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Restrições para a tabela `professor`
--
ALTER TABLE `professor`
  ADD CONSTRAINT `fk_Professor_Curso1` FOREIGN KEY (`cursoAtuacao`) REFERENCES `curso` (`codCurso`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Restrições para a tabela `turma`
--
ALTER TABLE `turma`
  ADD CONSTRAINT `fk_Turma_Disciplina1` FOREIGN KEY (`codDisciplina`) REFERENCES `disciplina` (`codDisciplina`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Turma_Professor1` FOREIGN KEY (`matriculaProfessor`) REFERENCES `professor` (`matricula`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
