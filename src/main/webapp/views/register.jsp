<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>
    let register_form={
        init:function (){   //클릭 시, send 후 register_form 초기화
            $('#register_btn').addClass('disabled');    //비활성화 시켜버림

            $('#register_btn').click(function(){
                register_form.send();
            });
            $('#name').keyup(function(){
                var id = $('#id').val();
                var pwd = $('#pwd').val();
                var name = $('#name').val();
                if(id != '' && pwd != '' && name != ''){
                    $('#register_btn').removeClass('disabled');   // 다 채워지면 버튼 활성화. (비활성화 크래스 삭제)
                }
            });
            $('#id').keyup(function(){

                var txt_id = $(this).val();
                if(txt_id.length <= 3 ){
                    return;
                }
                $.ajax({   //value를 아작스로 전송한다
                    url:'/checkid',
                    data:{'id':txt_id},    //id라는 이름으로 id값을 전송하겠다
                    success:function (result){
                        if(result == 0){
                            $('#check_id').text('사용 가능합니다.');
                            $('#pwd').focus();  // pwd이름의 인풋태그로 포커스 (커서 옮기기)
                        }else{
                            $('#check_id').text('사용 불가능합니다.');
                        }
                    }
                });
            });
        },
        send:function (){
            var id = $('#id').val();
            var pwd = $('#pwd').val();
            var name = $('#name').val();
            if(id.length <= 3){
                $('#check_id').text('4자리 이상이어야 합니다');
                $('#id').focus();
                return;
            }
            if(pwd == ''){
                $('#pwd').focus();
                return;
            }
            if(name == ''){
                $('#name').focus();
                return;
            }
            //비었는지 안 비었는지 체크, 공백이면 안 날라가게

            $('#register_form').attr({    // 속성 세팅
                'action':'/registerimpl',      //MainController에 보내는 Action
                'method':'post'
            });
            $('#register_form').submit();    // 제출 :: 서버로 데이터 전송
        }
    };
    //화면 로딩 시 init(); 함수 실행
    //즉, register_form 객체가 이벤트를 바인딩하고, 사용자가 register_btn 버튼을 클릭할 때 send 메서드를 호출할 수 있도록 준비
    $(function (){  // == document.ready
        register_form.init();
    });
</script>

<div class="col-sm-8 text-left">
    <div class="container">
        <div class="row content">
            <div class="col-sm-6  text-left ">
                <h1>Register Page</h1>
                <form id="register_form" class="form-horizontal well">
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="id">ID:</label>
                        <div class="col-sm-10">
                            <input type="text" name="id" class="form-control" id="id" placeholder="Enter id">
                        </div>
                        <div class="col-sm-10">
                            <span id="check_id" class="bg-danger"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="pwd">Password:</label>
                        <div class="col-sm-10">
                            <input type="password" name="pwd" class="form-control" id="pwd" placeholder="Enter password">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="name">NAME:</label>
                        <div class="col-sm-10">
                            <input type="text" name="name" class="form-control" id="name" placeholder="Enter name">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button id="register_btn" type="button" class="btn btn-default">Register</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>