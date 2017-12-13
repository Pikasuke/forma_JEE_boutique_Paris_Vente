<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Verif Nom</title>
		<script src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
	
	<style>
		span {
		border:1px red solid; 
		background: lightgrey;
		font-style: italic;
		}
		form {
		border: 2px solid blue;
		width: 450px;
		padding: 20px;
		}
		
		table{
		border: 2px blue solid; 
		background: lightgrey;
		border-radius: 15px;
		}
		th{
		border: 1px blue dashed;
		border-radius: 5px;
		}
		td {
		border: 1px green dotted;
		align-self: center;
		background: grey;
		
		}
		#ernom {
		display: ${ !empty person.getNom() ? "none;": "inline;"};
		}
		#erprenom {
		display: ${ !empty person.getPrenom() ? "none;": "inline;"};
		}
		#ermail {
		 display: ${  !empty person.getMail() ? "none;": "inline;"};
		}
		#erage {
		display: <c:> ${ !empty person.getAge() ? "none;": "inline;"} </c:>;
		}
		
		
	</style>
	</head>


		
	
	<body>
			<div>
				<p> Formulaire POST</p>
				<form action="/FirstTest/verif" method="POST" id="form1"> 
					<input type="texte" id="prenom" name="prenom" placeholder="Prénom" value= "${person.getPrenom()}">  
						<span id="erprenom"> "Veuillez entrer votre prenom" </span>  <br>
					<br> <input type="texte" name="nom" placeholder="Nom" >
						<span id="ernom"> "Veuillez entrer votre Nom" </span>  <br>
					<br> <input type="texte" name="mail" placeholder="Mail" >
						<span id="ermail"> "Veuillez entrer votre email" </span>  <br>
					<br> <input type="texte" name="age" placeholder="age" >  
						<span id="erage"> "Veuillez entrer un age valide" </span>  <br>
					<br> <input type="submit" id="bsubmit" name="rec" value="Enregistrer" >  <br><br>
				</form>
			 
				<br><br>
				<table>
					${tableauPers}
				</table>
		</div>
		
		<%-- <p> Bonjour à vous Maestro ${ ( }.
			Votre prénom ${ (!empty prenom)? prenom: "Seigneur" } 
			 a aujourd'hui ${ (!empty age)? age: "un siecle" } d'années
		 </p> --%>
			
		<!-- <script>
			$(function(){
				console.log(1);
				$('#form1').submit(function(event){
					console.log(2);
					event.preventDefault();	
					console.log(3);
						prenom=$('#prenom').val();
					console.log(4);
						if (prenom.length==0){
							alert('veuillez renseigner le prénom');
							}
				});
			});
		
		</script> -->
		<%@ include file="layouts/footer.jsp" %>
