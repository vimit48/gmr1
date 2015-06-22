<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>GMR Data Dictionary</title>

<script>
function addGMRDDLink(e){
    e.href = e.href + "?bucket=" + document.getElementById('bucket').value + "&attribute=" + document.getElementById('attribute').value + "&column=" + document.getElementById('column').value
    + "&platform=" + document.getElementById('platform').value + "&dataEle=" + document.getElementById('dataEle').value + "&dataType=" + document.getElementById('dataType').value 
    + "&nullDefi=" + document.getElementById('nullDefi').value + "&busiDefi=" + document.getElementById('busiDefi').value;
}
function exportGMRDDLink(e){
    e.href = e.href + "?dataFile=" + document.getElementById('dataFile').value;
}
</script>

</head>
<body>
	<span style="margin-top:2px">
		<H1 style="text-align:center; height: 50px;background-color:#FF9966; font-family:Lucida Bright">GMR Data Dictionary</H1>
	</span>
	<br>
	<table border="1">
	<c:set var="count" value="0" scope="page" />	
	<c:forEach var="dataList" items="${nodeDataList}">
		
		<c:if test="${count=='0'}">
			<tr>
				<c:forEach var="item" items="${dataList}">
					<th> <c:out value="${item}"/></th>
				</c:forEach>
			</tr>
		</c:if>
		<c:if test="${count=='1'}">
			<tr>
				<c:forEach var="item" items="${dataList}">
					<td><c:out value="${item}"/> </td>
				</c:forEach>
			</tr>
		</c:if>
		<c:set var="count" value="1" />
		
	</c:forEach>
		<tr>
			<td><input type="text" style="border: 2px solid #dadada; border-radius: 7px;" id="bucket"> </td>
			<td><input type="text" style="border: 2px solid #dadada; border-radius: 7px;" id="attribute"> </td>
			<td><input type="text" style="border: 2px solid #dadada; border-radius: 7px;" id="column"> </td>
			<td><input type="text" style="border: 2px solid #dadada; border-radius: 7px;" size="6" id="platform"> </td>
			<td><input type="text" style="border: 2px solid #dadada; border-radius: 7px;" size="8" id="dataEle"> </td>
			<td><input type="text" style="border: 2px solid #dadada; border-radius: 7px;" size="10" id="dataType"> </td>
			<td><input type="text" style="border: 2px solid #dadada; border-radius: 7px;" size="8" id="nullDefi"> </td>
			<td><input type="text" style="border: 2px solid #dadada; border-radius: 7px;" size="55" id="busiDefi"> </td>
		</tr>

</table>
   <br>
  Browse Data Dictionary: <input type="text" style="border: 2px solid #dadada; border-radius: 7px;" id="dataFile" >
  <a href="/gmr1/gmrdd" id="exportGMRDDLink" onclick="exportGMRDDLink(this)">ExportGMRDD</a>

 <input type="hidden" name="url"><br>
 <a href="/gmr1/writeGMRDD" id="gmrddAddLink" onclick="addGMRDDLink(this)">AddGMRDDData</a>
</body>
</html>