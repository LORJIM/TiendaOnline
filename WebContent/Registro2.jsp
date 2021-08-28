
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<link rel="StyleSheet" href="css/Style3.css" type="text/css" />

<style type="text/css">
.cabeceraFormulario {
font-family: Verdana, Arial, Helvetica, sans-serif;
font-size: 18px;
font-weight: bold;
color: #FFFFFF;
background-color: #333333;
}

.textoObligatorios {
font-family: Verdana, Arial, Helvetica, sans-serif;
font-size: 10px;
font-weight: bold;
color: #FF0000;
}

.etiquetaDeCampo {
font-family: Verdana, Arial, Helvetica, sans-serif;
font-size: 12px;
color: #000000;
background-color: #CFEFEF;
}

.textoSeleccionable {
font-family: Verdana, Arial, Helvetica, sans-serif;
font-size: 12px;
color: #000000;
background-color: #FFFF99;
}

.lineaBlanca {
font-family: Verdana;
font-size: 5px;
color: #FFFFFF;
background-color: #EEEEEE;
}
.botonNegativo {
color: #FFFFFF;
background-color: #FF0000;
border: outset 2px;
}

.botonPositivo {
color: #FFFFFF;
background-color: #339900;
border: outset 2px;
}
</style>
<script src="JS/Registro.js"></script>

</HEAD>
<BODY>
<FORM name="miFormulario" action="hola.jsp">
<TABLE WIDTH="650" HEIGHT="400" BORDER="0">
<TR>
<TD WIDTH="300" ALIGN="right">&nbsp;</TD>
<TD WIDTH="350" colspan="3" ALIGN="center"
class="cabeceraFormulario">REGISTRO DE USUARIOS</TD>
<TD WIDTH="150" ALIGN="left">&nbsp;</TD>
</TR>
<TR class="lineaBlanca">
<TD WIDTH="300" ALIGN="right">&nbsp;</TD>
<TD WIDTH="350" ALIGN="left">&nbsp;</TD>
<TD WIDTH="50" ALIGN="center">&nbsp;</TD>
<TD WIDTH="150" ALIGN="right">&nbsp;</TD>
<TD WIDTH="150" ALIGN="left">&nbsp;</TD>
</TR>
<TR>
<TD WIDTH="300" ALIGN="right">&nbsp;</TD>
<TD WIDTH="550" ALIGN="center" colspan="3"
class="textoObligatorios ">Los campos marcados con (*) son
obligatorios</TD>
<TD WIDTH="150" ALIGN="left">&nbsp;</TD>
</TR>
<TR class="lineaBlanca">
<TD WIDTH="300" ALIGN="right">&nbsp;</TD>
<TD WIDTH="350" ALIGN="left">&nbsp;</TD>
<TD WIDTH="50" ALIGN="center">&nbsp;</TD>
<TD WIDTH="150" ALIGN="right">&nbsp;</TD>
<TD WIDTH="150" ALIGN="left">&nbsp;</TD>
</TR>

<TR>
<TD WIDTH="300" ALIGN="right" class="etiquetaDeCampo">(*)Nombre</TD>
<TD WIDTH="350" ALIGN="left"><input type="text"
name="campoNombre" size="20" value="juan"></TD>
<TD WIDTH="50" ALIGN="center">&nbsp;</TD>
<TD WIDTH="150" ALIGN="right" class="etiquetaDeCampo">(*)Apellidos</TD>
<TD WIDTH="150" ALIGN="left"><input type="text"
name="campoApellidos" size="20" value="López Rodríguez"></TD>
</TR>
<TR>
<TD WIDTH="300" ALIGN="right" class="etiquetaDeCampo">Teléfono
<BR> (xxxxxxxxx)
</TD>
<TD WIDTH="350" ALIGN="left"><input type="text"
name="campoTelefono" size="20" value="915556666"
onBlur="comprobarFormatoTelefono();"></TD>
<TD WIDTH="50" ALIGN="center">&nbsp;</TD>
<TD WIDTH="150" ALIGN="right" class="etiquetaDeCampo">Móvil <BR>
(xxxxxxxxx)
</TD>
<TD WIDTH="150" ALIGN="left"><input type="text"
name="campoMovil" size="20" value="677555666"
onBlur="comprobarFormatoMovil();"></TD>
</TR>
<TR>
<TD WIDTH="300" ALIGN="right" class="etiquetaDeCampo">(*)Contraseña</TD>
<TD WIDTH="350" ALIGN="left"><input type="password"
name="campoContrasena" size="20" value="unaclave"></TD>
<TD WIDTH="50" ALIGN="center">&nbsp;</TD>
<TD WIDTH="150" ALIGN="right" class="etiquetaDeCampo">(*)Repetición<BR>
Contraseña
</TD>
<TD WIDTH="150" ALIGN="left"><input type="password"
name="campoContrasenaRepetida" size="20" value="unaclave">
</TD>
</TR>
<TR class="lineaBlanca">
<TD WIDTH="300" ALIGN="right">&nbsp;</TD>
<TD WIDTH="350" ALIGN="left">&nbsp;</TD>
<TD WIDTH="50" ALIGN="center">&nbsp;</TD>
<TD WIDTH="150" ALIGN="right">&nbsp;</TD>
<TD WIDTH="150" ALIGN="left">&nbsp;</TD>
</TR>
<TR>
<TD WIDTH="300" ALIGN="right">&nbsp;</TD>
<TD WIDTH="350" ALIGN="right" class="etiquetaDeCampo">Ocupación
laboral</TD>
<TD WIDTH="50" ALIGN="center"><input type="radio"
name="opcionOcupacion" checked
value="Cuenta Ajena - Jornada completa"></TD>
<TD WIDTH="150" ALIGN="left" class="textoSeleccionable">Cuenta
Ajena<BR> Jornada completa
</TD>
<TD WIDTH="150" ALIGN="left">&nbsp;</TD>
</TR>
<TR>
<TD WIDTH="300" ALIGN="right">&nbsp;</TD>
<TD WIDTH="350" ALIGN="center">&nbsp;</TD>
<TD WIDTH="50" ALIGN="center"><input type="radio"
name="opcionOcupacion" value="Cuenta Ajena - Media jornada">
</TD>
<TD WIDTH="150" ALIGN="left" class="textoSeleccionable">Cuenta
Ajena<BR> Media jornada
</TD>
<TD WIDTH="150" ALIGN="left">&nbsp;</TD>
</TR>

