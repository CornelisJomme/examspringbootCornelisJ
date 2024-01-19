<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="tag.jsp" %>
<jsp:include flush="true" page="base.jsp"/>

<div class="container">
    <h1>Instant-Centraling</h1>

    <h2 class="my-5">Dernières annonces</h2>
    <div class="row">
<%--        <p>${user.name}</p>--%>
        <c:forEach items="${listing}" var="listing">
            <a class="col-4 mt-2 main-game-card" href="${s:mvcUrl('AppHome#show').arg(0, model.slug).build()}">
                <div class="game-card">
                    <div class="user-card-img">
                        <img alt="${listing.title}" src="${listing.image}">
                    </div>
                    <div class="d-flex justify-content-between">
                        <p>${listing.title}</p>
                    </div>
                </div>
            </a>
        </c:forEach>
    </div>
</div>

<%@ include file="footer.jsp" %>
