<%-- 
    Document   : index
    Created on : 23 oct 2022, 1:50:47
    Author     : yoc91
--%>
<%@page import="javax.swing.table.DefaultTableModel"%>
<%@page import="controlador.api_empleado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="estilos.css">
        
        <title>JSP Page</title>
        <link href="https://fonts.googleapis.com/css2?family=Bebas+Neue&family=Open+Sans:wght@400;600&display=swap" rel="stylesheet"> 
        
        <style>
            
        </style>
    </head>
    <body>
        <header>
               
            
		<div class="contenedor">
			<h2 class="logotipo">Programación II</h2>
			<h2 class="logotipo">Formulario Empleados</h2>
			<nav>
				<a href="#" class="activo">Inicio</a>
				<a href="#">Programas</a>
				<a href="#">Películas</a>
				<a href="#">Más Recientes</a>
				<a href="#">Mi lista</a>
			</nav>
		</div>
	</header>

	<main>
		<div class="pelicula-principal">
			<div class="contenedor">
				<h3 class="titulo">Información</h3>
				<table class="tabla">
                                <thead>
                                  <tr>
                                    <th>Nombres</th>
                                    <th>Apellidos</th>
                                    <th>Direccion</th>
                                    <th>Telefono</th>
                                    <th>IdPuesto</th>
                                    <th>DPI</th>
                                    <th>Nacimiento</th>
                                    <th>Ingreso</th>
                                  </tr>
                                </thead>
                                <tbody>
                                   <% 
                                    api_empleado api_c =  new api_empleado();
                                    DefaultTableModel tabla = new DefaultTableModel();
                                    tabla = api_c.leer();
                                    for (int t=0;t<tabla.getRowCount();t++){
                                        out.println("<tr data-id="+ tabla.getValueAt(t, 0) + ">");
                                        out.println("<td>"+ tabla.getValueAt(t, 1) +"</td>");
                                        out.println("<td>"+ tabla.getValueAt(t, 2) +"</td>");
                                        out.println("<td>"+ tabla.getValueAt(t, 3) +"</td>");
                                        out.println("<td>"+ tabla.getValueAt(t, 4) +"</td>");
                                        out.println("<td>"+ tabla.getValueAt(t, 5) +"</td>");
                                        out.println("<td>"+ tabla.getValueAt(t, 6) +"</td>");
                                        out.println("<td>"+ tabla.getValueAt(t, 7) +"</td>");
                                        out.println("<td>"+ tabla.getValueAt(t, 8) +"</td>");
                                        out.println("</tr>");
                                                }
                                    %>     
                                </tbody>
                                </table>
				<button role="banner" class="boton"><i class="fa-solid fa-file"></i>Agregar</button>
				<button role="button" class="boton"><i class="fa-solid fa-gears"></i>Modificar</button>
				<button role="button" class="boton"><i class="fa-solid fa-rectangle-xmark"></i>Eliminar</button>
			</div>
		</div>

		
	</main>
	<script src="https://kit.fontawesome.com/c70663fc08.js" crossorigin="anonymous"></script>
	<script src="https://kit.fontawesome.com/2c36e9b7b1.js" crossorigin="anonymous"></script>
	<script src="main.js"></script>
        <script src="js/bootstrap.min.js"></script>
        
    </body>
</html>
