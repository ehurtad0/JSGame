<%@ page import="com.joyscrum.GetSystemConfiguration" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Logon test via REST API</title>
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js">
    </script>
    <script src="https://trello.com/1/client.js?key=a4d7a84499b75658db7a0459d5f9ae5a"></script>
    <script>

        var authenticationSuccess = function() { console.log('Successful authentication');

            Trello.get('members/me',function(data){

//                $.post("https://api.joyscrum.com/rest/AUTH/trello")

                $.ajax({
                    type: 'POST',
                    // url: '/rest/api/player/validate',
                    url: '/rest/api/AUTH/trello',
                    headers: {
                        'X-Requested-With': 'XMLHttpRequest'
                    },
                    contentType: 'application/x-www-form-urlencoded; charset=utf-8',
                    success: function (result,b,c) {
                        console.log(result);
                        alert(result);
                        alert(c.getResponseHeader('jwt'));
                    },
                    processData: false,
                    data: 'token=' + Trello.token()
                }).then(function(data,status,xhr){

                });
            },function(a,b,c){debugger;})
        };
        var authenticationFailure = function() { console.log('Failed authentication'); };
    </script>
</head>
<body>
<!--h1>Please logon with your credentials</h1-->

<button id="signinButton">Sign in with Trello</button>
<script>
    $(document).ready(function(){
        $("#signinButton").bind('click',function(){
            Trello.authorize({
                type: 'popup',
                name: 'Getting Started Application',
                scope: {
                    read: 'true',
                    write: 'false' },
                expiration: '1hour',
                success: authenticationSuccess,
                error: authenticationFailure
            });
        });
    });

</script>
</body>
</html>
