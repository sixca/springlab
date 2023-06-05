<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="col-sm-2 sidenav">
  <p><a href="/pic">Pic</a></p>
  <c:if test="${logincust != null}">
    <p><a href="/websocket">websocket</a></p>
  </c:if>
  <p><a href="/cfr1">CFR1</a></p>
  <p><a href="/cfr2">CFR2</a></p>
  <p><a href="/ocr1">OCR1</a></p>
  <p><a href="/ocr2">OCR2</a></p>
  <p><a href="/cal1">cal1</a></p>
  <p><a href="/cal2">cal2</a></p>
  <p><a href="/cal3">cal3</a></p>
  <p><a href="/cal4">cal4</a></p>
  <p><a href="/cal5">cal5</a></p>
  <p><a href="/cal5">cal6</a></p>
</div>
