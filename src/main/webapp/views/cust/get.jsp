<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--register.jsp를 가져와서 cust datail 화면 구성--%>
<%--ID, PW, NAME만 다루고 있어서 좀 어색함요--%>
<div class="col-sm-8">
    <div class="container">
        <div class="row content">
            <div class="col-sm-5 text-left">
                <h2>detail Page</h2>
                    <form id="update_form" class="form-horizontal well">
                        <div class="form-group">
                            <div class="col-sm-6">
                                <label for="id">ID:</label>
                                <input type="text" class="form-control" name="id" id="id" value="${gcust.id}" readonly>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-6">
                                <label for="pwd">Password:</label>
                                <input type="text" class="form-control" name="pwd" id="pwd" value="${gcust.pwd}">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-6">
                                <label for="name">name:</label>
                                <input type="text" class="form-control" name="name" id="name" value="${gcust.name}">
                            </div>
                        </div>
                    </form>
                <button id="update_btn" type="button" class="btn btn-success">Update</button>
                <button id="remove_btn" type="button" class="btn btn-success">Remove</button>
            </div>
        </div>
    </div>
</div>
