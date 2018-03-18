//窗体滚动事件开始==================================================
$(window).scroll(function(event) {
    headerInit();
});

function headerInit(){
    if($(this).scrollTop()>0){
        $("body").addClass("fixed-header-on");
    }else{
        $("body").removeClass("fixed-header-on");
    }
}
headerInit();
//窗体滚动事件结束==================================================

//首页事件的开始====================================================
/*var images = ["img/banner.jpg", "img/bg-image-1.jpg", "img/bg-image-2.jpg"];

$(".index").backstretch(images, {
    fade: 750,
    duration: 3000,
    preload: 1, //Use the lazy-loading functionality
    start: 2 //Optional - now starts with "dome.jpg"
});*/
//首页事件的结束====================================================

//滚动监听
$('body').scrollspy({ target: '#mynavbar' })

//平滑滚动
$(".navbar a").click(function(event) {
    var target = $(this.hash);
    $("html").animate({
        scrollTop:target.offset().top
    },1000);

});


//图集 的开始====================================================
$(".filter li a").click(function(){
    var filterValue =  $(this).attr('data-filter');
    $(".isotope-container").isotope({ filter: filterValue });

    $(this).parent().addClass('active').siblings().removeClass('active');

    return false;
});

//图集 的结束====================================================
