<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../tag.jsp" %>
<c:set var="title" scope="request" value="Listing"/>
<jsp:include flush="true" page="../base.jsp"/>

<div class="container">
    <h1>Available listing</h1>
    <table class="table table-hover table-striped">
        <tbody>
        <c:forEach items="${listing.content}" var="listing">
            <tr>
                <td>
                        ${listing.title}
                </td>

            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<%@ include file="../footer.jsp" %>
