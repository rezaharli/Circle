<ul class="tabs">
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
    <li class="col-md-4 col-sm-4">
        <a href="#tab4" class="icon-item" onclick="showObat()">
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
        <div class="col-md-6">
            <form action="InsertKlaim" method="post" style="margin-top: 30px;">
                <fieldset>
                    <input type="text" id="tanggal" name="tanggal" placeholder="Tanggal" />
                </fieldset>
                <fieldset style="width: 49%; float:left">
                    <input type="text" id="namaDokter" name="namaDokter" placeholder="Dokter" />
                </fieldset>
                <fieldset style="width: 49%; float: right">
                    <input type="text" id="hargaDokter" name="hargaDokter" placeholder="Harga Dokter" />
                </fieldset>
                <fieldset style="width: 49%; float:left">
                    <input type="text" id="obat" name="obat" placeholder="Obat" class="col-md-6" />
                </fieldset>
                <fieldset style="width: 49%; float: right">
                    <input type="text" id="hargaObat" name="hargaObat" placeholder="Harga Obat" />
                </fieldset>
                <fieldset style="width: 100%; float: left">
                    <input type="submit" name="submit" value="Submit" id="submit" class="button">
                </fieldset>
            </form>
        </div>
        <div class="toggle-content text-center">

        </div>
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