<script>
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
</script>

<div class="col-md-6">
    <form style="height: 35px">
            <input type="text" disabled value="Tanggal Klaim" style="width: 39%"/>
            <input type="text" disabled value="Status Klaim" style="width: 39%"/>
        </form>
    <div id="listKlaim"></div>
</div>