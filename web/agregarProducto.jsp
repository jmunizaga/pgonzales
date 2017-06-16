<%@page import="clases.Producto"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PGonzales - Evaluación II</title>
        <style>
            .lista table, .lista td, .lista tr{
                border: 1px solid black;
            }
        </style>
    </head>
    <body>
        <%
            if (request.getAttribute("listaProductos") == null) {
        %>
        <jsp:forward page="AdminProducto?jspname=agregarProducto" />
        <%
            }
        %>
        <header>
            <h1>Agregar Productos</h1>
        </header>
        <div>
            <form action="AdminProducto" method="POST">
                <input type="hidden" name="accion" value="agregar">
                <input type="hidden" name="jspname" value="agregarProducto">
                <table>
                    <tr>
                        <td>ID Producto</td><td><input type="text" name="id" maxlength="10" required></td>
                    </tr>
                    <tr>
                        <td>Nombre</td><td><input type="text" name="nombre" maxlength="50" required></td>
                    </tr>
                    <tr>
                        <td>Precio</td><td><input type="number" name="precio" maxlength="6" required></td>
                    </tr>
                    <tr>
                        <td>Descripción</td><td><textarea name="descripcion" rows="10" cols="30" required></textarea></td>
                    </tr>
                    <tr>
                        <td>Fecha Elaboración</td><td><input type="date" name="elaboracion" required></td>
                    </tr>
                    <tr>
                        <td><button>Enviar</button></td>
                    </tr>
                </table>
            </form>
        </div>
        <br>
        <div class="lista">
            <table>
                <thead>
                <td>
                    ID Producto
                </td>
                <td>
                    Nombre
                </td>
                <td>
                    Precio
                </td>
                <td>
                    Descripción
                </td>
                <td>
                    Fecha Elaboración
                </td>
                </thead>
                <c:forEach items="${listaProductos}" var="producto">
                    <tr>
                        <td>
                            <c:out value="${producto.getIdProducto()}"/>
                        </td>
                        <td>
                            <c:out value="${producto.getNombreProducto()}"/>
                        </td>
                        <td>
                            $<c:out value="${producto.getValorProducto()}"/>
                        </td> 
                        <td>
                            <c:out value="${producto.getDescripcionProducto()}"/>
                        </td>  
                        <td>
                            <c:out value="${producto.getFechaElaboracion()}"/>
                        </td>  
                    </tr>
                </c:forEach>
            </table>
        </div>
        <br>
        <footer>
            <a href="index.html">Volver atrás</a>
        </footer>
    </body>
</html>
