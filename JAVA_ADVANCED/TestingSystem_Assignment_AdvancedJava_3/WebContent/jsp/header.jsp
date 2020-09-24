<%!
	String getStringAttribute(HttpServletRequest request, String key){
		return request.getAttribute(key) == null ? null : request.getAttribute(key).toString();
	}

	private String getCookieByKey(HttpServletRequest request, String key) {
		Cookie[] cookies = request.getCookies();
	
		if (cookies == null || cookies.length == 0) {
			return null;
		}
	
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals(key)) {
				return cookie.getValue();
			}
		}
		return null;
	}
%>

<%!
	String fillStringValueToForm(String value){
		return value == null ? "" : value;
	}
%>

<% 	String fullname = getCookieByKey(request, "fullname");
	String role = getCookieByKey(request, "role");
%>


<div class="relative">
    <div class="row">
        <div class=" col-8">
            <span id="mynav" class="header-nav btn1" onclick="openNav()">&#9776;</span>
        </div>
        <div class="avatar col-4" style="padding-right: 70px;">
            <span id="role" style="color:maroon"><%= fillStringValueToForm(role) %></span>
            <span id="username" style="color:maroon"><%= fillStringValueToForm(fullname) %></span>
            <a class="logout" style="padding:20px" onclick="logout()">LOGOUT</a>
            <a class="login" style="padding:20px" onclick="login()">LOGIN</a>
        </div>
    </div>
    
</div>