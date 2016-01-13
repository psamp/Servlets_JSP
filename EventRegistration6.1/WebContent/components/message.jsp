
<p class="message">
	<%
		if (request.getAttribute("message") != null) {
	%>
	<%=request.getAttribute("message")%>
	<%
		}
	%>
</p>