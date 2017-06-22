(function() {
    'use strict';

    angular
        .module('theaApp')
        .controller('HomeController', HomeController);

    HomeController.$inject = ['$scope', '$state', '$location'];

    function HomeController ($scope, $state, $location) {
        var vm = this;

        $scope.goUrgency = function() {
            $location.url('/urgency');
        };
    }
})();
