

<%@page import="fr.encheres.bo.User"%>
<%
User user = (User) session.getAttribute("userSuccess");
if (user != null) {
%>
<div class="col mr-2 row"><div class=" mb-0 font-weight-bold text-gray-600 mr-2">Credit :</div>
	<div class=" font-weight-bold text-success text-uppercase mb-1">
		<%=user.getCredit()%></div>
	
</div>

<%
}
%>

<ul class="navbar-nav ml-auto">

	<%
	if (user == null) {
	%>
	<%@ include
		file="/WEB-INF/vues/menus/top_menu/top_menu_visitor.jsp"%>
	<%
	} else {
	%>

	<%@ include
		file="/WEB-INF/vues/menus/top_menu/top_menu_user_admin.jsp"%>


	<%
	}
	%>


</ul>

