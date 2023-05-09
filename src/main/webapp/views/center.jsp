<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--아래 태그 추가. 다국어 처리 위한 스프링 태그 라이브러리--%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>



<%-- Main Center Start --%>
<div class="col-sm-8 text-left">
  <h1><spring:message code="site.title"/></h1>
  <p><spring:message code="site.content"/></p>

  <h3>Test</h3>
  <p>Lorem ipsum...</p>
</div>
<%-- Main Center End --%>