<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="tag.jsp" %>
<%
    Object title = request.getAttribute("title");
    if (title == null) {
        title = "Instant-Francing";
    }
    request.setAttribute("title", title);
%>

<html>
    <head>
        <title>${title}</title>
        <link href="${contextPath}/css/main.css" rel="stylesheet">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" rel="stylesheet">
        <script type="text/javascript" src="../../js/page/search-bar.js"></script>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg bg-light">
            <div class="row w-100">
                <div class="col-2">
                    <a class="navbar-brand ms-3" href="${s:mvcUrl('AppHome#index').build()}">
                        <i class="fa-solid fa-car-burst"></i>
                    </a>
                </div>
                <div class="col-2">
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
<%--                        <div class="navbar-nav">--%>
<%--                            <a class="nav-link" href="${s:mvcUrl('AppListing#index').build()}">Listing</a>--%>
<%--                        </div>--%>
                    </div>
                </div>
                <div class="col-4">
                    <div class="main-container p-2">
                        <div class="d-flex">
                            <input type="text"
                                   class="form-control"
                                   placeholder="Recherche"
                                   data-search-bar-games
                                   style="width: 2500%;"
                            >
                            <a class="my-auto me-3 text-lg-end">
                                <img class="game-card-ico" src="https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/e8ddc4da-23dd-4502-b65b-378c9cfe5efa/dfgb852-b674c834-db71-49ae-9fb7-61e04ac1a9ad.png/v1/fill/w_1280,h_1280/black_pokeball_by_jormxdos_dfgb852-fullview.png?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOjdlMGQxODg5ODIyNjQzNzNhNWYwZDQxNWVhMGQyNmUwIiwiaXNzIjoidXJuOmFwcDo3ZTBkMTg4OTgyMjY0MzczYTVmMGQ0MTVlYTBkMjZlMCIsIm9iaiI6W1t7ImhlaWdodCI6Ijw9MTI4MCIsInBhdGgiOiJcL2ZcL2U4ZGRjNGRhLTIzZGQtNDUwMi1iNjViLTM3OGM5Y2ZlNWVmYVwvZGZnYjg1Mi1iNjc0YzgzNC1kYjcxLTQ5YWUtOWZiNy02MWUwNGFjMWE5YWQucG5nIiwid2lkdGgiOiI8PTEyODAifV1dLCJhdWQiOlsidXJuOnNlcnZpY2U6aW1hZ2Uub3BlcmF0aW9ucyJdfQ.JpYIlqmj61yLZJOxs9WVmn0qwLkJKH_icHUW6AnTFU8"></img>
                            </a>
                        </div>
                        <div class="search-response-container">
                        </div>
                    </div>
                </div>
                <div class="col-4"></div>
            </div>
        </nav>