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
<div class="col-md-12 col-sm-12">
    <script>
        function hitung() {
            var request = getRequestObject();
            request.open("GET", "http://localhost:8080/Circle/showObat");
            request.send(null);
            request.onreadystatechange = function () {
                if (request.readyState === 4 && request.status === 200) {
                    document.getElementById("hasil").innerHTML = request.responseText;
                }
            };
        }
    </script>
    <div class="toggle-content text-center" id="tab4">
        <h3>Our Services</h3>
        <p></p>
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