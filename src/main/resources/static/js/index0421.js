//login
let login_form={
    init:function (){
        $('#login_btn').click(function(){
            login_form.send();
        });
    },
    send:function (){
        $('#login_form').attr({
            'action':'/loginimpl',      //MainController에 보내는 Action
            'method':'post'
        });
        $('#login_form').submit();
    }
};

//register
let register_form={
    init:function (){   //클릭 시, send 후 register_form 초기화
        $('#register_btn').click(function(){
            register_form.send();
        });
    },
    send:function (){
        $('#register_form').attr({    // 속성 세팅
            'action':'/registerimpl',      //MainController에 보내는 Action
            'method':'post'
        });
        $('#register_form').submit();    // 제출 :: 서버로 데이터 전송
    }
};

//jsp01

let jsp01 = {
    data:0,
    init:function(num){
    this.data = num;
    // this.data = '<c:out values="${num}"/>';
    this.display();
    },
    display:function(){
        $('#jsp01').text(this.data+'');
    }
};
