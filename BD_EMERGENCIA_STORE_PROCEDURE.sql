USE [BD_EMERGENCIA]
GO
/****** Propietario: Luigi Aguirre ******/
/****** Objetivo: Este store permite simular el ingreso diario de los recursos ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[sp_ingresoRecursoPorDia]
    @DNI CHAR(8)
AS
BEGIN

		DECLARE @HORASISTEMA TIME
		SELECT @HORASISTEMA = SYSDATETIME()
		DECLARE @HORATURNO TIME
		SELECT @HORATURNO = TUR_HORA_INICIAL FROM TURNO WHERE TUR_ID = 3
		DECLARE @FECHAACTUAL DATETIME;
		SELECT @FECHAACTUAL = convert(varchar(10),getdate(),101)

		IF (NOT EXISTS(
				SELECT *
					   FROM RECURSO_ESTADO T1
					    INNER JOIN RECURSO T2
						 ON T1.REC_ID = T2.REC_ID
						INNER JOIN PERSONA T3
						 ON T2.PER_ID = T3.PER_ID
						WHERE T3.PER_DNI = @DNI AND
						 convert(varchar(10),T1.REE_FECHA,101) = @FECHAACTUAL))

		BEGIN
			IF (@HORASISTEMA > @HORATURNO OR @HORASISTEMA > '00:00' AND @HORASISTEMA < = '06:00')
				INSERT INTO 
					RECURSO_ESTADO (REC_ID,EST_ID)
				SELECT  T1.REC_ID,1
					FROM RECURSO T1
					 INNER JOIN PERSONA T2
					  ON T1.PER_ID = T2.PER_ID
					 INNER JOIN TURNO T3
					  ON T1.TUR_ID = T3.TUR_ID
				WHERE T3.TUR_ID = 3 AND
					  T2.PER_DNI = @DNI AND
					  T1.ESTADO_REGISTRO = 1
			ELSE
				INSERT INTO 
					RECURSO_ESTADO (REC_ID,EST_ID)
				SELECT  T1.REC_ID,1
					FROM RECURSO T1
					 INNER JOIN PERSONA T2
					  ON T1.PER_ID = T2.PER_ID
					 INNER JOIN TURNO T3
					  ON T1.TUR_ID = T3.TUR_ID
				WHERE @HORASISTEMA BETWEEN 
					  T3.TUR_HORA_INICIAL AND 
					  T3.TUR_HORA_FINAL AND
					  T2.PER_DNI = @DNI AND
					  T1.ESTADO_REGISTRO = 1
		END
		
END

GO

/****** Propietario: Maria Cristina de Loayza ******/
/****** Objetivo: Este store permite realizar el registro de los recursos en las tablas USUARIO, PERSONA y RECURSO ******/

CREATE PROCEDURE sp_registrarRecurso
	@nombre nvarchar(50),
	@apePat nvarchar(50),
	@apeMat nvarchar(50),
	@fNac datetime,
	@dni char(8),
	@direccion nvarchar(100),
	@correo nvarchar(100),
	@telefono nvarchar(20),
	@genero char(1),
	@estadoCivil nvarchar(15),
	@nombreUsuario nvarchar(50),
	@clave nvarchar(50),
	@rol int,
	@grado int,
	@tuno int,
	@comisaria int
AS
BEGIN
	BEGIN TRAN

		BEGIN TRY

			INSERT INTO USUARIO (ROL_ID,USU_NOMBRE,USU_CLAVE,ESTADO_REGISTRO,FECHA_CREACION)
			VALUES (@rol,@nombreUsuario,@clave,1,GETDATE())

			INSERT INTO PERSONA (USU_ID,TPE_ID,PER_NOMBRE,PER_APELLIDO_PATERNO,PER_APELLIDO_MATERNO,PER_FECHA_NACIMIENTO,
								 PER_DNI,PER_DIRECCION,PER_CORREO,PER_TELEFONO,PER_GENERO,PER_ESTADO_CIVIL,ESTADO_REGISTRO,FECHA_CREACION)
			VALUES (@@IDENTITY,2,@nombre,@apePat,@apeMat,@fNac,@dni,@direccion,@correo,@telefono,@genero,@estadoCivil,1,GETDATE())

			INSERT INTO RECURSO (PER_ID,GRE_ID,TUR_ID,COM_ID,ESTADO_REGISTRO,FECHA_CREACION)
			VALUES (@@IDENTITY,@grado,@tuno,@comisaria,1,GETDATE())

		COMMIT TRAN

	END TRY

	BEGIN CATCH
		ROLLBACK TRAN
	END CATCH
END

GO

