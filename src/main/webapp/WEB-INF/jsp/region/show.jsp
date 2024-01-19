<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../tag.jsp" %>
<jsp:include flush="true" page="../base.jsp"/>

<div class="container mt-5">
    <div class="row">
        <div class="col-6">
            <div class="container-img p-3">
            </div>
        </div>
        <div class="col-6">
            <h1>${region.name}</h1>
            <div class="d-flex">
            </div>
            <p class="m-0 mt-1">Code :
            </p>
            <p class="fs-2">${region.code} </p>
        </div>
    </div>

    <h2 class="my-5">Departments:</h2>
    <c:forEach items="${region.departments}" var="departs">
        <a class="col-4 mt-2 main-game-card" href="../department/${departs.slug}">
                <div class="d-flex justify-content-between">
                    <p>${departs.name}</p>
                </div>
            <br>
        </a>
    </c:forEach>

    <div class="text-center description">
    </div>


</div>

<%@ include file="../footer.jsp" %>
