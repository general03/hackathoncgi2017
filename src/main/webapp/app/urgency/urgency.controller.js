(function() {
    'use strict';

    angular
        .module('theaApp')
        .controller('UrgencyController', UrgencyController);

    UrgencyController.$inject = ['$scope', '$state'];

    function UrgencyController ($scope, $state) {
        var vm = this;

        vm.register = register;

        function register () {
            $state.go('register');
        }
    }
})();
