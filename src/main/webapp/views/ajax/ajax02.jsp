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
                $('#r_form > input[name=id]').keyup(function(){
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
                                $('#r_form > input[name="pwd"]').focus();  // pwd이름의 인풋태그로 포커스 (커서옮기기)
                            }else{
                                $('#r_form > #idspan').text('사용 불가능합니다.');
                            }
                        }
                    });
                });
            },
            sendevent:function (){}
        };

        $(function (){
            ajax02.init();
        })

</script>
<%-- Main Center Start --%>
<div class="col-sm-8 text-left">
    <div class="container">
        <h3>AJAX02</h3>
        <form id="r_form">
            ID : <input type="text" name="id"><span id="idspan"></span><br>
            PWD : <input type="text" name="pwd"><br>
            NAME : <input type="text" name="name"><br>
            <input type="button" value="Register"><br>
        </form>
    </div>
</div>