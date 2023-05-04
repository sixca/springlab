<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>

    //화면 로딩
    $(function (){
        login_form.init();
    });
</script>


<div class="col-sm-8">
    <div class="container">
        <div class="row content">
            <div class="col-sm-4 text-left">
                <h2>Login Page</h2>
                <form id="login_form" class="form-horizontal well">
                    <div class="form-group">
                        <label for="id">ID:</label>
                        <input type="text" class="form-control" name="id" id="id">
                    </div>
                    <div class="form-group">
                        <label for="pwd">Password:</label>
                        <input type="password" class="form-control" name="pwd" id="pwd">
                    </div>
                    <div class="checkbox">
                        <label><input type="checkbox" value="">remember ID..</label>
                    </div>
                </form>

                <button id="login_btn" class="btn btn-success">Log In</button>
                <button id="" class="btn btn-success">Go out</button>
            </div>
        </div>
    </div>
</div>

