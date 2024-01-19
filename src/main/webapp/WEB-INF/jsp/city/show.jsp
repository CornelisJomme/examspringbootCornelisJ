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
            <h1>${city.name}</h1>
            <div class="d-flex">
            </div>
            <p class="m-0 mt-1">Population :
            </p>
            <p class="fs-2">${city.population} gens</p>
        </div>
    </div>

    <h2 class="my-5">Description</h2>

    <div class="text-center description">
    </div>


</div>

<%@ include file="../footer.jsp" %>
