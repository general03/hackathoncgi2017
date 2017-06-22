(function() {
    'use strict';

    angular
        .module('theaApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider.state('urgency', {
            parent: 'app',
            url: '/urgency',
            data: {
                authorities: []
            },
            views: {
                'content@': {
                    templateUrl: 'app/urgency/urgency.html',
                    controller: 'UrgencyController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate,$translatePartialLoader) {
                    $translatePartialLoader.addPart('urgency');
                    return $translate.refresh();
                }]
            }
        });
    }
})();
