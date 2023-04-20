'<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>
    let register_form={
        init:function (){
            $('#register_btn').click(function(){
                register_form.send();
            });
        },
        send:function (){
            $('#register_form').attr({
                'action':'/registerimpl',      //MainController에 보내는 Action
                'method':'get'
            });
            $('#register_form').submit();
        }
    };

    //화면 로딩
    $(function (){
        register_form.init();
    });
</script>

<div class="col-sm-8">
    <div class="container">
        <h2>Register Page</h2>

            <form id="register_form" class="form-horizontal">
                <div class="form-group">
                    <label class="col-sm-2 control-label">ID</label>
                    <div class="col-sm-5">
                        <input class="form-control" id="focusedInput" type="text" name="id" id="id" value="Input your ID...">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Password</label>
                    <div class="col-sm-5">
                        <input class="form-control" type="password" name="pwd" id="pwd" value="Input your PW...">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Password Check</label>
                    <div class="col-sm-5">
                        <input class="form-control" type="password" value="Input your PW again...">
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">Name</label>
                    <div class="col-sm-5">
                        <input class="form-control" type="text" name="name" id="name" value="Input your Name...">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">E-mail</label>
                    <div class="col-sm-5">
                        <input class="form-control" type="text" value="Input your E-mail...">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Address</label>
                    <div class="col-sm-5">
                        <input class="form-control" type="text" value="Input your Address...">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Address2</label>
                    <div class="col-sm-5">
                        <input class="form-control" type="text" value="Input your Address in detail...">
                    </div>
                </div>
            </form>
        <button id="register_btn" type="button" class="btn btn-success">Register</button>
        <button type="button" class="btn btn-success">Go out</button>
        </div>
    </div>
</div>
