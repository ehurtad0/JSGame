<%@ page import="com.joyscrum.GetSystemConfiguration" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Logon test via REST API</title>
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js">
    </script>
    <script src="https://apis.google.com/js/client:platform.js?onload=start" async defer>
    </script>

    <script>
        //client_id: '773332083832-eh42icaooprq2ojlr5jeupf8lkskoaub.apps.googleusercontent.com',
        function start() {
            gapi.load('auth2', function () {
                auth2 = gapi.auth2.init({

                   // client_id:'775229777373-sg76i1pt6aftuje5culvq6a3ougeanhd.apps.googleusercontent.com',
                    client_id:'848466945514-2cjm71hei0t5r4gvqaf9cucjjhocnpv1.apps.googleusercontent.com',
                    //client_id: '773332083832-eh42icaooprq2ojlr5jeupf8lkskoaub.apps.googleusercontent.com',
                    scope: 'profile'
                });
            });
        }
    </script>
</head>
<body>
<!--h1>Please logon with your credentials</h1-->

<button id="signinButton">Sign in with Google</button>
<script>
    $('#signinButton').click(function () {
        // signInCallback defined in step 6.
        //auth2.grantOfflineAccess().then(signInCallback);
        auth2.grantOfflineAccess().then(signInCallback);
    });

    function signInCallback(authResult) {
        if (authResult['code']) {
            $('#signinButton').attr('style', 'display: none');

            $.ajax({
                type: 'POST',
               // url: '/rest/api/player/validate',
                url: 'https://api.joyscrum.com/rest/api/AUTH',
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
                data: 'token=' + authResult['code']
            }).then(function(data,status,xhr){

            });
        } else {
            alert('Cannot logon on server');
        }
    }
</script>
</body>
</html>
