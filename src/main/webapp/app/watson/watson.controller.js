(function() {
    'use strict';

    angular
        .module('theaApp')
        .controller('WatsonController', WatsonController);

    WatsonController.$inject = ['$scope', '$state', '$http'];

    function WatsonController ($scope, $state, $http) {
        var vm = this;

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
            console.log(vm.conversation);
        }



        vm.interact = interact;
        function interact() {
            return $http.post('api/watson-conversation',{ 'context' : vm.conversation.context, 'message' : "Choix 1"}).then(function(response) {

            });
        }
   }
})();