/****** Propietario: Maria Cristina de Loayza ******/
/****** Objetivo: Este store permite realizar el registro de los operadores en las tablas USUARIO, PERSONA y OPERADOR ******/

CREATE PROCEDURE sp_registrarOperador
@nombre nvarchar(50),
@apePat nvarchar(50),
@apeMat nvarchar(50),
@fNac datetime,
@dni char(8),
@direccion nvarchar(100),
@correo nvarchar(100),
@telefono nvarchar(20),
@genero char(1),
@estadoCivil nvarchar(15),
@nombreUsuario nvarchar(50),
@clave nvarchar(50),
@rol int,
@turno int
AS
BEGIN
	BEGIN TRAN
		BEGIN TRY
			INSERT INTO USUARIO (ROL_ID,USU_NOMBRE,USU_CLAVE,ESTADO_REGISTRO,FECHA_CREACION)
			VALUES (@rol,@nombreUsuario,@clave,1,GETDATE())

			INSERT INTO PERSONA (USU_ID,TPE_ID,PER_NOMBRE,PER_APELLIDO_PATERNO,PER_APELLIDO_MATERNO,PER_FECHA_NACIMIENTO,
									PER_DNI,PER_DIRECCION,PER_CORREO,PER_TELEFONO,PER_GENERO,PER_ESTADO_CIVIL,ESTADO_REGISTRO,FECHA_CREACION)
			VALUES (@@IDENTITY,2,@nombre,@apePat,@apeMat,@fNac,@dni,@direccion,@correo,@telefono,@genero,@estadoCivil,1,GETDATE())

			INSERT INTO OPERADOR (TUR_ID,PER_ID,ESTADO_REGISTRO,FECHA_CREACION)
			VALUES (@turno,@@IDENTITY,1,GETDATE())

		END TRY
	BEGIN CATCH
		ROLLBACK TRAN
	END CATCH
END

GO

/****** Propietario: Sergio Muroy ******/
/****** Objetivo: Este store permite realizar el registro de las emergencias registrándolo de la siguiente manera
 *                si el civil no da ningun, no se crea un nuevo civil y a la llamada se le inserta el civil 1(Desonocido)  ******/

CREATE PROCEDURE USP_REGISTRAR_EMERGENCIA
	@CIV_DOCUMENTO NVARCHAR(12),
	@CIV_NOMBRE NVARCHAR(50),
	@CIV_APELLIDO_PATERNO NVARCHAR(50),
	@CIV_APELLIDO_MATERNO NVARCHAR(50),
	@CIV_TELEFONO NVARCHAR(20),
	@FECHA_REGISTRO DATETIME,
	@LLA_FECHA DATETIME,
	@LLA_OBSERVACION NVARCHAR(500),
	@LLA_TELEFONO NVARCHAR(20),
	@TTE_ID INT,
	@OPE_ID INT,
	@LLA_HORA_INICIO TIME(0),
	@LLA_HORA_FIN TIME(0),
	@NEM_ID INT,
	@TEM_ID INT,
	@DIS_ID INT,
	@EME_DIR NVARCHAR(100),
	@EME_OBSERVACION NVARCHAR(500),
	@EME_FECHA DATETIME,
	@EME_HORA_INICIO TIME(0),
	@EME_HORA_FIN TIME(0)
