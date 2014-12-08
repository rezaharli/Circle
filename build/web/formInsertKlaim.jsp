<script>
    $(document).ready(function () {
        var iDokter = 0;
        var iObat = 0;
        $("#jumlahDokter").attr("value", iDokter);
        $("#jumlahObat").attr("value", iObat);
        $("#addDokter").click(function () {
            $("#fieldDokter").append('<div><input type="text" name="namaDokter' + iDokter + '" placeholder="Dokter" style="width: 55%; float:left" />&nbsp;<input type="text" name="hargaDokter' + iDokter + '" placeholder="Harga Dokter" style="width: 29%;" />&nbsp;<input type="button" value="-" class="button remove" style="width: 13%" /></div>');
            iDokter++;
            $("#jumlahDokter").attr("value", iDokter);
        });
        $("#addObat").click(function () {
            $("#fieldObat").append('<div><input type="text" name="namaObat' + iObat + '" placeholder="Obat" style="width: 55%; float:left" />&nbsp;<input type="text" name="hargaObat' + iObat + '" placeholder="Harga Obat" style="width: 29%;" />&nbsp;<input type="button" value="-" class="button remove" style="width: 13%" /></div>');
            iObat++;
            $("#jumlahObat").attr("value", iObat);
        });
        $("#fieldDokter").on('click', '.remove', function () {
            $(this).parent().remove();
            iDokter--;
            $("#jumlahDokter").attr("value", iDokter);
        });
        $("#fieldObat").on('click', '.remove', function () {
            $(this).parent().remove();
            iObat--;
            $("#jumlahObat").attr("value", iObat);
        });
    });
</script>

<div class="col-md-6">
    <form action="InsertKlaim" method="post" style="margin-top: 30px;">

        <input type="hidden" name="jumlahDokter" id="jumlahDokter" />
        <input type="hidden" name="jumlahObat" id="jumlahObat" />

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
        <tr>
            <td>
                Poiuy
            </td>
        </tr>
    </table>
</div>