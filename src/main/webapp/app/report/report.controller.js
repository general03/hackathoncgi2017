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
                	question: "une augmentation de la sensibilité à la lumière"
                },
                {
                	category: "Avez-vous rencontré durant la dernière semaine ?",
                	question: "une sensation de sable dans les yeux"
                },
                {
                	category: "Avez-vous rencontré durant la dernière semaine ?",
                	question: "une vision désagréable ou douloureuse"
                },
                {
                	category: "Avez-vous rencontré durant la dernière semaine ?",
                	question: "une vision floue"
                },
                {
                	category: "Avez-vous rencontré durant la dernière semaine ?",
                	question: "une baisse de vision"
                },
                {
                	category: "Avez-vous ressenti une gène oculaire durant la dernière semaine ?",
                	question: "pour lire"
                },
                {
                	category: "Avez-vous ressenti une gène oculaire durant la dernière semaine ?",
                	question: "pour conduire de nuit"
                },
                {
                	category: "Avez-vous ressenti une gène oculaire durant la dernière semaine ?",
                	question: "pour travailler sur un ordinateur ou sur un guichet automatique bancaire"
                },
                {
                	category: "Avez-vous ressenti une gène oculaire durant la dernière semaine ?",
                	question: "pour regarder la TV"
                },
                {
                	category: "Avez-vous ressenti une inconfort oculaire durant la dernière semaine ?",
                	question: "en présence de vent"
                },
                {
                	category: "Avez-vous ressenti une inconfort oculaire durant la dernière semaine ?",
                	question: "dans des espaces avec de faibles taux d'humidité"
                },
                {
                	category: "Avez-vous ressenti une inconfort oculaire durant la dernière semaine ?",
                	question: "dans des espaces conditionnés"
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
