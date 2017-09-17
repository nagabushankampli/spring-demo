'use strict';

angular.module('crudApp').factory('ContactService',
    ['$localStorage', '$http', '$q', 'urls',
        function ($localStorage, $http, $q, urls) {

            var factory = {
                loadAllContacts: loadAllContacts,
                getAllContacts: getAllContacts,
                getContact: getContact,
                createContact: createContact,
                updateContact: updateContact,
                removeContact: removeContact
            };

            return factory;

            function loadAllContacts() {
                console.log('Fetching all Contacts');
                var deferred = $q.defer();
                $http.get(urls.CONTACT_SERVICE_API)
                    .then(
                        function (response) {
                            console.log('Fetched successfully all Contacts');
                            $localStorage.Contacts = response.data;
                            deferred.resolve(response);
                        },
                        function (errResponse) {
                            console.error('Error while loading Contacts');
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function getAllContacts(){
                return $localStorage.Contacts;
            }

            function getContact(id) {
                console.log('Fetching Contact with id :'+id);
                var deferred = $q.defer();
                $http.get(urls.CONTACT_SERVICE_API + id)
                    .then(
                        function (response) {
                            console.log('Fetched successfully Contact with id :'+id);
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while loading Contact with id :'+id);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function createContact(Contact) {
                console.log('Creating Contact');
                var deferred = $q.defer();
                $http.post(urls.CONTACT_SERVICE_API, Contact)
                    .then(
                        function (response) {
                            loadAllContacts();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                           console.error('Error while creating Contact : '+errResponse.data.errorMessage);
                           deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function updateContact(Contact, id) {
                console.log('Updating Contact with id '+id);
                var deferred = $q.defer();
                $http.put(urls.CONTACT_SERVICE_API + id, Contact)
                    .then(
                        function (response) {
                            loadAllContacts();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while updating Contact with id :'+id);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function removeContact(id) {
                console.log('Removing Contact with id '+id);
                var deferred = $q.defer();
                $http.delete(urls.CONTACT_SERVICE_API + id)
                    .then(
                        function (response) {
                            loadAllContacts();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while removing Contact with id :'+id);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

        }
    ]);