<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> <%-- PARA HACER FOREACH --%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> <%-- FECHAS --%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %> <%-- PARA INCLUIR IMAGENES --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bienvenido a CineApp</title>
<spring:url value="/resources" var="urlPublic"></spring:url>
<link rel="stylesheet"
	href="${urlPublic }/bootstrap/css/bootstrap.min.css" >

</head>
<body> 
	<%-- 
	<h2>Lista de Peliculas</h2>
	
	<ul>
		<c:forEach items="${peliculas }" var="pelicula">
			<li> ${pelicula}</li>
		</c:forEach>
	</ul>
	--%>
	<div class="panel panel-default">
		<div class="panel-heading">Lista de Peliculas</div>
		<div class="panel-body">
			<table class="table table-striped table-bordered table-hover">
				<thead>
					<tr>
						<th>Id</th>
						<th>Titulo</th>
						<th>Duracion</th>
						<th>Clasificacion</th>
						<th>Genero</th>
						<th>imagen</th>
						<th>Fecha Estreno</th>
						<th>Status</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${peliculas }" var="pelicula">
						<tr>
							<td>${pelicula.id }</td>
							<td>${pelicula.titulo}</td>
							<td>${pelicula.duracion }min.</td>
							<td>${pelicula.calificacion}</td>
							<td>${pelicula.genero}</td>
							<td><img src="${urlPublic}/images/${pelicula.imagen}" width="80" height="100"></td>
							<td><fmt:formatDate value="${pelicula.fechaEstado}" pattern="dd-MM-yyyy"/></td>
							<td>
							<c:choose>
								<c:when test="${pelicula.estatus=='Activa'}">
									<span class="badge badge-success">Activa</span>
								</c:when>
								<c:otherwise>
									<span class="badge badge-danger">Inactiva</span>
								</c:otherwise>
							</c:choose>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>


</body>
</html>