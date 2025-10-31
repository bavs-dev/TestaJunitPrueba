<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.example.model.User" %>
<%
    User user = (User) request.getAttribute("user");
    boolean isEditing = (user != null);
%>
<!DOCTYPE html>
<html>
<head>
    <title><%= isEditing ? "Editar Usuario" : "Registrar Usuario" %></title>
</head>
<body>
    <h2><%= isEditing ? "Editar Usuario" : "Registrar Nuevo Usuario" %></h2>

    <form action="UserServlet" method="post">
        <% if (isEditing) { %>
            <input type="hidden" name="id" value="<%= user.getId() %>">
        <% } %>

        <label>Nombre de usuario:</label>
        <input type="text" name="username" value="<%= isEditing ? user.getUsername() : "" %>" required>
        <br>

        <label>Contraseña:</label>
        <input type="password" name="password" required>
        <br>

        <button type="submit"><%= isEditing ? "Actualizar" : "Registrar" %></button>
    </form>

    <a href="dashboard.jsp">Volver a la lista</a>
</body>
</html>
