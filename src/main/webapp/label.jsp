<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>List of Songs</title>
</head>
<body>
<h1>List of Songs</h1>

<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Labels</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${baiHatList}" var="Song">
        <tr>
            <td>${Song.id}</td>
            <td>${Song.ten}</td>
            <td>${Song.nhans}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<h2>Add New Song</h2>

<form action="" method="post">
    <label for="songName">Song Name:</label>
    <input type="text" id="songName" name="songName" required>

    <label for="labels">Labels:</label>
    <input type="text" id="labels" name="labels" required>
    <button type="submit">Add Song</button>
</form>
</body>
</html>
