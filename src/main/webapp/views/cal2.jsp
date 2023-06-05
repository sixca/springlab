<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>

    $(function(){

        var calendar = new FullCalendar.Calendar($('#calendar')[0], {
            // initialView: 'dayGridMonth',
            // initialDate: '2023-05-12',
            eventColor: 'green',
            themeSystem: 'materia',
            headerToolbar: {
                start: 'title',
                center: '',
                end: 'prev,next'
            },
            eventClick: function(info) {
                var eventObj = info.event;

                if (eventObj.url) {
                    alert(
                        'Clicked ' + eventObj.title + '.\n' +
                        'Will open ' + eventObj.url + ' in a new tab'
                    );

                    window.open(eventObj.url);

                    info.jsEvent.preventDefault(); // prevents browser from following link in current tab.
                } else {
                    alert('Clicked ' + eventObj.title);
                }
            },
            events: [
                {
                    title: 'All Day Event',
                    start: '2023-05-01'
                },
                {
                    title: 'Long Event',
                    start: '2023-05-07',
                    end: '2023-05-10',
                    color: 'purple' // override!
                },
                {
                    groupId: '999',
                    title: 'Repeating Event',
                    start: '2023-05-09T16:00:00'
                },
                {
                    groupId: '999',
                    title: 'Repeating Event',
                    start: '2023-05-16T16:00:00'
                },
                {
                    title: 'Conference',
                    start: '2023-05-11',
                    end: '2023-05-13',
                    color: 'purple' // override!
                },
                {
                    title: 'Meeting',
                    start: '2023-05-12T10:30:00',
                    end: '2023-05-12T12:30:00'
                },
                {
                    title: 'Lunch',
                    start: '2023-05-12T12:00:00'
                },
                {
                    title: 'Meeting',
                    start: '2023-05-12T14:30'
                },
                {
                    title: 'Birthday Party',
                    start: '2023-05-13T07:00:00'
                },
                {
                    title: 'Click for Google',
                    url: 'http://google.com/',
                    start: '2023-05-28'
                }
            ]
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