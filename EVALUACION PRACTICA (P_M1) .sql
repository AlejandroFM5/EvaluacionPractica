CREATE TABLE PROFESOR (
  ID_PROFESOR NUMBER PRIMARY KEY,
  NOMBRE VARCHAR2(50),
  ESPECIALIDAD VARCHAR2(50)
);

CREATE TABLE MATERIA_1 (
  ID_MATERIA NUMBER PRIMARY KEY,
  NOMBRE VARCHAR2(50),
  ID_PROFESOR NUMBER,
  FOREIGN KEY (ID_PROFESOR) REFERENCES profesor(ID_PROFESOR)
);

--Inserta al menos 3 profesores y 5 materias (al menos 2 materias deben ser del mismo profesor).
INSERT INTO PROFESOR VALUES(1 ,'Denzel Crocker','Matematicas');
INSERT INTO PROFESOR VALUES(2 ,'Sra. Puff','Manejo');
INSERT INTO PROFESOR VALUES(3 ,'Profesor Utonio','Biologia');
INSERT INTO PROFESOR VALUES(4 ,'Profesor Oak','Ciencias Naturales');
INSERT INTO PROFESOR VALUES(5 ,'Profesor Utonio','Quimica');

INSERT INTO MATERIA_1 VALUES(1,'Matematicas',1);
INSERT INTO MATERIA_1 VALUES(2,'Manejo',2);
INSERT INTO MATERIA_1 VALUES(3,'Biologia',3);
INSERT INTO MATERIA_1 VALUES(4,'Quimica',3);
INSERT INTO MATERIA_1 VALUES(5,'Ciencias Naturales',4);

--Escribe una consulta SQL que devuelva el nombre de la materia junto con el nombre del profesor que la imparte.

SELECT M.NOMBRE, P.NOMBRE FROM MATERIA_1 M
INNER JOIN PROFESOR P ON P.ID_PROFESOR = M.ID_PROFESOR
WHERE ID_MATERIA IS NOT NULL;


--Escribe otra consulta que muestre cuántas materias tiene cada profesor.

SELECT COUNT(M.NOMBRE)AS MATERIAS_TOTALES, P.NOMBRE FROM MATERIA_1 M
INNER JOIN PROFESOR P ON P.ID_PROFESOR = M.ID_PROFESOR
GROUP BY P.NOMBRE;

