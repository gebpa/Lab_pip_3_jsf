function usePicture(form, x, y) {

    x = x/233*13 - 6.5;
    y = 6.5 - y/232*13;

    var R = document.getElementsByClassName('R');
    for (i = 0; i < 5; i++) {
        if (R[i].checked === true) {
            console.log(x + " " + y + " " + R[i].value);
            $.ajax({
                url: "/lab2_dip-1.0/control",
                type: "get",
                data: {X: x, Y: y, R: R[i].value},
                success: function (data) {
                    drawPoints(data);
                }
            }, "json");
        }
    }

}



function drawPoints(data) {
   // alert(data.toString());

    // версия для html
    var elem = document.getElementById('aBody');
    elem.innerHTML += data.toString();
    var re = /-?\d+(\.\d+)?/g;
    var str = data;
    var arrayOfNumbers = str.match(re);
    var top = (6.5 - arrayOfNumbers[1])*232/13 - 5;
    var left = (6.5 + parseFloat(arrayOfNumbers[0]))*233/13 - 5;
    var d = document.createElement('div');
    d.className='div_one';
    if (str[str.length-15] === "ь"){
        $(d).css('background-color', 'red');
    }
    $(d).css({top: top, left: left});

    document.getElementsByClassName("img-wrapper")[0].appendChild(d);

}

function drawJSFPoints(x, y, r) {
    var vertical = (6.5 - y)*232/13 - 5;
    var horizontal = (6.5 + x)*233/13 - 5;
    var d = document.createElement('div');
    d.className='div_one';
    if (x<=0 & y<=0 & x>=-r & y>=-r/2.0 ){
    }
    else if(x>=0 & y>=0 & x<=r/2.0 & y<=r/2.0 & y*y+x*x<=(r/2.0)*(r/2.0)){
    }
    else if(x<=0 & y>=0 & x>=-r/1.0 & y<=r/1.0 & x+r/1.0>=y){
    }
    else $(d).css('background-color', 'red');

    $(d).css({top: vertical, left: horizontal});
}

function clickPictureJSF(horizontal, vertical, r) {

    var x = horizontal/233*13 - 6.5;
    var y = 6.5 - vertical/232*13;

    var d = document.createElement('div');
    d.className='div_one';
    if (x<=0 & y<=0 & x>=-r & y>=-r/2.0 ){
    }
    else if(x>=0 & y>=0 & x<=r/2.0 & y<=r/2.0 & y*y+x*x<=(r/2.0)*(r/2.0)){
    }
    else if(x<=0 & y>=0 & x>=-r/1.0 & y<=r/1.0 & x+r/1.0>=y){
    }
    else $(d).css('background-color', 'red');

    horizontal += -5;
    vertical += -5;
    $(d).css({top: vertical, left: horizontal});

    document.getElementsByClassName("img-wrapper")[0].appendChild(d);
    document.getElementById('formForShot:inputY').value = y;
    document.getElementById('formForShot:inputX').value=x;
    document.getElementById('formForShot:inputR').value=r;
    document.getElementById('formForShot:getResult').click();
}

