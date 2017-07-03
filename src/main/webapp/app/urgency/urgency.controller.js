(function() {
    'use strict';

    angular
        .module('theaApp')
        .controller('UrgencyController', UrgencyController);

    UrgencyController.$inject = ['$scope', '$state', '$location', '$timeout'];

    function UrgencyController ($scope, $state, $location, $timeout) {
        var vm = this;

        $scope.goWatson = function() {
            $location.url('/watson/');
        };

        $scope.goAlert = function() {
            $location.url('/alert');
        };
    }
})();
