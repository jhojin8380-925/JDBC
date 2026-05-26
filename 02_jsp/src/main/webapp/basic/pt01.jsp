<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구구구단</title>
</head>
<body>

<h1>구구구단</h1>

<form method="get">
    단 입력 :
    <input type="number" name="dan">
    <button type="submit">출력</button>
</form>

<hr>

<%
String danStr = request.getParameter("dan");

if(danStr != null) {

    int dan = Integer.parseInt(danStr);

    for(int i = 1; i <= 9; i++) {

        for(int j = 1; j <= 9; j++) {
%>

            <p>
                <%= dan %> x <%= i %> x <%= j %>
                =
                <%= dan * i * j %>
            </p>

<%
        }
    }
}
%>

</body>
</html>