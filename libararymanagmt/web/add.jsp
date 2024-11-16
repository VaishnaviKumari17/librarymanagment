<%-- 
    Document   : add
    Created on : 3 Nov, 2024, 6:27:15 PM
    Author     : vaishnavi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="add" method="POST">
           id: <input type="number" name="bookid"><br>
           Book-Name:<input tpye="text" name="bookname"><br>
            Author-Name:<input type="text" name="authorname"><br>
            Book-catgry:<input type="text" name="catgry"><br>
            <input type="submit" value="submit">
            
        </form>
    </body>
</html>