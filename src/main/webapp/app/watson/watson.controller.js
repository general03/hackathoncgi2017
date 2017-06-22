(function() {
    'use strict';

    angular
        .module('theaApp')
        .controller('WatsonController', WatsonController);

    WatsonController.$inject = ['$scope', '$state'];

    function WatsonController ($scope, $state) {
        var vm = this;

        vm.register = register;

        function register () {
            $state.go('register');
        }
    }
})();
