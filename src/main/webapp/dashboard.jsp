<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.model.User" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.model.User" %>
<%@ page import="com.example.dao.UserDAO" %>
<%
    User user = (User) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("index.jsp");
        return;
    }
    
    UserDAO userDAO = new UserDAO();
    List<User> users = userDAO.getAllUsers();
    
%>
<html>
<head>
    <title>Dashboard</title>
</head>
<body>
   <!-- mensaje de bienveniuda -->
    <h2>Bienvenido, <%= user.getUsername() %></h2>
    <a href="logout.jsp">Cerrar Sesión</a>
    
    
    <br>
    
     <div class="container mt-5">
        <h2 class="text-center">Gestión de Usuarios</h2>
        
        <table class="table table-bordered mt-3">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Username</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <% for (User user2 : users) { %>
                    <tr>
                        <td><%= user2.getId() %></td>
                        <td><%= user2.getUsername() %></td>
                        <td>
                            <a href="UserServlet?action=edit&id=<%= user2.getId() %>" class="btn btn-warning btn-sm">Editar</a>
                            <a href="UserServlet?action=delete&id=<%= user2.getId() %>" class="btn btn-danger btn-sm" onclick="return confirm('¿Estás seguro de eliminar este usuario?');">Eliminar</a>
                        </td>
                    </tr>
                <% } %>
            </tbody>
        </table>
        
        <a href="register.jsp" class="btn btn-success">Insertar Usuario</a>
    </div>
    
</body>
</html>
