<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- bring the random number in to use -->


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- local JS -->
<script type="text/javascript" src="js/app.js"></script>
<!-- Bootstrap JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<title>NinjaGoldGame</title>
</head>

<body>

	<div class="container">
		<div class="header">
			<h3>
				Your Gold: <span class="border border-5"> <c:out value="${ score }" />
				</span>
			</h3>
			
		</div>
		<div class="body d-flex justify-content-around p-5 text-center">
			<form action="/farm" method="post" class="form-control">
				<h3>Farm</h3>
				<p>(earns 10-20 gold)</p>
													<!-- min + (int) (Math.random() * (Max - Min) + 1 -->
				<input type="hidden" name="farm" value="<%= 10 + (int) (Math.random() * (20 - 10) + 1) %>" /> <input type="submit"
					value="Find Gold!" class="btn btn-secondary">
			</form>

			<form action="/cave" method="post" class="form-control">
				<h3>Cave</h3>
				<p>(earns 5-10 gold)</p>
				<input type="hidden" name="cave" value="<%= 5 + (int) (Math.random() * (10 - 5) + 1) %>" /> <input type="submit"
					value="Find Gold!" class="btn btn-secondary">

			</form>

			<form action="/house" method="post" class="form-control">
				<h3>House</h3>
				<p>(earns 2-5 gold)</p>
				<input type="hidden" name="house" value="<%= 2 + (int) (Math.random() * (5 - 2) + 1) %>" /> <input
					type="submit" value="Find Gold!" class="btn btn-secondary">

			</form>

			<form action="/casino" method="post" class="form-control">
				<h3>Casino!</h3>
				<p>(earns/takes 0 - 50 gold)</p>
				<input type="hidden" name="casino" value="<%= (-50) + (int) (Math.random() * (50 - (-50)) + 1) %>" /> <input
					type="submit" value="Find Gold!" class="btn btn-secondary">

			</form>
		</div>
		<h1>Activities:</h1>
		<footer class="overflow-auto p-3 border border-5" style="width: auto; height: 300px">
<%-- 			<c:foreach var="message" items="${ messages }">
			</c:foreach> --%>
			${ message }
		</footer>
	</div>

</body>
</html>