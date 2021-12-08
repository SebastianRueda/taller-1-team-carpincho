
$(document).ready(function(){

    $('.ir-arriba').click(function(){
        $('body, html').animate({
            scrollTop: '0px'
        }, 300);
    });

    $(window).scroll(function(){
        if( $(this).scrollTop() > 0 ){
            $('.ir-arriba').slideDown(300);
        } else {
            $('.ir-arriba').slideUp(300);
        }
    });

});

function countChars(obj){
    var maxLength = 250;
    var strLength = obj.value.length;
    var charRemain = (maxLength - strLength);

    if(charRemain < 0){
        document.getElementById("charNum").innerHTML = '<span style="color: red;">EXCEDISTE EL LIMITE DE '+maxLength+' CARACTERES PERMITIDOS</span>';
    }else if(charRemain < 100){
        document.getElementById("charNum").innerHTML = '<span style="color: orange;"> '+charRemain+' CARACTERES RESTANTES</span>';
    }else{
        document.getElementById("charNum").innerHTML = '<span style="color: green;"> '+charRemain+' CARACTERES DISPONIBLES</span>';
    }
}