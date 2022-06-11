<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags"%>


<jsp:include page="../fragments/userheader.jsp" />
<div class="container">

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid">



			<jsp:include page="../fragments/usermenu.jsp" />

		</div>
	</nav>

	<div>
		<h3>Prof home page</h3>
		<p>Hello and welcome to your application</p>

		<s:authorize access="isAuthenticated()">
    			You are connected with: 
    			 <s:authentication property="principal.username" />
			<br>
			Your Email : <s:authentication property="principal.email" />
			<br>
			Your First Name : <s:authentication property="principal.firstName" />
			<br>
			Your Last name : <s:authentication property="principal.LastName" />
			<br>
		</s:authorize>
		<f:form action="${pageContext.request.contextPath}/prof/Export1" method="GET">
		<li class="Selectbox"><select id="niveau" name="niveau"
			
			style="width: 200px; height: 23px; margin-left: 40px; margin-bottom: 20px;">

				<c:forEach items="${NiveauList}" var="niveau">
					<option value="niveau" tempCode="${n}">
						<spring:message code="label.menu.${niveau.alias}" id="${niveau.idNiveau}" value="${niveau.alias}"/>${niveau.alias}</option>
				</c:forEach>
		</select></li>
		
		
			<button type="submit" class="btn btn-link"><img
			src="${pageContext.request.contextPath}/resources/img/excel.png" width="30">Exporter</button>
			
			</f:form></li>
		
		
	</div>
	
	




	<jsp:include page="../fragments/userfooter.jsp" />