DROP TABLE IF EXISTS CURSO;

CREATE TABLE CURSO(
	ID_CURSO NUMBER,
	NOMBRE NVARCHAR2(50),
	DURACION_HORAS NVARCHAR2(50),
	CONSTRAINT ID_CURSO_PK PRIMARY KEY (ID_CURSO)
);