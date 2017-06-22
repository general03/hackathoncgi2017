(function() {
    'use strict';

    angular
        .module('theaApp')
        .controller('WatsonController', WatsonController);

    WatsonController.$inject = ['$scope', '$state', '$http'];

    function WatsonController ($scope, $state, $http) {
        var vm = this;

        vm.isReady = undefined;
        vm.conversation = {
            context: {},
            question: "",
            responses: []
        };

        // Cette méthode permet de lancer la conversation avec watson et de recevoir la question initialle.
        (function initConversation() {
            $http.get('api/watson-init').then(function(response) {
                readResponse(response.data);
            });
        })();

        function readResponse (response) {
            var responseJson = JSON.parse(response.text[0].replace(/'/g, '"'));
            console.log(responseJson);
            vm.conversation.context = response.context;
            vm.conversation.question = responseJson.question;
            vm.conversation.responses = responseJson.responses;
            vm.isReady = true;
            console.log(vm.conversation);
        }

        vm.answer = function(message) {
            console.log(message);
            $http
            .post('api/watson-conversation', { 'context' : vm.conversation.context, 'response' : message})
            .then(function(response) {
                console.log(response);
            });

        }



        vm.interact = interact;
        function interact() {
            return
        }
   }
})();