AS
BEGIN TRAN
	BEGIN TRY
		IF ('' = @CIV_DOCUMENTO AND '' = @CIV_NOMBRE AND ''= @CIV_APELLIDO_PATERNO AND '' = @CIV_APELLIDO_MATERNO AND NULL = @CIV_TELEFONO )
			BEGIN
				INSERT INTO LLAMADA(LLA_FECHA,LLA_OBSERVACION,LLA_TELEFONO,TTE_ID,CIV_ID,OPE_ID,LLA_HORA_INICIO,LLA_HORA_FIN) 
				VALUES (@LLA_FECHA,@LLA_OBSERVACION,@LLA_TELEFONO,@TTE_ID,1,@OPE_ID,@LLA_HORA_INICIO,@LLA_HORA_FIN) --CIVIL DESCONOCIDO CUANDO TODO ES VACIO
		
				INSERT INTO EMERGENCIA(NEM_ID,LLA_ID,TEM_ID,DIS_ID,EME_DIR,EME_OBSERVACION,EME_FECHA,EME_HORA_INICIO,EME_HORA_FIN)
				VALUES (@NEM_ID,@@IDENTITY,@TEM_ID,@DIS_ID,@EME_DIR,@EME_OBSERVACION,@EME_FECHA,@EME_HORA_INICIO,@EME_HORA_FIN)
			END
		ELSE
			BEGIN
				INSERT INTO CIVIL(CIV_NOMBRE,CIV_APELLIDO_PATERNO,CIV_APELLIDO_MATERNO,CIV_TELEFONO,CIV_DOCUMENTO,FECHA_REGISTRO)
				VALUES (@CIV_NOMBRE,@CIV_APELLIDO_PATERNO,@CIV_APELLIDO_MATERNO,@CIV_TELEFONO,@CIV_DOCUMENTO,@FECHA_REGISTRO)
		
				INSERT INTO LLAMADA(LLA_FECHA,LLA_OBSERVACION,LLA_TELEFONO,TTE_ID,CIV_ID,OPE_ID,LLA_HORA_INICIO,LLA_HORA_FIN) 
				VALUES (@LLA_FECHA,@LLA_OBSERVACION,@LLA_TELEFONO,@TTE_ID,@@IDENTITY,@OPE_ID,@LLA_HORA_INICIO,@LLA_HORA_FIN)
		
				INSERT INTO EMERGENCIA(NEM_ID,LLA_ID,TEM_ID,DIS_ID,EME_DIR,EME_OBSERVACION,EME_FECHA,EME_HORA_INICIO,EME_HORA_FIN)
				VALUES (@NEM_ID,@@IDENTITY,@TEM_ID,@DIS_ID,@EME_DIR,@EME_OBSERVACION,@EME_FECHA,@EME_HORA_INICIO,@EME_HORA_FIN)
			END
	END TRY
	BEGIN CATCH
		ROLLBACK TRAN
	END CATCH
GO

alter procedure sp_editarRecurso
@codRecurso int,
@codPersona int,
@codUsuario INT,
@nombre nvarchar(50),
@apePat nvarchar(50),
@apeMat nvarchar(50),
@fNac datetime,
@direccion nvarchar(100),
@correo nvarchar(100),
@telefono nvarchar(20),
@genero char(1),
@estadoCivil nvarchar(15),
@nombreUsuario nvarchar(50),
@clave nvarchar(50),
@rol int,
@grado int,
@tuno int,
@comisaria int
as
begin
	BEGIN TRAN
		BEGIN TRY
			
			UPDATE USUARIO SET ROL_ID = @rol,FECHA_MODIFICACION = GETDATE() WHERE USU_ID = @codUsuario

			UPDATE PERSONA SET PER_NOMBRE = @nombre , PER_APELLIDO_MATERNO = @apeMat , PER_APELLIDO_PATERNO = @apePat,
								PER_FECHA_NACIMIENTO = @fNac , PER_DIRECCION= @direccion , PER_CORREO = @correo,PER_TELEFONO = @telefono,
								PER_GENERO = @genero , PER_ESTADO_CIVIL = @estadoCivil,FECHA_MODIFICACION = GETDATE()
							WHERE PER_ID = @codPersona

			UPDATE RECURSO SET GRE_ID =@grado , TUR_ID=@tuno ,COM_ID = @comisaria,FECHA_MODIFICACION = GETDATE()
							WHERE REC_ID = @codRecurso 
		
			COMMIT TRAN
		END TRY
		BEGIN CATCH
			ROLLBACK TRAN
		END CATCH
end

select * from PERSONA
select * from recurso

ALTER procedure sp_editarOperador
@codOperador int,
@codPersona int,
@codUsuario INT,
@nombre nvarchar(50),
@apePat nvarchar(50),
@apeMat nvarchar(50),
@fNac datetime,
@direccion nvarchar(100),
@correo nvarchar(100),
@telefono nvarchar(20),
@genero char(1),
@estadoCivil nvarchar(15),
@clave nvarchar(50),
@rol int,
@turno int
as
begin
	BEGIN TRAN
		BEGIN TRY
			
			UPDATE USUARIO SET ROL_ID = @rol,FECHA_MODIFICACION = GETDATE() WHERE USU_ID = @codOperador

			UPDATE PERSONA SET PER_NOMBRE = @nombre , PER_APELLIDO_MATERNO = @apeMat , PER_APELLIDO_PATERNO = @apePat,
								PER_FECHA_NACIMIENTO = @fNac , PER_DIRECCION= @direccion , PER_CORREO = @correo,PER_TELEFONO = @telefono,
								PER_GENERO = @genero , PER_ESTADO_CIVIL = @estadoCivil,FECHA_MODIFICACION = GETDATE()
							WHERE PER_ID = @codPersona

			UPDATE OPERADOR SET TUR_ID = @turno , FECHA_MODIFICACION = GETDATE() where OPE_ID = @codOperador
		
			COMMIT TRAN
		END TRY
		BEGIN CATCH
			ROLLBACK TRAN
		END CATCH
end


