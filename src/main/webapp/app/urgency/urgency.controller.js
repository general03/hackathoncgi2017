(function() {
    'use strict';

    angular
        .module('theaApp')
        .controller('UrgencyController', UrgencyController);

    UrgencyController.$inject = ['$scope', '$state', '$location', 'toaster'];

    function UrgencyController ($scope, $state, $location, toaster) {
        var vm = this;

        $scope.goPop = function(){
	        toaster.pop('warning', "1er geste à accomplir en cas de traumatisme", "<br> • Ne pas frotter l'oeil <br> • Placer une compresse sur la paupierre superposé");
	        document.getElementById('overlay').classList.remove("hide");
	    };

        $scope.goWatson = function() {
            $location.url('/watson');
        };

        $scope.goHome = function() {
            $location.url('/');
        };
    }
})();
