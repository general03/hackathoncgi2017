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
                	question: "1) une augmentation de la sensibilité à la lumière",
                	isNA: false
                },
                {
                	category: "Avez-vous rencontré durant la dernière semaine ?",
                	question: "2) une sensation de sable dans les yeux",
                	isNA: false
                },
                {
                	category: "Avez-vous rencontré durant la dernière semaine ?",
                	question: "3) une vision désagréable ou douloureuse",
                	isNA: false
                },
                {
                	category: "Avez-vous rencontré durant la dernière semaine ?",
                	question: "4) une vision floue",
                	isNA: false
                },
                {
                	category: "Avez-vous rencontré durant la dernière semaine ?",
                	question: "5) une baisse de vision",
                	isNA: false
                },
                {
                	category: "Avez-vous ressenti une gène oculaire durant la dernière semaine ?",
                	question: "6) pour lire",
                	isNA: true
                },
                {
                	category: "Avez-vous ressenti une gène oculaire durant la dernière semaine ?",
                	question: "7) pour conduire de nuit",
                	isNA: true
                },
                {
                	category: "Avez-vous ressenti une gène oculaire durant la dernière semaine ?",
                	question: "8) pour travailler sur un ordinateur ou sur un guichet automatique bancaire",
                	isNA: true
                },
                {
                	category: "Avez-vous ressenti une gène oculaire durant la dernière semaine ?",
                	question: "9) pour regarder la TV",
                	isNA: true
                },
                {
                	category: "Avez-vous ressenti une inconfort oculaire durant la dernière semaine ?",
                	question: "10) en présence de vent",
                	isNA: true
                },
                {
                	category: "Avez-vous ressenti une inconfort oculaire durant la dernière semaine ?",
                	question: "11) dans des espaces avec de faibles taux d'humidité",
                	isNA: true
                },
                {
                	category: "Avez-vous ressenti une inconfort oculaire durant la dernière semaine ?",
                	question: "12) dans des espaces conditionnés",
                	isNA: true
                }
            ]
        };


        vm.click = function(score) {
            vm.osdi.current_question++;
            vm.osdi.answered_question++;
            vm.osdi.score += score;

            vm.osdi.result = vm.osdi.score * 25 / vm.osdi.answered_question;

            if(vm.osdi.current_question == 12)
            {
                var ctx = document.getElementById('score-graph').getContext('2d');
                var chart = new Chart(ctx, {
                 type: 'horizontalBar',
                 data: {
                     labels: ["OSDI"],
                     datasets: [{
                         label: "Score OSDI ",
                         backgroundColor: '#01b5d6',
                         borderColor: '#0058a6',
                         data: [vm.osdi.result]
                     }]
                 }
                });
            }
        }

        vm.clickNo = function() {
            vm.osdi.current_question++;
        }

        $http.get("api/pathologie/" + vm.id).then(function(response){
            vm.pathologie = response.data
        });

        $scope.goUrgency = function() {
            $location.url('/urgency');
        };
    }
})();
