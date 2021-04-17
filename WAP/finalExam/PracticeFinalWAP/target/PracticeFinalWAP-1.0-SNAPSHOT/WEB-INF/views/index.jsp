<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <style>
        /* Remove the navbar's default margin-bottom and rounded borders */
        .navbar {
            margin-bottom: 0;
            border-radius: 0;
        }

        /* Add a gray background color and some padding to the footer */
        footer {
            background-color: #f2f2f2;
            position: fixed;
            bottom: 0;
            width: 100%;
            height: 30px;
            line-height: 30px;
        }
    </style>
    <title>Practice Final WAP</title>
</head>
<body>
<%@include file="../fragments/header.jsp" %>


<div class="container">
    <div class="jumbotron">
        <div class="container">
            <h1>Welcome to Final Practice WAP</h1>
            <hr>
        </div>
    </div>
</div>

<%@include file="../fragments/footer.jsp"%>

</body>
</html>