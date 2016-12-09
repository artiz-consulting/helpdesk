/**
 * @ngdoc Dashboard Module
 * @name dashboard
 * @desc # Define all dependencies for dashboard app
 */
(function() {
	'use strict';

	angular
		.module('dashboard', [
			'ui.router',
			'ngMessages',
			'login'
		]);
})();
