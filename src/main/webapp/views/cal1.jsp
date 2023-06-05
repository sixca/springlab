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

    $(function(){

        var calendar = new FullCalendar.Calendar($('#calendar')[0], { //id=calendar에 달력을 뿌리겠다
            height: '600px', // calendar 높이 설정
            headerToolbar: {
                start: 'dayGridMonth,timeGridWeek,timeGridDay custom1',
                center: 'title',
                end: 'custom2 prevYear,prev,next,nextYear'
            },
            footerToolbar: {
                start: 'custom1,custom2',
                center: '',
                end: 'prev,next'
            },
            customButtons: {
                custom1: {
                    text: 'custom 1',
                    click: function() {
                        alert('clicked custom button 1!');
                    }
                },
                custom2: {
                    text: 'custom 2',
                    click: function() {
                        alert('clicked custom button 2!');
                    }
                }
            }
        });

        calendar.render();

    });
</script>
<div class="col-sm-8  text-left ">
    <div class="container">
        <div class="row content">
            <div class="col-sm-8  text-left ">
                    <div id='calendar-container'>
                        <div id='calendar'></div>
                    </div>
            </div>
        </div>
    </div>
</div>