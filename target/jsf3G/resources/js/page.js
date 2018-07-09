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
    document.getElementById('formForShot1:inputX').value = x;
    remoteChangeCommandX();
    document.getElementById('formForShot1:inputY1').value = y;
    remoteChangeCommandY();
    document.getElementById('formForShot1:inputR').value = r;
    remoteChangeCommandR();
    document.getElementById('formForShot1:inputI').value = 0;
    remoteChangeCommandI();
}

function drawJSFPointsFromTable(r) {
    if (r==-1){
        r=document.getElementById('formForShot:RR').value
    }
    $(".div_one").remove();
    var oTable = document.getElementById('results_data');
    var rowsCount = oTable.rows.length;
    for (var i = 0; i < rowsCount+1; i++){

        var oCells = oTable.rows.item(i).cells;
        var x = oCells.item(0).innerHTML;
        var y = oCells.item(1).innerHTML;
        console.log(x, y);
        // var r = oCells.item(2).innerHTML;
        var vertical = (6.5 - parseFloat(y))*232/13;
        var horizontal = (6.5 + parseFloat(x))*233/13 ;
        var d = document.createElement('div');
        d.className='div_one';
        if (x<=0 & y<=0 & x>=-r & y>=-r/2.0 ){
        }
        else if(x>=0 & y>=0 & x<=r/2.0 & y<=r/2.0 & y*y+x*x<=(r/2.0)*(r/2.0)){
        }
        else if(x<=0 & y>=0 & parseFloat(x)+r/1.0>=y){
        }
        else $(d).css('background-color', 'red');

        horizontal += -5;
        vertical += -5;
        $(d).css({top: vertical, left: horizontal});

        document.getElementsByClassName("img-wrapper")[0].appendChild(d);
        console.log(d);
    }
}
function drawJSFPointsTable() {
    $(".div_one").remove();
    var oTable = document.getElementById('results_data');
    var rowNumber = oTable.rows.length;
    for (i = 0; i < rowNumber; i++){
        var oCells = oTable.rows.item(i).cells;
        var x = oCells.item(0).innerHTML;
        var y = oCells.item(1).innerHTML;
        var r = oCells.item(2).innerHTML;
        var vertical = (6.5 - parseFloat(y))*232/13;
        var horizontal = (6.5 + parseFloat(x))*233/13 ;
        var d = document.createElement('div');
        d.className='div_one';
        if (x<=0 & y<=0 & x>=-r & y>=-r/2.0 ){
        }
        else if(x>=0 & y>=0 & x<=r/2.0 & y<=r/2.0 & y*y+x*x<=(r/2.0)*(r/2.0)){
        }
        else if(x<=0 & y>=0 & parseFloat(x)+r/1.0>=y){
        }
        else $(d).css('background-color', 'red');

        horizontal += -5;
        vertical += -5;
        $(d).css({top: vertical, left: horizontal});

        document.getElementsByClassName("img-wrapper")[0].appendChild(d);
    }
}
function changeColor(id) {
    $(".x").css('background-color', 'white');
    $(id).css('background-color', 'red');
}
