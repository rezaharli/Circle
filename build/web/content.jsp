<div class="col-md-8 col-sm-12">

    <div id="menu-container">

        <div id="menu-0" class="claim content">
            <%@include file="menu-0.jsp" %>
        </div> <!-- /.claim -->
        
        <% if (session.getAttribute("currentSessionUser") == null) {%>
        <div id="menu-1" class="about content">
            <%@include file="menu-1.jsp" %>
        </div> <!-- /.about -->

        <div id="menu-2" class="services content">
            <%@include file="menu-2.jsp" %>
        </div> <!-- /.services -->

        <div id="menu-3" class="contact content">
            <%@include file="menu-3.jsp" %>
        </div> <!-- /.contact -->
        <% }%>

    </div> <!-- /#menu-container -->

</div> <!-- /.col-md-8 -->