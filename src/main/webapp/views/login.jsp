<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>
    let login_form={
        init:function (){
            $('#login_btn').click(function(){
                    login_form.send();
                });
        },
        send:function (){
            $('#login_form').attr({
                'action':'/loginimpl',      //MainController에 보내는 Action
                'method':'get'
            });
            $('#login_form').submit();
            }
        };

    //화면 로딩
    $(function (){
        login_form.init();
    });
</script>


<div class="col-sm-8">
    <div class="container">
        <div class="row content">
            <div class="col-sm-6 text-left">
                <h2>Login Page</h2>
                <form id="login_form" class="form-horizontal well">
                    <div class="form-group">
                        <label class="col-sm-1 control-label" for="id">ID</label>
                        <div class="col-sm-8">
                            <input class="form-control" name="id" id="id" type="text" value="Input your ID...">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-1 control-label" for="pwd">Password</label>
                        <div class="col-sm-8">
                            <input class="form-control" name="pwd" id="pwd" type="password" value="Input your PWD...">
                        </div>
                    </div>
                </form>
                <div class="radio">
                    <label><input type="radio" name="rememberID" checked>remember ID..</label>
                </div>
                <button id="login_btn" class="btn btn-success">Log In</button>
                <button id="" class="btn btn-success">Go out</button>
            </div>
        </div>
    </div>
</div>

