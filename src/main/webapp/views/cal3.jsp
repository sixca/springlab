<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
    .fc-day-sun a {
        color: red;
    }

    .fc-day-sat a {
        color: blue;
    }
    /*  토,일요일 blue,red 색상변경  */
</style>
<script>
    function set_time(time){
        $('#ttime').text(time+':00');
        $('#next_btn').fadeIn();

    };

    $(function(){
        $('#next_btn').hide();
        $('#select_time').hide();


        var calendar = new FullCalendar.Calendar($('#calendar')[0], {
            googleCalendarApiKey : "AIzaSyDRBzd5FyLBEcbn0r3KBgmJ6xXJRIqZDvI",
            eventSources :[
                {
                    googleCalendarId : 'ko.south_korea.official#holiday@group.v.calendar.google.com'
                    , color: 'white'   // an option!
                    , textColor: 'red' // an option!
                }
            ],
            height: '580px', // calendar 높이 설정
            //expandColumns: true,
            expandRows: true, // 화면에 맞게 높이 재설정
            // 해더에 표시할 툴바
            headerToolbar: {
                left: 'prev,next today',
                center: 'title',
                right: 'dayGridMonth'
            },
            initialView: 'dayGridMonth', // 초기 로드 될때 보이는 캘린더 화면(기본 설정: 달)
            //initialDate: '2022-11-01', // 초기 날짜 설정 (설정하지 않으면 오늘 날짜가 보인다.)
            //navLinks: true, // 날짜를 선택하면 Day 캘린더나 Week 캘린더로 링크
            editable: true, // 수정 가능
            selectable: true, // 달력 일자 드래그 설정가능
            nowIndicator: true, // 현재 시간 마크
            dayMaxEvents: true, // 이벤트가 오버되면 높이 제한 (+ 몇 개식으로 표현)
            locale: 'ko', // 한국어 설정
            eventAdd: function(obj) { // 이벤트가 추가되면 발생하는 이벤트
                console.log(obj);
            },
            eventChange: function(obj) { // 이벤트가 수정되면 발생하는 이벤트
                console.log(obj);
            },
            eventRemove: function(obj){ // 이벤트가 삭제되면 발생하는 이벤트
                console.log(obj);
            },

            dateClick: function(info) {    // info에다가 date를 박아주고 끄집어 내는 구조.

                const date = new Date();

                const year = date.getFullYear();
                const month = ('0' + (date.getMonth() + 1)).slice(-2);
                const day = ('0' + date.getDate()).slice(-2);
                const dateStr = year + '-' + month + '-' + day;

                if(new Date(info.dateStr) < new Date(dateStr)){
                    alert('Fail');
                    return;
                }

                $('#tdate').text(info.dateStr);  //오늘의 날짜를 출력한다

                $('#ttime').text('');
                $.ajax({
                    url:'/gettime',
                    data:{tdate:info.dateStr}
                }).done(function(data){
                    var arr = data;
                    var html = '';
                    $(arr).each(function(index,item){
                        tt = item.substr(0,item.indexOf(':'));

                        html += '<div><a href="#" class="btn btn-sm btn-outline-primary ml-lg-4" onclick="set_time('+tt+')">'+item+'</a></div>';
                    });
                    $('#select_time').show();

                    $('#stime').html(html);
                });


            },
            events: '/getcal'

        });

        calendar.render();

        $('#next_btn').click(function(){
            var c  = confirm('에약하시겠습니까');
            if(c == true){
                var day = $('#tdate').text();
                var time = $('#ttime').text();
               location.href='/reservation?id=${logincust.id}&day='+day+'&time='+time;
            }

        });


    });
</script>
<div class="col-sm-8  text-left ">
    <div class="container">
        <div class="row content">
            <div class="col-sm-2  text-left ">
                <div class="container">
                    <h6>일자: <span id="tdate"></span></h6>
                    <h6>시간: <span id="ttime"></span></h6>
                    <h6 id="select_time">시간선택:<span id="stime"></span></h6>
                    <h6 id="next_btn"><a href="#" class="btn btn-sm btn-primary ml-lg-4">예약</a></h6>
                </div>
            </div>
            <div class="col-sm-6  text-left ">
                <div id='calendar-container'>
                    <div id='calendar'></div>
                </div>
            </div>
        </div>
    </div>
</div>

