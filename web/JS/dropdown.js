$(function(){
    var $index = -1;
    // Click li, slide down it and slide up other li.
    $(".nav>li").click(function(){
        if ($index === $(this).index()){ // If this li has already slide down, then slide up.
            var $sub = $(this).children(".sub");
            $sub.slideUp(500);
            $index = -1;
            $(this).removeClass("current"); // Remove bold text .

        }else { // If this li has not slided down
            $index = $(this).index();
            var $sub = $(this).children(".sub");
            $sub.slideDown(500);
            var $others = $(this).siblings();
            var $otherssub = $others.children(".sub");
            $otherssub.slideUp(500); // Other li slide up.

            $(this).addClass("current"); // Add bold text.
            $(this).siblings().removeClass("current");

        }
        return false;
    });

    // Prevent bubble event.
    $(".sub>li").click(function(){
        return false; // prevent bubble event.
    })
})