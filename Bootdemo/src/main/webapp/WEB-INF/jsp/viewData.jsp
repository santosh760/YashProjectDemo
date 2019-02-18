<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Excel Data</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<script
	src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="https://cdn.datatables.net/1.10.19/js/dataTables.bootstrap4.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.19/css/dataTables.bootstrap4.min.css">
	
<script>
$(document).ready(function() {
    $('#uploadTable').DataTable({
    	"pagingType": "full_numbers",
    	"lengthMenu": [[10, 50, 100, -1], [10, 50, 100, "All"]]
    });
} );
</script>
</head>
<body>
	<div align="center">
		<div class="col-md-12" style="overflow-x: auto">
			<%-- <table border="1" cellpadding="5">
				<c:forEach items="${excelData}" var="steps">
					<tr>
						<c:forEach items="${steps}" var="step">
							<td style="text-align: left;"><c:out value="${step} " /></td>
						</c:forEach>
					</tr>
				</c:forEach>
			</table> --%>
			<table id="uploadTable" class="table table-hover table-primary" style="overflow-y: auto">
				<thead>
					<c:forEach items="${excelData}" end="0" var="steps">
						<tr>
							<c:forEach items="${steps}" var="step">
								<th scope="col"><c:out value="${step} " /></th>
							</c:forEach>
						</tr>
					</c:forEach>
				</thead>
				<tbody class=" table-secondary">
					<c:forEach items="${excelData}" begin="1" var="steps">
						<tr>
							<c:forEach items="${steps}" end="0" var="step">
								<th scope="col"><c:out value="${step} " /></th>
							</c:forEach>
							<c:forEach items="${steps}" begin="1" var="step">
								<td><c:out value="${step} " /></td>
							</c:forEach>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<br> <br> <a href="/">Back</a>
	</div>
</body>
</html>