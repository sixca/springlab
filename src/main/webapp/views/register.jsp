<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>
    //화면 로딩 시 init(); 함수 실행
    //즉, register_form 객체가 이벤트를 바인딩하고, 사용자가 register_btn 버튼을 클릭할 때 send 메서드를 호출할 수 있도록 준비
    $(function (){  // == document.ready
        register_form.init();
    });
</script>

<div class="col-sm-8">
    <div class="container">
        <div class="row content">
            <div class="col-sm-5 text-left">
                <h2>Register Page</h2>
                    <form id="register_form" class="form-horizontal well">
                        <div class="form-group">
                            <div class="col-sm-6">
                                <label for="id">ID:</label>
                                <input type="text" class="form-control" name="id" id="id" placeholder="Create ID...">
                                <button type="button" id="btnIdCheck" class="btn btn-default btn-sm">중복체크</button>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-6">
                                <label for="pwd">Password:</label>
                                <input type="password" class="form-control" name="pwd" id="pwd" placeholder="Input your PW...">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-6">
                                <label for="pwd">Password Check:</label>
                                <input type="password" class="form-control" name="pwdCheck" id="pwdCheck" placeholder="Input your PW again...">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-6">
                                <label for="name">name:</label>
                                <input type="text" class="form-control" name="name" id="name" placeholder="Input your Name...">
                            </div>
                        </div>
                        <div class="radio">
                            <label><input type="radio" name="optradio" checked>Male</label>
                        </div>
                        <div class="radio">
                            <label><input type="radio" name="optradio">Female</label>
                        </div><br/>
                        <div class="form-group">
                            <div class="col-sm-6">
                                <label for="birth">BirthDay:</label>
                                <input type="text" class="form-control" name="birth" id="birth" placeholder="YYYYMMDD">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-6">
                                <label for="email">Email:</label>
                                <input type="text" class="form-control" name="email" id="email" placeholder="Input your Email...">
                            </div>
                        </div>

                    </form>
                <button id="register_btn" type="button" class="btn btn-success">Register</button>
                <button type="button" class="btn btn-success">Go out</button>

            </div>
        </div>
    </div>
</div>
