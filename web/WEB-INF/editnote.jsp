<%-- 
    Document   : editnote
    Created on : 2-Oct-2022, 1:01:18 PM
    Author     : marce
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" contents="text/html; charset=UTF-8">
        <title>Simple Note Keeper</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h2>Edit Note</h2>
        <form action="note" method="post">
            <label>Title:</label>
            <input type="text" name="title" value="${note.title}">
            <br>

            <label>Contents:</label>
            <textarea name="contents" cols="30" rows="5">${note.contents}</textarea>
            <br>

            <input type="submit" value="Save">
            <p>${message}</p>
        </form>
    </body>
</html>