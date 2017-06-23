(function() {
    'use strict';

    angular
        .module('theaApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider.state('alert', {
            parent: 'app',
            url: '/alert',
            data: {
                authorities: []
            },
            views: {
                'content@': {
                    templateUrl: 'app/alert/alert.html',
                    controller: 'AlertController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate,$translatePartialLoader) {
                    $translatePartialLoader.addPart('alert');
                    return $translate.refresh();
                }]
            }
        });
    }
})();
