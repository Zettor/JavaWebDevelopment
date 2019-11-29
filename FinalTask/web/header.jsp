<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Пример на bootstrap 4: Карусель, навигационная панель и новые компоненты.">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/carousel.css"/>


    <title>Слайдер | Carousel Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->

    <style>

        body{
            background: url("images/background.jpg");
            background-size: cover ;
        }

        .form-signin {
            width: 100%;
            max-width: 330px;
            padding: 15px;
            margin: auto;
        }

        .form-signin .checkbox {
            font-weight: 400;
        }

        .form-signin .form-control {
            position: relative;
            box-sizing: border-box;
            height: auto;
            padding: 10px;
            font-size: 16px;
        }

        .form-signin .form-control:focus {
            z-index: 2;
        }

        .form-signin input[type="email"] {
            margin-bottom: -1px;
            border-bottom-right-radius: 0;
            border-bottom-left-radius: 0;
        }

        .form-signin input[type="password"] {
            margin-bottom: 10px;
            border-top-left-radius: 0;
            border-top-right-radius: 0;
        }


        .modal-header, .modal-footer {
            border: none;
        }

        .form-control:focus {
            border-color: #4B0082;
            outline: 0;
            -webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075), 0 0 8px rgba(102, 175, 233, .6);
            box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075), 0 0 8px rgba(102, 175, 233, .6);
        }

        .bd-placeholder-img {
            font-size: 1.125rem;
            text-anchor: middle;
        }

        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }

        .navbar {
            padding-top: 23;
            height: 60px;
            line-height: 60px;
        }
    </style>
    <!-- Custom styles for this template -->

</head>
<body>


<script type="text/javascript" async="" src="https://mc.yandex.ru/metrika/watch.js"></script>
<script async="" src="https://www.google-analytics.com/analytics.js"></script>
<script>
    (function (i, s, o, g, r, a, m) {
        i['GoogleAnalyticsObject'] = r;
        i[r] = i[r] || function () {
            (i[r].q = i[r].q || []).push(arguments)
        }, i[r].l = 1 * new Date();
        a = s.createElement(o),
            m = s.getElementsByTagName(o)[0];
        a.async = 1;
        a.src = g;
        m.parentNode.insertBefore(a, m)
    })(window, document, 'script', 'https://www.google-analytics.com/analytics.js', 'ga');

    ga('create', 'UA-4481610-59', 'auto');
    ga('send', 'pageview');

</script>

<!-- Yandex.Metrika counter -->
<script type="text/javascript"> (function (d, w, c) {
    (w[c] = w[c] || []).push(function () {
        try {
            w.yaCounter39705265 = new Ya.Metrika({
                id: 39705265,
                clickmap: true,
                trackLinks: true,
                accurateTrackBounce: true,
                webvisor: true
            });
        } catch (e) {
        }
    });
    var n = d.getElementsByTagName("script")[0], s = d.createElement("script"), f = function () {
        n.parentNode.insertBefore(s, n);
    };
    s.type = "text/javascript";
    s.async = true;
    s.src = "https://mc.yandex.ru/metrika/watch.js";
    if (w.opera == "[object Opera]") {
        d.addEventListener("DOMContentLoaded", f, false);
    } else {
        f();
    }
})(document, window, "yandex_metrika_callbacks"); </script>
<noscript>
    <div><img src="https://mc.yandex.ru/watch/39705265" style="position:absolute; left:-9999px;" alt="Yandex.Metrika"/>
    </div>
</noscript> <!-- /Yandex.Metrika counter -->

