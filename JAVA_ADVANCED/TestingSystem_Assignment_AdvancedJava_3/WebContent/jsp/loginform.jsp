<%!
	String getStringAttribute(HttpServletRequest request, String key){
		return request.getAttribute(key) == null ? null : request.getAttribute(key).toString();
	}
%>

<%!
	String fillStringValueToForm(String value){
		return value == null ? "" : value;
	}
%>

<% 	String username = getStringAttribute(request, "username");
	String messageError = getStringAttribute(request, "messageError");
%>

<p style="color:red;"> <%=fillStringValueToForm(messageError)%></p> 

<form action="login" method="post">
  <div class="imgcontainer">
    <img src="./image/avatar.png" alt="Avatar" class="avatar">
  </div>

  <div class="container">
    <label for="uname"><b>Username</b></label>
    <input type="text" placeholder="Enter Username" name="userName" required 
    			value="<%= fillStringValueToForm(username) %>">

    <label for="psw"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="pass" required>
        
    <button type="submit">Login</button>
    <label>
      <input type="checkbox" checked="checked" name="remember"> Remember me
    </label>
  </div>
</form>
