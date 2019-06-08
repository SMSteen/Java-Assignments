<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link href="style.css" rel="stylesheet" type="text/css">
		<title>Java Checkerboard</title>
	</head>
	<body>
	<div class="container">	
		<%! 
	    public int checkNull(String param) {
			// provide default values if not supplied via params
			if(param == null) {
				return 2;
	    	} else {
	    		return Integer.parseInt(param);
	    	}
		}
	    %>
			<!-- getting the width value from params -->
	    	<% int width = checkNull(request.getParameter("width")); %>
			<!-- getting the height value from params -->
	    	<% int height = checkNull(request.getParameter("height")); %>
			<h1>Checkerboard: <%= width %>w x <%=height %>h</h1>
			
			<table>
				<% for(int i = 0; i < height; i++) { %>
		        	<tr>
		        		<% for(int j = 0; j < width; j++) { %>
		        			<td></td>
	    			    <% } %>
		        	</tr>
		    	<% } %>
			</table>
		</div>
		
	</body>
</html>