<%-- 
    Document   : display
    Created on : 5 Feb 2020, 15:19:49
    Author     : SAF
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Using Forms</title>
    </head>
    <body>
        <h1>Using Forms!</h1>
        <% 
            String firstName = request.getParameter("first");
            String lastName = request.getParameter("last");
            String email = request.getParameter("email");
            String gender = request.getParameter("gender");
            String dob = request.getParameter("dob");
        %>
        <table border="1">
            <tbody>
                <tr>
                    <td>First Name : </td>
                    <td><%= firstName %></td>
                </tr>
                <tr>
                    <td>Last Name : </td>
                    <td><%= lastName %></td>
                </tr>
                <tr>
                    <td>Email Address: </td>
                    <td><%= email %></td>
                </tr>
                <tr>
                    <td>Gender : </td>
                    <td><%= gender %></td>
                </tr>
                <tr>
                    <td>Date of Birth : </td>
                    <td><%= dob %></td>
                </tr>
            </tbody>
        </table>

    </body>
</html>
