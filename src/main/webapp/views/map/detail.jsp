<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- Main Center Start --%>
<div class="col-sm-8 text-left">
    <div class="container">
      <h3>Map Center</h3>
        <img src ="/uimg/${gmarker.img}"></img>
        <h4>${gmarker.id}</h4>
        <h4><a href="${gmarker.target}">${gmarker.title}</a></h4>

        <div class="row content">
            <div class="col-sm-6 text-left">
                <h3>Cust All Page</h3>
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>IMG</th>
                        <th>ITEM</th>
                        <th>Price</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="m" items="${mlist}">
                        <tr>
                            <td><img src="/uimg/${m.imgname}"></td>
                            <td>${m.item}</td>
                            <td>${m.price}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>     <%-- Table End --%>

    </div>
</div>
<%-- Main Center End --%>