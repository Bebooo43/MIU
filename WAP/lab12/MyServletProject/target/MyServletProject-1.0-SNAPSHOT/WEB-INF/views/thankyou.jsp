<%--
  Created by IntelliJ IDEA.
  User: jmsvs
  Date: 4/12/2021
  Time: 10:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>CS472-WAP Lab 12</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <style>
        /* Remove the navbar's default margin-bottom and rounded borders */s
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
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
    <a class="navbar-brand" href="/home">CS472 ::: Lab 12</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
</nav>

<div class="container">
    <div class="row justify-content-center">
        <div class="col-lg-8">
            <br><br>
            <p style="text-align: right;" class="text-muted"><c:out value="${LocalDate.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL))}"/></p>
            <div id="accordion">
                <div class="card">
                    <div class="card-header" >
                        <h5 class="mb-0">
                            Thank you! your message has been received as follows:
                        </h5>
                    </div>

                    <div class="collapse show" aria-labelledby="headingOne" data-parent="#accordion">
                        <div class="card-body">
                            <strong>Name: </strong><span class="text-muted"><c:out value="${contact.customerName}" /></span><br>
                            <strong>Gender: </strong><span class="text-muted"><c:out value="${contact.gender}" /></span><br>
                            <strong>Category: </strong><span class="text-muted"><c:out value="${contact.category}" /></span><br>
                            <strong>Message: </strong><span class="text-muted"><c:out value="${contact.message}" /></span>

                            <br><br>
                            Please feel free to <a href="contact-form">Contact Us</a> again
                        </div>
                    </div>
                </div>
            </div>
            <div>
                <span class="text-muted">Hit Count for this page: <c:out value="${thankYouHit}" /></span>
                <span class="text-muted" style="float: right;">Total Hit Count for entire WebApp: <c:out value="${totalHitCountApp}"/> </span>
            </div>
        </div>
    </div>
</div>

<%@include file="../fragments/footer.jsp"%>

</body>
</html>
