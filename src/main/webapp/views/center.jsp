<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<style>
  #w2{
    width:500px;
    border:2px solid red;
  }
</style>
<script>
<%-- 던져진 JSON을 서버에 요청해서 해체 뿌려야지 weather2를 수행하기 위한 AJAX --%>
  let center = {
    init:function(){
      $.ajax({
        url:'/weather3',
        success:function(data){
          //alert(data);  //data가 잘 들어왔나 확인용 :: 아러트창 [object Object] 라고 뜨는데, 기상청에서 받은 JSON 객체 통으로 받아 온 것을 알 수 있음. 앞으로 자바스크립트를 활용해서 여기서 object나 array를 추출해야지.
          center.display(data);
        }
      });
    },
    display:function (data){
      //var result = data.response.body.items.item[0].wfSv; // weather2
      var result = data.response.body.items.item; //weather3. item은 [] 배열임
      var txt = '';
      $(result).each(function (index, item){   //[]배열을 foreach문으로 돌리는 제이쿼리
        txt += '<h5>';
        txt += '일시: ' + item.tm + ' ' + '기온: ' + item.ta;
        txt += '</h5>';
      });
      $('#w2').html(txt);

      // alert(result);  //확인용
      // $('#w2').html(result);  weather2
    }
  };
  $(function(){
    center.init();
  });
</script>

<div class="col-sm-8 text-left">
  <h1><spring:message code="site.title"/></h1>
  <p><spring:message code="site.content"/></p>

  <hr>
  <textarea id="w1" cols="80" rows="10">${weatherinfo}</textarea>
<%--  <hr>  weather2-- %>
<%--  <textarea id="w2" cols="80" rows="10"></textarea>--%>
  <div id="w2"></div>
</div>
