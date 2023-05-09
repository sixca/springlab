<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>
    let item_get = {
        init:function(){
          $('#cart_btn').click(function (){
              let cust_id = '${logincust.id}';
              let item_id = ${gitem.id};  // jsp EL문법
              let cnt = $('#cnt').val();  // jQuery 문법 :: #cnt에 입력된 밸류를 값으로 받기
              $.ajax({
                  url:'/addcart',    // AjaxImplController
                  data:{cust_id:cust_id, item_id:item_id, cnt:cnt},
                  success:function(){
                      // alert('ok');  //function이 먹히는지 테스트해봄
                      $('#myModal').modal();
                  }
              });

              // alert(cust_id);
              // alert(item_id);
              // alert(cnt);


              // $('#cart_form').attr({
              //     method:'get',
              //     action:'/item/addcart'
              // });
              // $('#cart_form').submit();
          })
        }
    };
    $(function (){
        item_get.init();
    });

</script>

<%-- Main Center Start --%>
<div class="col-sm-8 text-left">
    <div class="container">
      <h3>Item info</h3>
        <img src="/uimg/${gitem.imgname}">
        <h4>ID: ${gitem.id}</h4>
        <h4>NAME: ${gitem.name}</h4>
        <h4>Price: ${gitem.price}</h4>
        <c:if test="${logincust != null}">
        <%-- 로그인을 해야만 갯수입력+등록 form이 보이도록  --%>
            <form id="cart_form" class="form-inline well">
                <input type="hidden" name="cust_id" value="${logincust.id}">
                <input type="hidden" name="item_id" value="${gitem.id}">
                <%-- 히든 타입을 잘 활용하여, 서버와 서버사이(?)의 값들을 전송할 수가 있습니다.--%>
                <%-- 값을 받지만 화면에는 숨겨두는 기능임:: form안에 이렇게 데이터 3개를 박아두면 버튼클릭 후 이동 URL 뒤에 주르륵 붙음 --%>
                <%-- http://127.0.0.1/item/addcart?cust_id=id88&item_id=111&cnt=2 --%>
                <div class="form-group">
                    <label for="cnt">Count:</label>
                    <input type="number" class="form-control" name="cnt" id="cnt" placeholder="Enter Count..">
                </div>
                <button type="button" id="cart_btn" class="btn btn-success">Cart 등록</button>
            </form>
        </c:if>
    </div>
</div>
<%-- Main Center End --%>

<!-- Modal -->
<div id="myModal" class="modal fade" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>
            <div class="modal-body">
                <a href="/item/allcart?id=${logincust.id}" class="btn btn-info" role="button">장바구니로 이동</a>
                <a href="/item/allpage" class="btn btn-info" role="button">계속 쇼핑</a>
            </div>
            <div class="modal-footer">
            </div>
        </div>
    </div>
</div>
<!-- Modal End-->