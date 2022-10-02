<%-- 
    Document   : viewnote
    Created on : 2-Oct-2022, 12:54:02 PM
    Author     : marce
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Simple Note Keeper</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h2>View Note</h2>
        <form action="note" method="post">
            <p>
                <b>Title:</b>
                ${note.title}
            </p>
            <p>
                <b>Contents:</b>
                <br>
                ${note.contents}
            </p>
            <a href="note?edit">Edit</a>
        </form>
    </body>
</html>