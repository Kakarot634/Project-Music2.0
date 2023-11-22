<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.example.testing2.Model.Playlist" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
</head>
<body>
<h1>New Playlists</h1>
<% List<Playlist> newPlaylists = (List<Playlist>) request.getAttribute("newPlaylists"); %>
<ul>
    <% for (Playlist playlist : newPlaylists) { %>
    <li><a href="playlistDetails?playlistId=<%= playlist.getId() %>"><%= playlist.getName() %></a></li>
    <% } %>
</ul>
</body>
</html>