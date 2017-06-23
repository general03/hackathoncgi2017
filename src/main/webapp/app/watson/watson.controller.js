(function() {
    'use strict';

    angular
        .module('theaApp')
        .controller('WatsonController', WatsonController);

    WatsonController.$inject = ['$scope', '$state', '$http', '$location'];

    function WatsonController ($scope, $state, $http, $location) {
        var vm = this;

        vm.displayResponses = undefined;
        vm.conversation = {
            context: {},
            question: "",
            responses: [],
            symptomelib: "",
            symptomecode: ""
        };

        // Cette méthode permet de lancer la conversation avec watson et de recevoir la question initialle.
        (function initConversation() {
            vm.displayResponses = undefined;
            $http.get('api/watson-init').then(function(response) {
                readResponse(response.data);
            });
        })();

        function readResponse (response) {
            var responseJson = JSON.parse(response.text[0].replace(/'/g, '"'));
            console.log(responseJson);
            if(responseJson.symptomelib === undefined || responseJson.symptomelib === "") {
                vm.conversation.context = response.context;
                vm.conversation.question = responseJson.question;
                vm.conversation.responses = responseJson.responses;
                vm.displayResponses = true;
            } else {
                $location.path("/report/" + responseJson.symptomecode);
            }
        }

        vm.answer = function(message) {
            vm.displayResponses = undefined;
            $http
            .post('api/watson-conversation', { 'context' : vm.conversation.context, 'response' : message})
            .then(function(response) {
                readResponse(response.data);
            });
        }



        function isJson(str) {
            try {
                JSON.parse(str);
            } catch (e) {
                return false;
            }
            return true;
        }
   }
})();
