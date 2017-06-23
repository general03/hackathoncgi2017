(function() {
    'use strict';

    angular
        .module('theaApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider.state('watson', {
            parent: 'app',
            url: '/watson/{retour}',
            data: {
                authorities: []
            },
            views: {
                'content@': {
                    templateUrl: 'app/watson/watson.html',
                    controller: 'WatsonController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate,$translatePartialLoader) {
                    $translatePartialLoader.addPart('watson');
                    return $translate.refresh();
                }]
            }
        });
    }
})();
