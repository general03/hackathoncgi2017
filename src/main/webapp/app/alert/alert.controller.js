(function() {
    'use strict';

    angular
        .module('theaApp')
        .controller('AlertController', AlertController);

    AlertController.$inject = ['$scope', '$state', '$location'];

    function AlertController ($scope, $state, $location) {
        var vm = this;

        $scope.goHome = function() {
            $location.url('/home');
        };
    }
})();
