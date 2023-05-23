<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
    // let cfr1_form = {
    //     init:function(){
    //         $('#cfr1_btn').click(function(){
    //             cfr1_form.send();
    //         });
    //     },
    //     send:function(){
    //         $('#cfr1_form').attr({
    //             'action':'/cfr1impl',
    //             'method':'post'
    //         });
    //         $('#cfr1_form').submit();
    //     }
    // };
    // $(function(){
    //     cfr1_form.init();
    // });
</script>
<div class="col-sm-8  text-left ">
    <div class="container">
        <div class="row content">
            <div class="col-sm-6  text-left ">
                <h1>OCR2 Page</h1>
                <h2>${result.country}</h2>
                <h2>${result.num}</h2>
                <h2>${result.surname}</h2>
                <h2>${result.name}</h2>
                <h2>${result.birth}</h2>
                <h2>${result.start}</h2>
                <h2>${result.end}</h2>
                <form action="/ocr2impl" method="post" enctype="multipart/form-data" id="ocr2_form" class="form-horizontal well">
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="img">Image:</label>
                        <div class="col-sm-10">
                            <input type="file" name="img" class="form-control" id="img" placeholder="Input Image">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button id="ocr2_btn" type="submit" class="btn btn-default">Send</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>