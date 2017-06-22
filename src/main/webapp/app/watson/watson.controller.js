(function() {
    'use strict';

    angular
        .module('theaApp')
        .controller('WatsonController', WatsonController);

    WatsonController.$inject = ['$scope', '$state', '$http'];

    function WatsonController ($scope, $state, $http) {
        var vm = this;

        vm.context = null;
        vm.question = null;
        vm.answer = null;

        vm.register = register;
        function register () {
            $state.go('register');
        }

        vm.initConversation = initConversation;
        function initConversation() {
            context = null;
            $http.get('api/watson-init').then(function(response) {
                vm.context = response.data;
            });
        }

        vm.interact = interact;
        function interact() {
            return $http.post('api/watson-conversation',{ 'context' : vm.context, 'message' : vm.message }).then(function(response) {
                vm.question = response.data.text;
                vm.context = response.data;
            });
        }
   }
})();
