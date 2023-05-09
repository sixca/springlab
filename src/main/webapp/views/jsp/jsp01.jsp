<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--날짜 및 통화 표시 라이브러리--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<script>

    $(function (){
        jsp01.init(${num});
    })

</script>

<%-- Main Center Start --%>
<div class="col-sm-8 text-left">
    <div class="container">
        <h3 id="jsp01">JSP01</h3>
        <h3>${num}</h3>
        <h3><fmt:parseNumber integerOnly="true" type="number" value="${num}" /></h3>
        <h3><fmt:formatNumber value="${num}" type="currency" /></h3>
        <h3><fmt:formatNumber type="number" pattern="###.###$" value="${num}" /></h3>
        <h3>${num*2}</h3>

        <h3>${cdate}</h3>
        <h3><fmt:formatDate  value="${cdate}" pattern="yyyy-MM-dd:hhmmss" /></h3>
        <%--JSTL--%>

        <h3>${cust.id}</h3>
        <h3>${cust.name}</h3>
        <h3><c:out value="${cust.id}"/></h3>     <%--JSTL--%>
        <h3><c:out value="${cust.name}"/></h3>   <%--보안 증진 c:out . 실제로 입력된 값 자체를 출력--%>
        <c:set var="mynum" value="${num*3}"/>    <%--c:set 값 넣어두기, 향후 어디다가 뿌리어--%>
        <h5><c:out value="${mynum}"/></h5>       <%--c:out 내보내기--%>
    </div>
</div>
<%-- Main Center End --%>