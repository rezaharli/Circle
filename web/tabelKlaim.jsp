<script>
    function deleteKlaim(idKlaim) {
        var request = getRequestObject();
        request.open("GET", "http://localhost:8080/Circle/DeleteKlaim?idKlaim=" + idKlaim);
        request.send(null);
        document.getElementById("detailKlaim").innerHTML = "";
        showKlaim();
    }

    function approveKlaim(idKlaim) {
        var request = getRequestObject();
        request.open("GET", "http://localhost:8080/Circle/EditStatusKlaim?idKlaim=" + idKlaim + "&status=approved");
        request.send(null);
        showKlaim();
        showDetailKlaim();
    }

    function tolakKlaim(idKlaim) {
        var request = getRequestObject();
        request.open("GET", "http://localhost:8080/Circle/EditStatusKlaim?idKlaim=" + idKlaim + "&status=ditolak");
        request.send(null);
        showKlaim();
        showDetailKlaim();
    }

    function showKlaim() {
        var request = getRequestObject();
        request.open("GET", "http://localhost:8080/Circle/ShowKlaim");
        request.send(null);
        request.onreadystatechange = function () {
            if (request.readyState === 4 && request.status === 200) {
                document.getElementById("listKlaim").innerHTML = request.responseText;
            }
        };
    }

    function showDetailKlaim(idKlaim, status) {
        var request = getRequestObject();
        request.open("GET", "http://localhost:8080/Circle/ShowDetailKlaim?idKlaim=" + idKlaim + "&statusKlaim=" + status);
        request.send(null);
        request.onreadystatechange = function () {
            if (request.readyState === 4 && request.status === 200) {
                document.getElementById("detailKlaim").innerHTML = request.responseText;
            }
        };
    }
</script>

<div class="col-md-6" style="margin-top: 30px">
    <form style="height: 35px">
        <input type="text" disabled value="Tanggal Klaim" style="width: 39%"/>
        <input type="text" disabled value="Status Klaim" style="width: 39%"/>
    </form>
    <div id="listKlaim"></div>
</div>

<div class="toggle-content text-center" id="detailKlaim"></div>