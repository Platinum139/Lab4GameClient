<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Game</title>
    </head>
    <body>
        <h1>Play game!</h1>
        
        <form action="GameServlet" method="post">
            <table>
                <tr>
                    <td>Min value</td>
                    <td><input type="number" name="minval" value="0"></td>
                </tr>
                <tr>
                    <td>Max value</td>
                    <td><input type="number" name="maxval" value="10"></td>
                </tr>
                <tr>
                    <td>Try number</td>
                    <td><input type="number" name="trynum"></td>
                </tr>
            </table>
            
            <input type="submit" name="guess" value="Guess">
        </form>
    </body>
</html>
