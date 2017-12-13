<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

		<%@ include file="layouts/header.jsp" %>

		
		<section>
			<c:forEach items="${listArticle}" var="articletoto" >
			<div>
			  <article>
           		<h4>${articletoto.nom}</h4>
               		<figure>
	                   <a id= "${articletoto.id}" href="${pageContext.request.contextPath}/article?id=${articletoto.id}">
	                       <img src="${pageContext.request.contextPath}/img/${articletoto.lien}" alt="${articletoto.description}">
	                   </a>
              		 <figcaption>${articletoto.description}</figcaption>
              		 </figure>
           	   	<span>${articletoto.prix} € </span>
      		  </article>
      		 </div>
      		 </c:forEach>
		</section>
		
			<section>
				

			</section>
      		 
      		
				
		<%@ include file="layouts/footer.jsp" %>
		
