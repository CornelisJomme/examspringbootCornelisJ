<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="tag.jsp" %>
<jsp:include flush="true" page="base.jsp"/>

<div class="container">
    <h1>Instant-Francing</h1>

    <h2 class="my-5">:aaaaa:</h2>
    <div class="row">
<%--        <p>${city.name}</p>--%>
        <c:forEach items="${region}" var="region">
            <a class="col-4 mt-2 main-game-card" href="${s:mvcUrl('AppRegion#show').arg(0, region.slug).build()}">
                <div class="game-card">
<%--                    <div class="city-card-img">--%>
<%--                        <img alt="${city.name}" src="${city.thumbnailCover}">--%>
<%--                    </div>--%>
                    <div class="d-flex justify-content-between">
                        <p>${region.name}</p>
<%--                        <p>${department.population}</p>--%>
                    </div>
                </div>
            </a>
        </c:forEach>
    </div>
</div>

<%@ include file="footer.jsp" %>
