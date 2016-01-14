
<p class="message">
	<jsp:useBean id="mssg" class="com.psamp.app.Message" scope="request" />
	<jsp:getProperty property="message" name="mssg" />
</p>