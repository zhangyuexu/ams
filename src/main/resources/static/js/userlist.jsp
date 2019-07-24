<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/js/common/tag.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>error_type列表</title>
<%@include file="/js/common/head.jsp"%>
</head>
<body>
	<div class="container">
		<div class="panel panel-default">
			<div class="panel-heading text-center">
				<h2>error_type列表</h2>
			</div>
			<div class="panel-body">
				<table class="table table-hover">
					<thead>
						<tr>
							<td>ID</td>
							<td>error_type</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="errtypes" items="${errortypes}">
							<tr>
								<td>${errtypes.id}</td>
								<td>${errtypes.error_type}</td>

								<!--<td><fmt:formatDate value="${user.createTime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>-->

							</tr>
						</c:forEach>
					</tbody>
				</table>

			</div>
		</div>
	</div>
</body>
</html>