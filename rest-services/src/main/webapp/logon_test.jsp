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
        function start() {
            gapi.load('auth2', function () {
                auth2 = gapi.auth2.init({
                    client_id: '<%=GetSystemConfiguration.getValue().getGoogleClientId()%>',
                    scope: 'profile'
                });
            });
        }
        alert("<%=GetSystemConfiguration.getValue().getEnvironment()%>");
    </script>
</head>
<body>
<!--h1>Please logon with your credentials</h1-->

<button id="signinButton">Sign in with Google</button>
<script>
    $('#signinButton').click(function () {
        // signInCallback defined in step 6.
        auth2.grantOfflineAccess().then(signInCallback);
    });

    function signInCallback(authResult) {
        if (authResult['code']) {
            $('#signinButton').attr('style', 'display: none');

            $.ajax({
                type: 'POST',
                url: '/rest/api/player/validate',
                headers: {
                    'X-Requested-With': 'XMLHttpRequest'
                },
                contentType: 'application/x-www-form-urlencoded; charset=utf-8',
                success: function (result) {
                    console.log(result);
                    alert(result);
                },
                processData: false,
                data: 'token=' + authResult['code']
            });
        } else {
            alert('Cannot logon on server');
        }
    }
</script>
</body>
</html>
