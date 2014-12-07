<script>
    $(document).ready(function () {
        var iDokter = 0;
        var iObat = 0;
        $("#addDokter").click(function () {
            $("#fieldDokter").append('<div><input type="text" name="namaDokter' + iDokter + '" placeholder="Dokter" style="width: 55%; float:left" />&nbsp;<input type="text" name="hargaDokter[]" placeholder="Harga Dokter" style="width: 29%;" />&nbsp;<input type="button" value="-" class="button remove" style="width: 13%" /></div>');
            iDokter++;
        });
        $("#addObat").click(function () {
            $("#fieldObat").append('<div><input type="text" name="namaObat' + iObat + '" placeholder="Obat" style="width: 55%; float:left" />&nbsp;<input type="text" name="hargaObat[]" placeholder="Harga Obat" style="width: 29%;" />&nbsp;<input type="button" value="-" class="button remove" style="width: 13%" /></div>');
            iObat++;
        });
        $("#fieldDokter").on('click', '.remove', function () {
            $(this).parent().remove();
            iDokter--;
        });
        $("#fieldObat").on('click', '.remove', function () {
            $(this).parent().remove();
            iObat--;
        });
    });
</script>

<div class="col-md-6">
    <form action="InsertKlaim" method="post" style="margin-top: 30px;">

        <fieldset id="fieldDokter"></fieldset>
        <input type="button" id="addDokter" value="Tambah Dokter" class="button" style="width: 150px" />

        <fieldset id="fieldObat"></fieldset>
        <input type="button" id="addObat" value="Tambah Obat" class="button" style="width: 150px" />

        <fieldset style="width: 100%; float: left">
            <input type="submit" name="submit" value="Submit" id="submit" class="button">
        </fieldset>
    </form>
</div>
<div class="toggle-content text-center">
    <table>

    </table>
</div>