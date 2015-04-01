<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="https://code.jquery.com/jquery-2.1.3.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script>
    <title>Welcome Traveller</title>
    <style>
            body {
            font-family: tahoma;
            font-size: 20px;
            color: #3B88F5;
            background-repeat: repeat-y;
            background-color: #292929;
            }

            #outPopUp{
            position:absolute;
            width:500px;
            height:200px;
            z-index:15;
            top:50%;
            left:50%;
            margin:-100px 0 0 -150px;
            }

            #desc {
                font-size: 10px;
                color:grey;
            }

            #entries {
                color: #ff6d33;
            }
    </style>
</head>
<body ng-app="myApp" ng-controller="myController">
    <div id="outPopUp" class="container">
        <div class="row">
            <div class="col">
                <input id="name" placeholder="What's your name?" ng-model="name" />
                <input id="send" type="button" value="submit" ng-click="send()" />
            </div>
        </div>

        <div class="row">
            <div class="col">
                <ul id="recent">
                    <div>There are {{messageCount}} submitted names!</div>
                    <div id="desc">Last message submitted at <span ng-bind ="lastMessage.toLocaleString()"/> </div>
                    <div id="entries" ng-repeat="message in messages">{{message.content}}</div>
                </ul>
            </div>
        </div>
    </div>
    <script>
        var myApp = angular.module('myApp', []);
        myApp.controller('myController', function($scope)  {
            $scope.messages = Array();
            $scope.name = "";
            $scope.lastMessage = 0;
            $scope.messageCount = 0;

            $scope.update = function() {
                console.log("hello");
                $.get("/api/messages/recent", function(json) {
                    console.log(json);
                    $scope.$apply(function () {
                        $scope.lastMessage = new Date(json.lastMessage);
                        $scope.messageCount = json.messageCount;
                        $scope.messages = Array();
                        $.each(json.messages, function (message) {
                            $scope.messages.push(json.messages[message].message)
                        });
                    });
                })
            };
            $scope.update();

            $scope.send = function() {
                var name = $scope.name;
                name = encodeURIComponent(name);
                $.post("/api/messages/names/" + name, function() {
                    $scope.$apply(function() {
                        $scope.name = "";
                    });
                    $scope.update();
                }).fail(function() {
                    $("#name").addClass("invalid input");
                });
            };

            $scope.$watch('[name]', function() {
                var valid = true;
                if($scope.name.length < 2) {
                    valid = false;
                }

                if(valid) {
                    $("#name").removeClass("invalid input");
                    $("#send").prop("disabled", false);
                } else {
                    if($scope.name.length > 0) {
                        $("#name").addClass("invalid input");
                    }
                    $("#send").prop("disabled", true);
                }
            });
        });
    </script>
</body>
</html>
