angulaAppModulo.factory("MedicoService", function($http) {

    var urlBase = "http://localhost:8080/lading_page";
    
    
    
    var _cadastrarMedico = function(medico){
		return $http.post(urlBase + "/medico/inserir", medico)
	};

    return {
        cadastrarMedico: _cadastrarMedico
    };
});