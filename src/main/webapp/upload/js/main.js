$(document).ready(function() {
    $('button[type=submit]').click(function(e) {
        e.preventDefault();
        //Disable submit button
        $(this).prop('disabled', true);

        var form = document.forms[0];
        var data = new FormData(form);

        //data.append("extraField", "This is some extra data, testing");

        $("#btnSubmit").prop("disabled", true);

        var ajaxReq = $.ajax({
            data : data,
            cache : false,
            contentType : false,
            processData : false,
            type : "POST",
            enctype : 'multipart/form-data',
            url : "/file/upload/multi",
            timeout : 600000,
            xhr : function() {
                var xhr = $.ajaxSettings.xhr();
                xhr.upload.onprogress = function(event) {
                    console.log(event.loaded);
                    var perc = Math.round((event.loaded / event.total) * 100);
                    $('#progressBar').text(perc + '%');
                    $('#progressBar').css('width', perc + '%');
                };
                return xhr;
            },

            beforeSend : function(xhr) {
                //Reset alert message and progress bar
                $('#alertMsg').text('');
                $('#progressBar').text('');
                $('#progressBar').css('width', '0%');
            }
        });

        ajaxReq.done(function(msg) {
            $('#alertMsg').text(msg);
            $('input[type=file]').val('');
            $('button[type=submit]').prop('disabled', false);
        });

        ajaxReq.fail(function(jqXHR) {
            $('#alertMsg').text(jqXHR.responseText + '(' + jqXHR.status +
                ' - ' + jqXHR.statusText + ')');
            $('button[type=submit]').prop('disabled', false);
        });

    });
});