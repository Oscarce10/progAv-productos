$(function(){
  $("#registro-producto").load("producto/form_producto.jsp");
});

$("agregar").click(function (){
    
});


$(function () {
    $('[data-toggle="tooltip"]').tooltip()
});

$('body').on('show.bs.modal', '.modal', function (e) {
    var link = $(e.relatedTarget);
    $(this).find(".modal-content").load(link.attr("href"));
});

$("#actualizar").click(function () {
        $.ajax({
            type: "POST",
            cache: false,
            url: $(this).attr('action'),
            data: $(this).serialize(),
            success: function (data) {
                $("#prod"+$("#id").val()).load("indexAjax.jsp/producto/prodEditado.jsp&id=" + $("#id").val());
            }
        });
    });
