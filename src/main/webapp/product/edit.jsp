<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>$Title$</title>
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="plugins/fontawesome-free/css/all.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
    <!-- Tempusdominus Bootstrap 4 -->
    <link rel="stylesheet" href="plugins/tempusdominus-bootstrap-4/css/tempusdominus-bootstrap-4.min.css">
    <!-- iCheck -->
    <link rel="stylesheet" href="plugins/icheck-bootstrap/icheck-bootstrap.min.css">
    <!-- JQVMap -->
    <link rel="stylesheet" href="plugins/jqvmap/jqvmap.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="dist/css/adminlte.min.css">
    <!-- overlayScrollbars -->
    <link rel="stylesheet" href="plugins/overlayScrollbars/css/OverlayScrollbars.min.css">
    <!-- Daterange picker -->
    <link rel="stylesheet" href="plugins/daterangepicker/daterangepicker.css">
    <!-- summernote -->
    <link rel="stylesheet" href="plugins/summernote/summernote-bs4.min.css">
<body>
<div class="container">
    <h1 style="text-align:center">Edit product</h1>
    <form action="/products?action=edit&id=${product.id}" method="post">
        <div class="mb-3">
            <label for="name" class="form-label">Product name</label>
            <input name="name" type="text" class="form-control" id="name" value="${product.name}">
        </div>
        <div class="mb-3">
            <label for="price" class="form-label">Product price</label>
            <input name="price" type="text" class="form-control" id="price" value="${product.price}">
        </div>
        <div class="mb-3">
            <label for="quantity" class="form-label">Product quantity</label>
            <input name="quantity" type="text" class="form-control" id="quantity" value="${product.quantity}">
        </div>
        <div class="mb-3">
            <label for="color" class="form-label">Product color</label>
            <input name="color" type="text" class="form-control" id="color" value="${product.color}">
        </div>
        <div class="mb-3">
            <label for="description" class="form-label">Description</label>
            <input name="description" type="text" class="form-control" id="description" value="${product.description}">
        </div>
        <div class="mb-3">
            <label for="category" class="form-label">Category</label>
            <select class="form-control" id="category" name="categoryId">
<%--                <option selected value="${product.categoryName}">${category.name}</option>--%>
<%--                <c:forEach var="category" items="${categories}">--%>
<%--                    <option value="${category.name}">${category.name}</option>--%>
<%--                </c:forEach>--%>
                <c:forEach var="category" items="${categories}">
                    <c:choose>
                        <c:when test="${category.id  == product.categoryId}">
                            <option value="${category.id}" selected>${category.name}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${category.id}">${category.name}</option>
                        </c:otherwise>
                    </c:choose>

                </c:forEach>
            </select>
        </div>
        <button type="submit" class="btn btn-success">Update</button>
        <a href="/products">
            <button type="button" value="back" class="btn btn-secondary">Back</button>
        </a>
    </form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>

</body>
</html>
