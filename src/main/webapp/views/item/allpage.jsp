<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%-- Main Center Start --%>
<style>
    .small_img {
        width: 40px;
    }
</style>

<div class="col-sm-8 text-left">
    <div class="container">
        <div class="row content">
            <div class="col-sm-6 text-left">
                <h3>Item All Page</h3>
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>IMG</th>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Price</th>
                        <th>rdate</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="obj" items="${cpage.getList()}">
                        <tr>
                            <td><img class="small_img" src="/uimg/${obj.imgname}"></td>
                            <td><a href="/item/get?id=${obj.id}">${obj.id}</a></td>
                            <td>${obj.name}</td>
                            <td><fmt:formatNumber value="${obj.price}" pattern="###,###원"/></td>
                            <td><fmt:formatDate value="${obj.rdate}" pattern="yyyy-MM-dd"/></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <jsp:include page="../page.jsp"/>
            </div>
        </div>     <%-- Table End --%>
    </div>
</div>
<%-- Main Center End --%>