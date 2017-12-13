<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

		<%@ include file="layouts/header.jsp" %>

		
		<section>
		
			<form id="login" method="post">
				<input type="texte" id="mail" name ="mail"><label>email</label> <br>
				<input type="password" id="passe" name ="pass"><label>mot de passe</label><br>
				<input type="submit" id="b1" name="envoi" value="Envoyer">
				
			<%-- 	${sessionScope.pass}<br> --%>
				<br>
			<%-- 	<c:out value="${sessionScope.email}" >hello</c:out> --%>
				<br>
			<%-- 	<c:out value="${sessionScope.islog}">Pas logger</c:out> --%>
					<c:out value="${sessionScope.logger}">Pas logger</c:out>
				<br>
				<c:out value="${sessionScope.email}"></c:out>
	<%-- 			<c:if test="${ 15 le 20 }">il est plus grand</c:if> --%>
			</form>
			<form  method="POST">
				<input type="submit" id="delog" name="delog" value="logout">
			</form>
				<br><br><br>
			
			
				<form method="GET">
					<input type="text" name="age">
					<input type="submit">
				</form>
				<%-- <c:choose>
						<c:when test="${ ageee == null || ageee == 0 || ageee <0 }">pas renseigné</c:when>
					    <c:when test="${ ageee < 10 }">enfant</c:when>
					    <c:when test="${ ageee >=10 && ageee<=18  }">Ado</c:when>
					    <c:when test="${ ageee >=18 && ageee<=65 }">Adulte</c:when>
					    <c:otherwise>retraité</c:otherwise>
				</c:choose>
						
				<c:forEach var="i" begin="0" end="9" step="1">
   					<c:out value="${ i }" /> chairat 
				</c:forEach> 	
				<br>
				<c:forEach items="${ tab }" var="t" varStatus="status">
   					 <c:out value="${ t } ${ status.count } "  /> 
				</c:forEach> 	
				<br>
				<c:forTokens var="var" items="Un élément/Encore un autre élément/Un dernier pour la route" delims="/">
    					<p>${ var }</p>
				</c:forTokens> --%>
		</section>
				
		<section>
		
		</section>
		
		<%@ include file="layouts/footer.jsp" %>
	</body>
</html>