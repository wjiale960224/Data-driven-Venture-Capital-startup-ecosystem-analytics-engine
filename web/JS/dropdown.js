$(function(){
    var $index = -1;
    // Click li, slide down it and slide up other li.
    $(".theme").click(function(){
        var $span = $(this).children(".tet");
        var $sub = $(this).children(".sub");
        if ($index === $(this).index()){ // If this li has already slide down, then slide up.
            $sub.slideUp(500);
            $index = -1;
            $span.removeClass("current"); // Remove bold text .

        }else { // If this li has not slided down
            $index = $(this).index();
            $sub.slideDown(500);
            var $others = $(this).siblings();
            var $otherssub = $others.children(".sub");
            $otherssub.slideUp(500); // Other li slide up.
            $span.addClass("current"); // Add bold text.
            $(this).siblings().children(".tet").removeClass("current");
        }
    });

    // Prevent bubble event.
/*    $(".nav").delegate(".sub li", "click", function (event){
        // alert("li click");
        event.stopPropagation();
        // return false; // prevent bubble event.
    });
    */
/*    $(".sub").delegate(".sub>li","click",function(){
        return false;
    });*/

    // $(".nav").click(function(){
    //     alert(".nav click");
    // });
})


/*
$(function(){
    var $index = -1;
    // Click li, slide down it and slide up other li.
    $(".nav>li:nth-child(3)").click(function(){
        var $span = $(this).children(".tet");
        var $sub = $(this).children(".sub");
        if ($index === $(this).index()){ // If this li has already slide down, then slide up.
            $sub.slideUp(500);
            $index = -1;
            $span.removeClass("current"); // Remove bold text .
        }else { // If this li has not slided down
            $index = $(this).index();
            $sub.slideDown(500);
            $span.addClass("current"); // Add bold text.
        }
    });

    // Prevent bubble event.
    $(".sub>li").click(function(){
        return false; // prevent bubble event.
    })
})
*/
