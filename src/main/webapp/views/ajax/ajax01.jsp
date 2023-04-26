<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<script>
    let ajax01 = {
      init:function (){
          //서버(url)에 요청해서 데이터를 가져온다, 결과에 따라서 얼랏창을 띄운다.

          //주기적으로 실행하는 자바스크립트 내장 함수 (2초 마다 호출)
          setInterval(function (){

              $.ajax({
                  url:'/getservertime',
                  success:function(data){
                      // alert(data);
                      ajax01.display(data);
                  },
                  error:function (){
                      alert('Error...')
                  }
              });
          }, 2000);
          //다른 부분은 가만히 있지만, 서버타임 표시 부분만 계속 바뀌는 중
          //비동기를 사용하는 이유. 요청, 요청, 요청!
          //asyncronous. 달리 논다!
      },
      display:function (data){
          //서버에서 데이터가 정상적으로 내려왔으면, 디스플레이 하라.
        $('#server_time').text(data);
      }
    };

    $(function (){
        ajax01.init();
    })

</script>

<%-- Main Center Start --%>
<div class="col-sm-8 text-left">
    <div class="container">
        <h3>AJAX01</h3>
        <h4>Server Time</h4>
        <h5 id="server_time"></h5>

    </div>
</div>
<%-- Main Center End --%>