<header>
    <nav class="navbar navbar-expand-md navbar-dark fixed-top  " style="background-color:#000080;">

        <ul class="navbar-nav mr-auto">

        </ul>
        <form class="form-inline mt-2  mt-md-0">
            <a href="/.html" class="form-inline mt-2  mt-md-0" aria-label="Bootstrap">
                <img src="images/logo.png" alt="Logo" style="width:40px; position:absolute; left:20px" ;>
            </a>
        </form>
        <form class="form-inline mt-2  mt-md-0">
            <input class="form-control mr-2" type="text" placeholder="Search" aria-label="Search">
            <button class="btn btn-primary  mr-2" type="submit">Search</button>
        </form>

        <c:choose>
            <c:when test="${sessionScope.user.role==0}">
                <form class="form-inline mt-2  mt-md-0" action="/profile.html" method="post">
                    <button type="submit" class="btn btn-warning mr-2 " data-toggle="modal" data-target="#account">My
                        account
                    </button>
                </form>
                <form class="form-inline mt-2  mt-md-0" action="/logout.html" method="post">
                    <button type="submit" class="btn btn-warning mr-2 " data-toggle="modal" data-target="#account">Logout
                    </button>
                </form>

            </c:when>
            <c:when test="${sessionScope.user.role==1}">
                <form class="form-inline mt-2  mt-md-0" action="/profile.html" method="post">
                    <button type="submit" class="btn btn-warning mr-2 " data-toggle="modal" data-target="#account">My
                        account
                    </button>
                </form>
                    <form class="form-inline mt-2  mt-md-0" action="/settings.html" method="post">
                    <button type="submit" class="btn btn-warning mr-2 " data-toggle="modal" data-target="#settings">
                        Settings
                    </button>
                </form>
                <form class="form-inline mt-2  mt-md-0" action="/logout.html" method="post">
                    <button type="submit" class="btn btn-warning mr-2 " data-toggle="modal" data-target="#account">Logout
                    </button>
                </form>


            </c:when>
            <c:otherwise>
                <form class="form-inline mt-2  mt-md-0">
                    <button type="button" class="btn btn-warning mr-2 " data-toggle="modal" data-target="#sign-in">
                        Sign-in
                    </button>

                    <button type="button" class="btn btn-warning " data-toggle="modal" data-target="#sign-up">Sign-up
                    </button>
                </form>
            </c:otherwise>
        </c:choose>
    </nav>
</header>



    <div class="modal" id="sign-in">
        <div class="modal-dialog">
            <div class="modal-content">

                <!-- Modal Header -->
                <div class="modal-header" style="background-color:#87CEFA;">
                    <h4 class="modal-title">Sign-in</h4>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>

                <!-- Modal body -->
                <div class="modal-body clearfix " style="background-color:#87CEFA;">
                    <form class="form-signin" action="/sign_in.html" method="post">
                        <input type="login" id="inputLogin" class="form-control" placeholder="Login" required=""
                               name="login"
                               oninvalid="this.setCustomValidity('Please enter valid login')"
                               oninput="setCustomValidity('')" autofocus="">
                        <label for="inputPassword" class="sr-only">Password</label>
                        <input type="password" id="inputPassword" class="form-control" placeholder="Password"
                               name="password"
                               required="" oninvalid="this.setCustomValidity('Please enter valid password')"
                               oninput="setCustomValidity('')">
                        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
                    </form>
                </div>

            </div>
        </div>
    </div>

    <div class="modal" id="sign-up">
        <div class="modal-dialog">
            <div class="modal-content">

                <!-- Modal Header -->
                <div class="modal-header" style="background-color:#87CEFA;">
                    <h4 class="modal-title">Sign-up</h4>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>

                <!-- Modal body -->
                <div class="modal-body clearfix " style="background-color:#87CEFA;">
                    <form class="form-signin" action="/sign_up.html" method="post">
                        <input type="login" id="login" class="form-control" placeholder="login" required="" name="login"
                               oninvalid="this.setCustomValidity('Please enter valid login')"
                               oninput="setCustomValidity('')" autofocus="">
                        <input type="email" id="email" class="form-control" placeholder="email" required="" name="email"
                               oninvalid="this.setCustomValidity('Please enter valid email')"
                               oninput="setCustomValidity('')" autofocus="">
                        <input type="password" id="password" class="form-control" placeholder="password" name="password"
                               required="" oninvalid="this.setCustomValidity('Please enter valid password')"
                               oninput="setCustomValidity('')">
                        <div class="checkbox mb-3">
                            <label>
                                <input type="checkbox" value="remember-me"> Remember me
                            </label>
                        </div>
                        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
                    </form>
                </div>

            </div>
        </div>
    </div>
</body>
</html>
