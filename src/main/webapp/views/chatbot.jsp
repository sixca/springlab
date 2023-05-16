<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<style>

        #me {
                width: 400px;
                height: 200px;
                overflow: auto;
                border: 2px solid blue;
        }
</style>

<script>
        let chatbot = {
                id:null,
                stompClient:null,
                init:function(){
                        this.id = $('#adm_id').text();
                        $("#connect").click(function() {
                                chatbot.connect();
                        });
                        $("#disconnect").click(function() {
                                chatbot.disconnect();
                        });
                        $("#sendme").click(function() {
                                chatbot.sendMe();
                        });
                },
                connect:function(){
                        var sid = this.id;
                        var socket = new SockJS('${adminserver}/chbot');  // admin 웹소켓에 접속
                        this.stompClient = Stomp.over(socket);  // 이 소켓을 넣어주고

                        this.stompClient.connect({}, function(frame) {   //접속 시도
                                chatbot.setConnected(true);
                                console.log('Connected: ' + frame);
                                this.subscribe('/chsend/'+sid, function(msg) {    //sid는 내 아이디..
                                        $("#me").prepend(
                                                "<h4>" + "Chatbot" +":"+
                                                JSON.parse(msg.body).content1+ "</h4>");
                                });
                        });
                },
                disconnect:function(){
                        if (this.stompClient !== null) {
                                this.stompClient.disconnect();
                        }
                        chatbot.setConnected(false);
                        console.log("Disconnected");
                },
                setConnected:function(connected){
                        if (connected) {
                                $("#status").text("Connected");
                        } else {
                                $("#status").text("Disconnected");
                        }
                },
                sendMe:function(){
                        var msg = JSON.stringify({
                                'sendid' : this.id,
                                'content1' : $('#metext').val()
                        });
                        this.stompClient.send("/chatbotme", {}, msg);  //내가 쓴 영역을 서버에 보내고.
                        $('#me').append(
                                '<h4>'+this.id+':'+$('#metext').val()+'</h4>'
                        );   //내가 쓴 영역을 화면에 출력
                        $('#metetxt').val('');  //내가 쓴 영역 지우기
                }
        };
        $(function(){
                chatbot.init();
        })

</script>
<!-- Begin Page Content -->
<div class="container-fluid">

        <!-- Page Heading -->
        <h1 class="h3 mb-2 text-gray-800">Chatbot</h1>

        <!-- DataTales Example -->
        <div class="card shadow mb-4">
                <div class="card-header py-3">
                        <h6 class="m-0 font-weight-bold text-primary">Chatbot</h6>
                </div>
                <div class="card-body">
                        <div id="container"></div>
                        <div class="col-sm-5">
                                <h1 id="adm_id">${logincust.id}</h1>
                                <H1 id="status">Status</H1>
                                <button id="connect">Connect</button>
                                <button id="disconnect">Disconnect</button>
                                <h3>Me</h3>

                                <input type="text" id="metext"><button id="sendme">Send</button>
                                <div id="me"></div>

                        </div>
                </div>
        </div>
        <!-- /.container-fluid -->
</div>