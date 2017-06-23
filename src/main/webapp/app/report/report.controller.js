(function() {
    'use strict';

    angular
        .module('theaApp')
        .controller('ReportController', ReportController);

    ReportController.$inject = ['$scope', '$state', '$stateParams', '$http', '$location'];

    function ReportController($scope, $state, $stateParams, $http, $location) {
        var vm = this;
        vm.id = $stateParams.id;

        vm.pathologie = {};

        $http.get("api/pathologie/" + vm.id).then(function(response){
            vm.pathologie = response.data
            console.log(vm.pathologie);
        });

        $scope.goHome = function() {
            $location.url('/home');
        };
    }
})();
