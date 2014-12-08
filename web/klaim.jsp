<ul class="tabs">
    <li class="col-md-4 col-sm-4">
        <a href="#tab4" class="icon-item">
            <i class="fa fa-cogs"></i>
        </a> <!-- /.icon-item -->
    </li>
    <li class="col-md-4 col-sm-4">
        <a href="#tab5" class="icon-item" onclick="showKlaim()">
            <i class="fa fa-leaf"></i>
        </a> <!-- /.icon-item -->
    </li>
    <li class="col-md-4 col-sm-4">
        <a href="#tab6" class="icon-item">
            <i class="fa fa-users"></i>
        </a> <!-- /.icon-item -->
    </li>
</ul> <!-- /.tabs -->
<div class="col-md-12">
    <div class="col-md-12" id="tab4">
        <%@include file="formInsertKlaim.jsp" %>
    </div>

    <div class="col-md-12" id="tab5">
        <%@include file="tabelKlaim.jsp" %>
    </div>

    <div class="toggle-content text-center" id="tab6">
        <h3>Testimonials</h3>
        <p></p>
    </div>
</div> <!-- /.col-md-12 -->