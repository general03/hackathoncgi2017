(function() {
    'use strict';

    angular
        .module('theaApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider.state('report', {
            parent: 'app',
            url: '/report',
            data: {
                authorities: []
            },
            views: {
                'content@': {
                    templateUrl: 'app/report/report.html',
                    controller: 'ReportController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate,$translatePartialLoader) {
                    $translatePartialLoader.addPart('report');
                    return $translate.refresh();
                }]
            }
        });
    }
})();
