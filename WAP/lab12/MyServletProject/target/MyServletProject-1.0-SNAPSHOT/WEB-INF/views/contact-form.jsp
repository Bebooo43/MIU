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
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Customer Contact App</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <style>
        /* Remove the navbar's default margin-bottom and rounded borders */s
        .navbar {
            margin-bottom: 0;
            border-radius: 0;
        }
        s
            /* Add a gray background color and some padding to the footer */
        footer {
            background-color: #f2f2f2; s

        bottom: 0;
            width: 100%;
            height: 30px;
            line-height: 30px;
        }
    </style>
</head>
<body>

<%@include file="../fragments/header.jsp"%>

<div class="container">
    <div class="row justify-content-center">
        <div class="col-lg-8">

            <c:if test="${contact.customerName.isEmpty()}"><span style="color: red;">Name is missing.</span><br></c:if>
            <c:if test="${contact.gender.isEmpty()}"><span style="color: red;">Gender is missing.</span><br></c:if>
            <c:if test="${contact.category.isEmpty()}"><span style="color: red;">Category is missing.</span><br></c:if>
            <c:if test="${contact.message.isEmpty()}"><span style="color: red;">Message is missing.</span><br></c:if>

            <form method="POST" action="contact-form">
                <div class="form-group">
                    <h1>Customer Contact Form</h1>
                </div>
                <div class="form-group">
                    <label for="nameId" class="">*Name:</label>
                    <input type="text" class="form-control" id="nameId" name="nameId" placeholder="e.g. John Smith">
                    <small class="form-text text-muted">Enter your full name.</small>
                </div>

                <div class="form-group">
                    <label for="nameId" class="control-label">*Gender:</label>
                    <div class="input-group">
                        <div class="form-check form-check-inline">
                            <label class="radio inline" for="genderMale">
                                <input type="radio" name="gender" id="genderMale" value="Male"> Male</label>
                        </div>
                        <div class="form-check form-check-inline">
                            <label class="radio inline" for="genderFemale">
                                <input type="radio" name="gender" id="genderFemale" value="Female"> Female</label>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label for="category" class="">*Category:</label>
                    <select class="form-control" id="category" name="category">
                        <option value="" selected>Select...</option>
                        <option value="Feedback">Feedback</option>
                        <option value="Inquiry">Inquiry</option>
                        <option value="Complaint">Complaint</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="message" class="">*Message:</label>
                    <textarea class="form-control" id="message" name="message" rows="3"></textarea>
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary btn-block">Submit</button>
                </div>
            </form>
            <div>
                <span class="text-muted">Hit Count for this page: <c:out value="${contactHit}" /></span>
                <span class="text-muted" style="float: right;">Total Hit Count for entire WebApp: <c:out value="${totalHitCountApp}"/></span>
            </div>
        </div>
    </div>
</div>

<%@include file="../fragments/footer.jsp"%>

</body>
</html>
