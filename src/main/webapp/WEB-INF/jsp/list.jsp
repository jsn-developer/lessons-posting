<%@ page pageEncoding="UTF-8" %>
<%@ page import="jp.co.solxyz.lessons.posting.entity.PostEntity,java.util.List"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>一覧</title>
    <link rel="stylesheet" href="./css/bootstrap.min.css">
    <link rel="stylesheet" href="./css/app.css">
    <script src="./js/jquery-3.4.1.min.js"></script>
    <script src="./js/bootstrap.bundle.js"></script>
</head>
<body>
	<%

		List<PostEntity> list = (List<PostEntity>)request.getAttribute("list");

	%>

    <nav class="navbar fixed-top navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="#">投稿一覧</a>
    </nav>
    <div class="container">
        <div class="row">

        	<%
			for ( PostEntity item : list) {
			%>
           	<div class="col-sm-12 col-md-8 offset-md-2 item">
                <div class='card' style='background-image: url("./image?id=<%=item.getId()%>"); background-position: center center; background-size: cover;'>
                    <p>
                        <%=item.getContent() %>
                    </p>
                </div>

            </div>
			<% } %>
        </div>
    </div>
    <a class="action" href="./post">
        <span>+</span>
    </a>
</body>
</html>
