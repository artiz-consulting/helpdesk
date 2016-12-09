/**
 * @ngdoc Dashboard Routes
 * @name dashboard.routes
 * @desc # Define all routes for dashboard app
 */
(function() {
	'use strict';

	angular
		.module('dashboard')
		.config(DashboardRoutes);

	DashboardRoutes.$inject = ['$stateProvider', '$urlRouterProvider'];

	function DashboardRoutes($stateProvider, $urlRouterProvider) {
		$stateProvider
			.state('login', {
				url : '/login?error?logout',
				templateUrl : '/dashboard/login.html',
				controller: 'LoginController',
				controllerAs: 'lvm'
			});

		$urlRouterProvider.otherwise('login');
	}
})();
