var Zaposleniapp = angular.module("root", [ "ngResource" ]);

Zaposleniapp
		.controller(
				"main",
				[
						'$scope',
						'$http',
						'$resource',
						function($scope, $http, $resource) {
							$scope.user;
							$scope.dataObj;
							$scope.ImeDelavca;
							$scope.RojstniDatum;
							$scope.Spol;
							$scope.Starost;
							$scope.sektor;
							$scope.izobrazba;
							$scope.tip;
							$scope.zaposleni;
							$scope.imeTovarne;
							$scope.tovarna;
							$scope.tovar;
							$scope.tovid =5;
							$scope.zap;
							$scope.isci;
							$scope.isciatribut;
							$scope.getUserData = function() {
								console.log($scope.tovid);
								$scope.delavec = {
									idTov: parseInt($scope.tovid),
									ImeDelavca : $scope.ImeDelavca,
									RojstniDatum : $scope.RojstniDatum,
									Spol : $scope.Spol,
									Starost : parseInt($scope.Starost),
									sektor : $scope.sektor,
									izobrazba : $scope.izobrazba,
									Tip : $scope.tip
								};
								console.log($scope.delavec);
								var Indata = {
									'id' : parseInt($scope.id),
									'delavec' : $scope.delavec
								};
								var res = $http
										.post(
												"http://localhost:8080/NWPdwp/rest/tovarna/dodajZaposleni/",
												$scope.delavec);

								res.success(function(data, status, headers,
										config) {
									$scope.delavec = JSON.stringify(data);
								});
								res.error(function(data, status, headers,
										config) {
									alert("failure message: "
											+ JSON.stringify({
												data : data
											}));
								});
							};
							$scope.dodajz = function(id) {
								$scope.id=id;
								console.log($scope.id);
								return $scope.id;
							}
							$scope.printZ = function() {
								var reso = $http
										.get(
												"http://localhost:8080/NWPdwp/rest/tovarna/PrintZ/");
								reso.success(function(data, status, headers,
										config) {
									$scope.zaposleni = data;
									console.log(data);
								});
								reso.error(function(data, status, headers,
										config) {
									alert("failure message: "
											+ JSON.stringify({
												data : data
											}));
								});
							};
							$scope.deleteZ = function(id) {
								$scope.id=id;
								var reso = $http
										.post(
												"http://localhost:8080/NWPdwp/rest/tovarna/DeleteZ/", $scope.id);
								reso.success(function(data, status, headers,
										config) {
									$scope.zaposleni = data;
									console.log(data);
								});
								reso.error(function(data, status, headers,
										config) {
									alert("failure message: "
											+ JSON.stringify({
												data : data
											}));
								});
							};
							$scope.deleteT = function(id) {
								$scope.id=id;
								var reso = $http
										.post(
												"http://localhost:8080/NWPdwp/rest/tovarna/DeleteT/", $scope.id);
								reso.success(function(data, status, headers,
										config) {
									$scope.zaposleni = data;
									console.log(data);
								});
								reso.error(function(data, status, headers,
										config) {
									alert("failure message: "
											+ JSON.stringify({
												data : data
											}));
								});
							};
							$scope.ModifyT = function(tovar) {
								
								console.log(tovar);
								$scope.tovar=tovar;
								var reso = $http
										.post(
												"http://localhost:8080/NWPdwp/rest/tovarna/EditT", tovar.id);
								reso.success(function(data, status, headers,
										config) {
									$scope.tovar = data;
									console.log($scope.tovar);
								});
								reso.error(function(data, status, headers,
										config) {
									console.log("failure message: "
											+ JSON.stringify({
												data : data
											}));
								});
								return $scope.tovar;
							};
							$scope.SQLzapisZ = function(zapo) {
								var Indata = {
									'id' : parseInt(zapo.id),
									'delavec' : zapo.ImeDelavca,
								};
								console.log(zapo);
								var reso = $http
										.post(
												"http://localhost:8080/NWPdwp/rest/tovarna/zapisSQL", zapo);
								reso.success(function(data, status, headers,
										config) {
									$scope.zapo = data;
									console.log($scope.tovar);
								});
								reso.error(function(data, status, headers,
										config) {
									console.log("failure message: "
											+ JSON.stringify({
												data : data
											}));
								});
								return $scope.zapo;
							};
							$scope.SpremeniT = function(tovar) {
								
								console.log(tovar);
								$scope.tovar=tovar;
								var reso = $http
										.post(
												"http://localhost:8080/NWPdwp/rest/tovarna/SpremeniT", tovar);
								reso.success(function(data, status, headers,
										config) {
									$scope.tovar = data;
									console.log($scope.tovar);
								});
								reso.error(function(data, status, headers,
										config) {
									console.log("failure message: "
											+ JSON.stringify({
												data : data
											}));
								});
								return $scope.tovar;
							};
							$scope.ModifyZ = function(zap) {
								
								console.log(zap);
								$scope.tovar=zap;
								var reso = $http
										.post(
												"http://localhost:8080/NWPdwp/rest/tovarna/EditZ/", zap.id);
								reso.success(function(data, status, headers,
										config) {
									$scope.zap = data;
									console.log($scope.zap);
								});
								reso.error(function(data, status, headers,
										config) {
									console.log("failure message: "
											+ JSON.stringify({
												data : data
											}));
								});
								return $scope.zap;
							};
							$scope.SpremeniZ = function(zap) {
								
								console.log(zap);
								$scope.zap=zap;
								var reso = $http
										.post(
												"http://localhost:8080/NWPdwp/rest/tovarna/SpremeniZ/", $scope.zap);
								reso.success(function(data, status, headers,
										config) {
									$scope.zap = data;
									console.log($scope.zap);
								});
								reso.error(function(data, status, headers,
										config) {
									console.log("failure message: "
											+ JSON.stringify({
												data : data
											}));
								});
								return $scope.zap;
							};
							$scope.addTovarna = function(){
								var resou = $http
								.post("http://localhost:8080/NWPdwp/rest/tovarna/dodajTovarno", $scope.imeTovarne);
						resou.success(function(data, status, headers,
								config) {
							$scope.tovarne = data;
						});
						resou.error(function(data, status, headers,
								config) {
							alert("failure message: "
									+ JSON.stringify({
										data : data
									}));
						});
							}
							$scope.tovarna = function() {
								var resou = $http
										.get("http://localhost:8080/NWPdwp/rest/tovarna/Tovarna");
								resou.success(function(data, status, headers,
										config) {
									$scope.tovarne = data;
								});
								resou.error(function(data, status, headers,
										config) {
									alert("failure message: "
											+ JSON.stringify({
												data : data
											}));
								});
							};
						} ]);
