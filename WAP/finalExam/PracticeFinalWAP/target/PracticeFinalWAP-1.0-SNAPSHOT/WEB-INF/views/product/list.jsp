<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
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
    <title>Product Page</title>
</head>
<body>
<%@ include file="/WEB-INF/fragments/header.jsp" %>

<div class="container">
    <br>
<h1>List of products</h1>

<table id="productTable" class="table table-striped">
    <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">ProductId</th>
            <th scope="col">Name</th>
            <th scope="col">Unit Price</th>
            <th scope="col">Quantity</th>
            <th scope="col">Supplier</th>
            <th scope="col">Date Supplied</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach varStatus="status" var="p" items="${productsData}">
            <tr>
                <td><c:out value="${status.index + 1}"> </c:out></td>
                <td>${p.productId}</td>
                <td>${p.name}</td>
                <td>${p.unitPrice}</td>
                <td>${p.qty}</td>
                <td>${p.supplier.name}</td>
                <td>${p.dateSupplied}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</div>
<%@ include file="/WEB-INF/fragments/footer.jsp" %>

</body>
</html>