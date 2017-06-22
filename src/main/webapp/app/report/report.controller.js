(function() {
    'use strict';

    angular
        .module('theaApp')
        .controller('ReportController', ReportController);

    ReportController.$inject = ['$scope', '$state'];

    function ReportController($scope, $state) {
        var vm = this;

        vm.register = register;

        function register () {
            $state.go('register');
        }
    }
})();
