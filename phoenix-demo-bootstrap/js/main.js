/*
 *  Copyright 2016-2020 the original author or authors.
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       QQ:1322874562  PHONE:13882946572
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

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
