<%--
  Created by IntelliJ IDEA.
  User: Zetto
  Date: 20.11.2019
  Time: 19:58
  To change this template use File | Settings | File Templates.
--%>
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

        body {
            background: #87CEEB;
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
<c:import url="header.jsp"/>
<main role="main">

    <div id="myCarousel" class="carousel slide" data-ride="carousel" style="left: 100px;width: 800px; height: 400px">

        <ol class="carousel-indicators">
            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
            <c:forEach var="offer" items="${list}" varStatus="loop">
                <li data-target="#myCarousel" data-slide-to=>"${loop.index}"></li>

            </c:forEach>
        </ol>

        <div class="carousel-inner">

            <%--                <td>${loop.index}</td>--%>

            <div class="carousel-item active">

                <img src="images/soldier.jpg" alt="Games"
                     preserveAspectRatio="xMidYMid slice" focusable="false" role="img" width="100%" height="100%">
                </img>
                <div class="container " width="100%" height="100%" style="font-family: Arial; ">
                    <div class="carousel-caption text-center "
                         style="background: rgba(128,0,128,0.7); border-radius: 2rem; text-align: center;">
                        <p>View offers for selling games created by other users or create your own! (authorization
                            required)</p>
                        <button class="btn btn-lg btn-primary " type="button">See offers</button>

                    </div>
                </div>
            </div>


            <c:forEach var="offer" items="${list}" varStatus="loop">
                <div class="carousel-item" style="position: relative; background-color:lavender;
                 font-family: Arial; font-size:150%; ">
                    <div class="row" style="position: absolute; top: 0; bottom: 0 ; left: 0; ">

                        <div class="col-sm-6" style="padding: unset">
                            <img src="images/doom.jpg" alt="Games"
                                 preserveAspectRatio="xMidYMid slice" focusable="false" role="img" width="100%"
                                 height="100%">
                            </img>
                        </div>
                        <div class="col-sm-5" style="background-color:lavender; padding: unset; text-align: center">
                            <h1>${offer.game.name}</h1>

                            <p>Genre: ${offer.game.genre.name}</p>

                            <c:choose>
                                <c:when test="${offer.game.exclusivity==0}">
                                    <p>Exclusivity: PS4 </p>
                                </c:when>
                                <c:when test="${offer.game.exclusivity==1}">
                                    <p>Exclusivity: XBOX ONE X </p>
                                </c:when>
                                <c:otherwise>
                                </c:otherwise>
                            </c:choose>
                            <h1>Cost ${offer.cost} ${offer.currency.name}</h1>


                            <form action="/game_offer.html" method="post">
                                <input type="hidden" name="id" value=${offer.id}>
                                <button class="btn btn-lg btn-primary" type="submit">To offer</button>
                            </form>


                                <%--                    </div>--%>
                        </div>
                    </div>
                </div>
            </c:forEach>

        </div>

        <a class="carousel-control-prev" href="#myCarousel" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="carousel-control-next" href="#myCarousel" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>


    <!-- Marketing messaging and featurettes
    ================================================== -->
    <!-- Wrap the rest of the page in another container to center all the content. -->

    <%--    <div class="container marketing">--%>

    <%--        <!-- Three columns of text below the carousel -->--%>
    <%--        <div class="row">--%>
    <%--            <div class="col-lg-4">--%>
    <%--                <img class="bd-placeholder-img  rounded-circle" width="250" height="250" src="games.jpeg" preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder: 140x140"><title>Placeholder</title><rect fill="#777" width="100%" height="100%"></rect></img>--%>
    <%--                <h2>Games</h2>--%>
    <%--                <p><a class="btn btn-secondary" href="#" role="button">Go to game offers »</a></p>--%>
    <%--            </div><!-- /.col-lg-4 -->--%>
    <%--            <div class="col-lg-4">--%>
    <%--                <img class="bd-placeholder-img  rounded-circle" width="250" height="250" src="consoles.jpg"--%>
    <%--                     preserveAspectRatio="xMidYMid slice" focusable="false" role="img"--%>
    <%--                     aria-label="Placeholder: 140x140"><title>Placeholder</title>--%>
    <%--                <rect fill="#777" width="100%" height="100%"></rect>--%>
    <%--                </img>--%>
    <%--                <h2>Consoles</h2>--%>
    <%--                <p><a class="btn btn-secondary" href="#" role="button">Go to console offers »</a></p>--%>
    <%--            </div><!-- /.col-lg-4 -->--%>
    <%--            <div class="col-lg-4">--%>
    <%--                <img class="bd-placeholder-img  rounded-circle" width="250" height="250" src="accessory.jpg"--%>
    <%--                     preserveAspectRatio="xMidYMid slice" focusable="false" role="img"--%>
    <%--                     aria-label="Placeholder: 140x140"><title>Placeholder</title>--%>
    <%--                <rect fill="#777" width="100%" height="100%"></rect>--%>
    <%--                </img>--%>
    <%--                <h2>Accessory</h2>--%>
    <%--                <p><a class="btn btn-secondary" href="#" role="button">Go to accessory offers »</a></p>--%>
    <%--            </div><!-- /.col-lg-4 -->--%>
    <%--        </div><!-- /.row -->--%>
    <%--    </div>--%>


</main>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>


</body>
</html>