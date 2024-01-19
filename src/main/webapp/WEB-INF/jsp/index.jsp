<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="tag.jsp" %>
<jsp:include flush="true" page="base.jsp"/>

<div class="container">
    <h1>Instant-Centraling</h1>

    <h2 class="my-5">Dernières annonces</h2>
    <div class="row">
        <c:forEach items="${listing}" var="listing">
            <a class="col-4 mt-2 main-game-card" href="${s:mvcUrl('AppListing#show').arg(0, listing.slug).build()}">
                <div class="game-card">
                    <div class="container-img img">
                        <img alt="${listing.title}" src="${listing.image}">
                    </div>
                    <p>${listing.model.name} </p>
                    <p>${listing.price}￠ </p>
                </div>
            </a>
        </c:forEach>
    </div>
</div>

<%@ include file="footer.jsp" %>
