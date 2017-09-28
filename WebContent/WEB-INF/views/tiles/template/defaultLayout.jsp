<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE>
<html>

<head>
<META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE">
<!-- Script and css setup -->
<script src= "https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.2.0.min.js" ></script>
<link href="<c:url value="asr/css/amistiMain.css" />" rel="stylesheet">
<script src="<c:url value="asr/scripts/amistiMain.js" />"></script>
<script src="<c:url value="" />"> </script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>

<body class="amistiHtml">

	<div id="m_header">
		<tiles:insertAttribute name="header" />
	</div>

	<div id="center_con">

		<div id="m_left">
			<tiles:insertAttribute name="menu" />
		</div>

		<div id="m_body">
			<tiles:insertAttribute name="body" />
		</div>

		<div id="m_right">
			<tiles:insertAttribute name="footer" />
		</div>

	</div>

</body>
</html>