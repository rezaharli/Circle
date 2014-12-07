<script>
    function showObat() {
        var request = getRequestObject();
        request.open("GET", "http://localhost:8080/Circle/ShowObat");
        request.send(null);
        request.onreadystatechange = function () {
            if (request.readyState === 4 && request.status === 200) {
                document.getElementById("tab4p").innerHTML = request.responseText;
            }
        };
    }
</script>
<ul class="tabs">
    <li class="col-md-4 col-sm-4">
        <a href="#tab4" class="icon-item">
            <i class="fa fa-cogs"></i>
        </a> <!-- /.icon-item -->
    </li>
    <li class="col-md-4 col-sm-4">
        <a href="#tab5" class="icon-item">
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

    <div class="toggle-content text-center" id="tab5">
        <h3>Our Support</h3>
        <p></p>
    </div>

    <div class="toggle-content text-center" id="tab6">
        <h3>Testimonials</h3>
        <p></p>
    </div>
</div> <!-- /.col-md-12 -->