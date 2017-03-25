angulaAppModulo.controller('medicoController', function (MedicoService, $scope) {

    $scope.medicos = [];
    
    $scope.adicionaMedico = function(){    
    
        MedicoService.cadastrarMedico($scope.medico)
            .then(function (response){
            console.log(response.data);
            var medico = response.data;
            $scope.alunos.push(medico);
        });
    };
});