<TR>
<TD WIDTH="300" ALIGN="right">&nbsp;</TD>
<TD WIDTH="350" ALIGN="right">&nbsp;</TD>
<TD WIDTH="50" ALIGN="center"><input type="radio"
name="opcionOcupacion" value="Cuenta Propia"></TD>
<TD WIDTH="150" ALIGN="left" class="textoSeleccionable">Cuenta
Propia</TD>
<TD WIDTH="150" ALIGN="left">&nbsp;</TD>
</TR>
<TR>
<TD WIDTH="300" ALIGN="right">&nbsp;</TD>
<TD WIDTH="350" ALIGN="right">&nbsp;</TD>
<TD WIDTH="50" ALIGN="center"><input type="radio"
name="opcionOcupacion" value="Desempleado"></TD>
<TD WIDTH="150" ALIGN="left" class="textoSeleccionable">Desempleado</TD>
<TD WIDTH="150" ALIGN="left">&nbsp;</TD>
</TR>
<TR class="lineaBlanca">
<TD WIDTH="300" ALIGN="right">&nbsp;</TD>
<TD WIDTH="350" ALIGN="left">&nbsp;</TD>
<TD WIDTH="50" ALIGN="center">&nbsp;</TD>
<TD WIDTH="150" ALIGN="right">&nbsp;</TD>
<TD WIDTH="150" ALIGN="left">&nbsp;</TD>
</TR>
<TR>
<TD WIDTH="300" ALIGN="right" class="etiquetaDeCampo">Años de
experiencia</TD>
<TD WIDTH="350" ALIGN="left"><SELECT name="experiencia"
class="textoSeleccionable">
<OPTION value="01" SELECTED>menos de 1 año</OPTION>
<OPTION value="02">entre 1 y 2 años</OPTION>
<OPTION value="03">entre 2 y 4 años</OPTION>
<OPTION value="04">entre 4 y 7 años</OPTION>
<OPTION value="05">más de 7 años</OPTION>
</SELECT></TD>
<TD WIDTH="50" ALIGN="center">&nbsp;</TD>
<TD colspan="2" ALIGN="center" class="etiquetaDeCampo">TecnologíasConocidas</TD>
</TR>
<TR>
<TD WIDTH="300" ALIGN="right" class="etiquetaDeCampo">Aficiones</TD>
<TD WIDTH="350" ALIGN="left">&nbsp;</TD>
<TD WIDTH="50" ALIGN="center">&nbsp;</TD>
<TD WIDTH="150" ALIGN="right"><input type="checkbox"
name="t_html"></TD>
<TD WIDTH="150" ALIGN="left" class="textoSeleccionable">HTML</TD>
</TR>
<TR>
<TD WIDTH="300" ALIGN="left" colspan="2"><TEXTAREA cols="34"
rows="3" name='aficiones'></TEXTAREA></TD>
<TD WIDTH="50" ALIGN="center">&nbsp;</TD>
<TD WIDTH="150" ALIGN="right"><input type="checkbox"
name="t_css"></TD>
<TD WIDTH="150" ALIGN="left" class="textoSeleccionable">CSS</TD>
</TR>
<TR>
<TD WIDTH="300" ALIGN="right">&nbsp;</TD>
<TD WIDTH="350" ALIGN="left">&nbsp;</TD>
<TD WIDTH="50" ALIGN="center">&nbsp;</TD>
<TD WIDTH="150" ALIGN="right"><input type="checkbox"
name="t_javascript"></TD>
<TD WIDTH="150" ALIGN="left" class="textoSeleccionable">JavaScript</TD>
</TR>

<TR class="lineaBlanca">
<TD WIDTH="300" ALIGN="right">&nbsp;</TD>
<TD WIDTH="350" ALIGN="left">&nbsp;</TD>
<TD WIDTH="50" ALIGN="center">&nbsp;</TD>
<TD WIDTH="150" ALIGN="right">&nbsp;</TD>
<TD WIDTH="150" ALIGN="left">&nbsp;</TD>
</TR>
<TR>
<TD WIDTH="300" ALIGN="right"><input type="button"
class="botonNegativo" value="Reiniciar"
onClick="reiniciarFormulario();"></TD>
<TD WIDTH="350" ALIGN="left">&nbsp;</TD>
<TD WIDTH="50" ALIGN="center">&nbsp;</TD>
<TD WIDTH="150" ALIGN="right">&nbsp;</TD>
<TD WIDTH="150" ALIGN="left">
<input type="submit"
class="botonPositivo" value="Enviar datos"
onClick="return validarFormulario();"></TD>
</TR>
</TABLE>
</FORM>
</BODY>

</html>