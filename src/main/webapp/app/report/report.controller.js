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

        vm.osdi = {
            current_question: 0,
            answered_question: 0,
            score: 0,
            questions: [
				{
                	category: "Avez-vous rencontré durant la dernière semaine ?",
                	question: "une augmentation de la sensibilité à la lumière",
                	isNA: false
                },
                {
                	category: "Avez-vous rencontré durant la dernière semaine ?",
                	question: "une sensation de sable dans les yeux",
                	isNA: false
                },
                {
                	category: "Avez-vous rencontré durant la dernière semaine ?",
                	question: "une vision désagréable ou douloureuse",
                	isNA: false
                },
                {
                	category: "Avez-vous rencontré durant la dernière semaine ?",
                	question: "une vision floue",
                	isNA: false
                },
                {
                	category: "Avez-vous rencontré durant la dernière semaine ?",
                	question: "une baisse de vision",
                	isNA: false
                },
                {
                	category: "Avez-vous ressenti une gène oculaire durant la dernière semaine ?",
                	question: "pour lire",
                	isNA: true
                },
                {
                	category: "Avez-vous ressenti une gène oculaire durant la dernière semaine ?",
                	question: "pour conduire de nuit",
                	isNA: true
                },
                {
                	category: "Avez-vous ressenti une gène oculaire durant la dernière semaine ?",
                	question: "pour travailler sur un ordinateur ou sur un guichet automatique bancaire",
                	isNA: true
                },
                {
                	category: "Avez-vous ressenti une gène oculaire durant la dernière semaine ?",
                	question: "pour regarder la TV",
                	isNA: true
                },
                {
                	category: "Avez-vous ressenti une inconfort oculaire durant la dernière semaine ?",
                	question: "en présence de vent",
                	isNA: true
                },
                {
                	category: "Avez-vous ressenti une inconfort oculaire durant la dernière semaine ?",
                	question: "dans des espaces avec de faibles taux d'humidité",
                	isNA: true
                },
                {
                	category: "Avez-vous ressenti une inconfort oculaire durant la dernière semaine ?",
                	question: "dans des espaces conditionnés",
                	isNA: true
                }
            ]
        };

        vm.click = function(score) {
            vm.osdi.current_question++;
            vm.osdi.answered_question++;
            vm.osdi.score += score;

            vm.osdi.result = vm.osdi.score * 25 / vm.osdi.answered_question;
        }

        vm.clickNo = function() {
            vm.osdi.current_question++;
        }

        $http.get("api/pathologie/" + vm.id).then(function(response){
            vm.pathologie = response.data
            console.log(vm.pathologie);
        });

        $scope.goUrgency = function() {
            $location.url('/urgency');
        };
    }
})();
