(function() {
    'use strict';

    angular
        .module('theaApp')
        .controller('UrgencyController', UrgencyController);

    UrgencyController.$inject = ['$scope', '$state', '$location', 'toaster', '$timeout'];

    function UrgencyController ($scope, $state, $location, toaster, $timeout) {
        var vm = this;

        $scope.goPop = function(){
	        toaster.pop('warning', "1er geste à accomplir en cas de traumatisme", "<h2>Plaie ou contusion par impact</h2> \
	        • Ne rien mettre dans l'oeil <br> \
	        • Fermer l'oeil \
	        • Placer une compresse pliée sur la paupière suprérieure \
	        • Appliquer un pansement occulaire maintenu par une bande \
	        <br> \
	        <h2>Brûlures</h2> \
	        • Laver l'oeil abondamment sous un filet d'eau froide pendant au moins 10 min en faisant couler le liquide sur le nez afin de laver l'oeil de l'intérieur vers l'exterieur '\
	        <br><br><br> Redirection sur la page d'accueil dans 10 secondes ");
	        document.getElementById('overlay').classList.remove("hide");

	        $timeout(function() {
               $location.url('/');
              }, 10000);

	    };

        $scope.goWatson = function() {
            $location.url('/watson/');
        };
    }
})();
