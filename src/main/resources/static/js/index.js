function eliminarDepartamento(id) {
    $("#eliminarDepartamentoBtn").attr("onclick", "javascript:window.location.href='/departamentos/" + id + "?_method=DELETE'");
}

// function actualizarDepartamento(id) {
//     $("#actualizarDepartamentoBtn").attr("onclick", "javascript:window.location.href='/departamentos/editar" + id + "?_method=PUT'");
// }
