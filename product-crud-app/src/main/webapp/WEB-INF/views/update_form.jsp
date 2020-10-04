<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="./base.jsp"%>
<style type="text/css">
        body {
            background-image: url('https://images.wallpaperscraft.com/image/keyboard_telephone_desktop_179668_3840x2160.jpg');
            height: 100%;
            background-size: cover;
        }
</style>
</head>
<body #body-bg>

	<h1 class="container text-center" style="color: white;">Update The Product Details</h1>

	<div class="container mt-3">

		<div class="row">

			<div class="col-md-6 offset-md-3">

				<form action="${ pageContext.request.contextPath }/handle-product"
					method="post">

					<input type="hidden" value="${ product.id }" name="id">

					<div class="form-group">
						<label for="name" style="color: white;">Product Name</label> <input type="text"
							class="form-control" id="name" name="name"
							aria-describedby="emailHelp"
							placeholder="Enter the Product name here"
							value="${ product.name }">
					</div>

					<div class="form-group">

						<label for="description" style="color: white;">Product Description</label>
						<textarea class="form-control" name="description" id="description"
							rows="5" placeholder="Enter the Product description here">${ product.description }</textarea>
					</div>


					<div class="form-group">
						<label for="price" style="color: white;">Product Price</label> <input type="text"
							class="form-control" id="price" name="price"
							placeholder="Enter the Product Price" value="${ product.price }">
					</div>

					<div class="container text-center">
						<a href="${ pageContext.request.contextPath }/"
							class="btn btn-outline-danger">Back</a>
						<button type="submit" class="btn btn-warning">Update</button>
					</div>
				</form>

			</div>

		</div>

	</div>

</body>
</html>