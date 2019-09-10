----EJERCICIOS
-- SOLO ES REQUERIDO REALIZAR LOS EJERCICIOS DE COMPLEJIDAD BAJA, realizar los demas ejercicios serán puntos extras para la evaluación del examen.


--- EJERCICIO 1 - COMPLEJIDAD BAJA: 
--Realizar una consulta para consultar todos los alumnos existentes, mostrar: TipoDoc, Documento, Nombre, Apellido, Legajo.
SELECT P.tipodoc, 
       P.documento, 
       P.nombre, 
       P.apellido, 
       A.legajo 
FROM   alumno A 
       INNER JOIN persona P 
               ON A.identificador = P.identificador; 


--- EJERCICIO 2 - COMPLEJIDAD BAJA: 
--Realizar una consulta para consultar todas las carreras a la que un alumno esta inscripto, mostrar: Legajo, nombre, apellido, nombre carrera, fechainscripcioncarrera
--ordenado por legajo descendiente
SELECT A.legajo, 
       P.nombre, 
       P.apellido, 
       C.nombre, 
       IC.fechainscripcion 
FROM   alumno A 
       INNER JOIN persona P 
               ON P.identificador = A.identificador 
       INNER JOIN inscripciones_carrera IC 
               ON IC.idalumno = A.identificador 
       INNER JOIN carrera C 
               ON C.identificador = IC.idcarrera 
ORDER  BY A.legajo DESC;

--- EJERCICIO 3 - COMPLEJIDAD MEDIA: 
--Realizar una consulta para consultar la cantidad de inscriptos por curso, mostrando: nombre carrera, nombre curso, cantidad inscriptos, cupo máximo por curso
SELECT DISTINCT C.nombre, 
                CU.nombre, 
                Count(ICU.idalumno) AS Cantidad_inscriptos, 
                CU.cupomaximo 
FROM   inscripciones_curso ICU 
       INNER JOIN curso CU 
               ON ICU.idcurso = CU.identificador 
       INNER JOIN carrera C 
               ON C.identificador = CU.idcarrera 
GROUP  BY C.nombre, 
          CU.nombre, 
          cu.cupomaximo; 

--- EJERCICIO 4 - COMPLEJIDAD ALTA: 
--Sobre la consulta anterior (copiar y pegarla y modificarla) modificar la sql para que la consulta retorne solo los cursos cuya cantidad de inscripciones 
--supera su cupo maximo
SELECT DISTINCT C.nombre, 
                CU.nombre, 
                Count(ICU.idalumno) AS Cantidad_inscriptos, 
                CU.cupomaximo 
FROM   inscripciones_curso ICU 
       INNER JOIN curso CU 
               ON ICU.idcurso = CU.identificador 
       INNER JOIN carrera C 
               ON C.identificador = CU.idcarrera 
GROUP  BY C.nombre, 
          CU.nombre, 
          cu.cupomaximo
          HAVING Count(ICU.idalumno) > CU.cupomaximo; 


--- EJERCICIO 5 -  COMPLEJIDAD BAJA: 
-- actualizar todos las cursos que posean anio 2018 y cuyo cupo sea menor a 5, y actualizar el cupo de todos ellos a 10.
UPDATE curso C 
SET    cupomaximo = 10 
WHERE  C.anio = 2018 
       AND C.cupomaximo < 5;

--- EJERCICIO 6 -  COMPLEJIDAD ALTA: 
-- actualizar todas las fechas de inscripcion a cursados que posean el siguiente error: la fecha de inscripcion al cursado de un 
-- alumno es menor a la fecha de inscripcion a la carrera. La nueva fecha que debe tener es la fecha del dia. Se puede hacer en dos pasos, primero
-- realizando la consulta y luego realizando el update manual
SELECT ICU.fechainscripcion, 
       ICU.idalumno, 
       ICU.idcurso 
FROM   inscripciones_curso ICU 
       INNER JOIN alumno A 
               ON A.identificador = ICU.idalumno 
       INNER JOIN inscripciones_carrera IC 
               ON IC.idalumno = A.identificador 
WHERE  ICU.fechainscripcion < IC.fechainscripcion; 
UPDATE inscripciones_curso 
SET    fechainscripcion = CURRENT_DATE 
WHERE  inscripciones_curso.idalumno = 2 
       AND inscripciones_curso.idcurso = 3; 


--- EJERCICIO 7 - COMPLEJIDAD BAJA:  
--INSERTAR un nuevo registro de alumno con tus datos personales, (hacer todos inserts que considera necesario)
INSERT INTO persona VALUES
    (6,'DNI', 32411050, 'Nicolas', 'Chichi', '1986-07-30');
INSERT INTO alumno VALUES
    (6,6, 15487544);
INSERT INTO inscripciones_carrera VALUES
   (6,1,'2019-09-09');

--- EJERCICIO 8 -  COMPLEJIDAD BAJA: 
-- si se desea comenzar a persistir de ahora en mas el dato de direccion de un alumno y considerando que este es un único cambio string de 200 caracteres.
-- Determine sobre que tabla seria mas conveniente persistir esta información y realizar la modificación de estructuras correspondientes.
ALTER TABLE persona
ADD COLUMN direccion VARCHAR (200);

