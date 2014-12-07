<div class="row">
    <% if (session.getAttribute("currentSessionUser") == null) {%>
    <%@include file="formLoginRegister.jsp" %>
    <% } else { %>
    <%@include file="klaim.jsp" %>
    <% }%>
</div>