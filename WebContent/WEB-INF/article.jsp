<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

		<%@ include file="layouts/header.jsp" %>

		
	
		<section>
			<div>
				<article>
					<h4> ${ArticleSimple.nom}</h4>
						<figure>	
							<img src="${pageContext.request.contextPath}/img/${ArticleSimple.lien}" alt=" ${ArticleSimple.description}">
							<figcaption>${ArticleSimple.description}</figcaption>
						</figure>
						<span>${ArticleSimple.prix}€ </span>
					</article>
			</div>
		</section>
		
		<%@ include file="layouts/footer.jsp" %>
	</body>
</html>