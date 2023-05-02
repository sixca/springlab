<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<script>

        let ajax02 = {
            init:function (){  //초기화
                this.keyupevent();
                this.sendevent();
            },
            keyupevent:function (){
                $('#r_form > input[name=id]').keyup(function(){    //keydown 함수는 사용자가 키를 누를 때 이벤트를 처리하고, keyup 함수는 사용자가 키에서 손을 떼었을 때 이벤트를 처리
                    var id = $(this).val();
                    if(id.length <= 3){
                        $('#r_form > #idspan').text('ID는 4자리 이상입니다.');
                        return;
                    };

                    $.ajax({   //value를 아작스로 전송한다
                        url:'/checkid',
                        data:{'id':id},    //id라는 이름으로 id값을 전송하겠다
                        success:function (result){
                            if(result == 0){
                                $('#r_form > #idspan').text('사용 가능합니다.');
                                $('#r_form > input[name="pwd"]').focus();  // pwd이름의 인풋태그로 포커스 (커서 옮기기)
                            }else{
                                $('#r_form > #idspan').text('사용 불가능합니다.');
                            }
                        }
                    });
                });
            },
            sendevent:function (){
                // 입력된 데이터를 서버로 전송하는 코드 작성
                // 예시로 아래와 같이 진행하면 됨. 구현은 안 함.
                var formData = $('#my-form').serialize(); // 폼 데이터를 직렬화
                $.ajax({
                    url: '/submit-data', // 서버 URL
                    type: 'POST', // 전송 방식
                    data: formData, // 전송할 데이터
                    success: function(response) {
                        // 전송이 성공하면 수행할 코드
                        alert('전송 성공');
                    },
                    error: function(xhr) {
                        // 전송이 실패하면 수행할 코드
                        console.log('전송 실패:', xhr.responseText);
                    }
                });
            }
        };

        $(function (){
            ajax02.init();
        })

        // 이렇게 버튼 클릭 시 실행하게 하면 되겠지
        $('#submit-btn').click(function(){
            ajax02.sendevent();
        });

</script>
<%-- Main Center Start --%>
<div class="col-sm-8 text-left">
    <div class="container">
        <h3>AJAX02</h3>
        <form id="r_form">
            ID : <input type="text" name="id"><span id="idspan"></span><br>
            PWD : <input type="password" name="pwd"><br>
            NAME : <input type="text" name="name"><br>
            <input type="button" id="submit-btn" value="Register"><br>
        </form>
    </div>
</div>