<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
</script>

<div class="col-sm-8  text-left ">
    <div class="container">
        <div class="row content">
            <div class="col-sm-6  text-left ">
                <h1>CFR2 Page</h1>
                <p>Emotion: ${result.emotion}</p>
                <p>Pose: ${result.pose}</p>
                <p>Gender: ${result.gender}</p>
                <p>Age: ${result.age}</p>
                <form action="/cfr2impl" method="post" enctype="multipart/form-data" id="cfr2_form" class="form-horizontal well">
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="img">Image:</label>
                        <div class="col-sm-10">
                            <input type="file" name="img" class="form-control" id="img" placeholder="Input Image">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button id="cfr2_btn" type="submit" class="btn btn-default">Send</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>