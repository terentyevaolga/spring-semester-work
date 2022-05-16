let offset = 0;
const sliderLine = document.querySelector('.slider-films');

document.querySelector('.slider-next').addEventListener('click', function (){
    offset = offset + 260;
    if(offset > 768){
        offset = 0;
    }
    sliderLine.style.left = -offset + 'px';
});

document.querySelector('.slider-prev').addEventListener('click', function (){
    offset = offset - 260;
    if(offset < 0){
        offset = 768;
    }
    sliderLine.style.left = -offset + 'px';
})


let time = 0;
const slider = document.querySelector('.slider-serials');

document.querySelector('.slider-forward').addEventListener('click', function (){
    time = time + 205;
    if(time > 768){
        time = 0;
    }
    slider.style.left = -time + 'px';
});

document.querySelector('.slider-back').addEventListener('click', function (){
    time = time - 205;
    if(time < 0){
        time = 768;
    }
    slider.style.left = -time + 'px';
})
