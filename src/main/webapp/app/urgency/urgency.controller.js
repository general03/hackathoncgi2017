(function() {
    'use strict';

    angular
        .module('theaApp')
        .controller('UrgencyController', UrgencyController);

    UrgencyController.$inject = ['$scope', '$state', '$location', 'toaster', '$timeout'];

    function UrgencyController ($scope, $state, $location, toaster, $timeout) {
        var vm = this;

        $scope.goPop = function(){
	        toaster.pop('warning', "1er geste à accomplir en cas de traumatisme", "<br> • Ne pas frotter l'oeil <br> • Placer une compresse sur la paupierre superposé \
	        <br>... \
	        <br><br><br> Redirection sur la page d'acceuil dans 10 secondes ");
	        document.getElementById('overlay').classList.remove("hide");

	        $timeout(function() {
               $location.url('/');
              }, 10000);

	    };

        $scope.goWatson = function() {
            $location.url('/watson');
        };
    }
})();
