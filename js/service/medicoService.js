angulaAppModulo.factory("medicoService", function ($http) {
    
    var urlBase = "http://localhost:8080/GestansApp";
    
    
    var _cadastrarMedico = function(medico) {
        return $http.post(urlBase + "/medico/cadastrar/");
    };
    
    return {
        cadastrarMedico: _cadastrarMedico
    };
});