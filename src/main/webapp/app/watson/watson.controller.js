(function() {
    'use strict';

    angular
        .module('theaApp')
        .controller('WatsonController', WatsonController);

    WatsonController.$inject = ['$scope', '$state', '$http', '$location', '$rootScope', '$stateParams'];

    function WatsonController ($scope, $state, $http, $location, $rootScope, $stateParams) {
        var vm = this;

        vm.displayResponses = undefined;
        vm.conversation = {
            context: {},
            question: "",
            responses: [],
            symptomelib: "",
            symptomecode: ""
        };

        function readResponse (response) {
        console.log(response);
            var responseJson = JSON.parse(response.text[0].replace(/'/g, '"'));
            console.log(responseJson);
            vm.conversation.context = response.context;
            vm.conversation.question = responseJson.question;
            vm.conversation.responses = responseJson.responses;
            vm.conversation.retour = responseJson.retour;
            console.log(vm.conversation)
            if(responseJson.symptomelib === undefined || responseJson.symptomelib === "") {
                vm.displayResponses = true;
            } else {
                $rootScope.lastConversation = vm.conversation;
                $location.path("/report/" + responseJson.symptomecode);
            }
        }

        vm.answer = function(message) {
            console.log(message);
            vm.displayResponses = undefined;
            $http
            .post('api/watson-conversation', { 'context' : vm.conversation.context, 'response' : message})
            .then(function(response) {
                readResponse(response.data);
            });
        };

        // Cette méthode permet de lancer la conversation avec watson et de recevoir la question initialle.
                (function initConversation() {
                    vm.displayResponses = undefined;
                    if($stateParams.retour !== "undefined" && $rootScope.lastConversation !== undefined) {
                        vm.conversation = $rootScope.lastConversation;
                        vm.answer(vm.conversation.retour);
                    } else {
                        $http.get('api/watson-init').then(function(response) {
                            readResponse(response.data);
                        });
                    }
                })();
   }
})();
