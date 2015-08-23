/*********************************************************************
 *<p>处理内容：平台  公共JAVASCRIPT GRID </p>
 *<p>Copyright: Copyright (c) 2011</p>
 * @author 方立文 改版履历<br>
 * @version Rev - Date ------- Name ---------- Note<br>
 * @------- 1.0 --2013.3.2---- 方立文 --------- 新规作成<br>
 ***********************************************************************/
 
 function Form()
 {
 	$.metadata.setType("attr", "validate");
 	var v= $("form").validate({
	          /*调试状态，不会提交数据的*/
                debug: true,
                errorPlacement: function (lable, element) {

                    if (element.hasClass("l-textarea")) {
                        element.addClass("l-textarea-invalid");
                    }
                    else if (element.hasClass("l-text-field")) {
                        element.parent().addClass("l-text-invalid");
                    }

                    var nextCell = element.parents("td:first").next("td");
                    nextCell.find("div.l-exclamation").remove(); 
                    $('<div class="l-exclamation" title="' + lable.html() + '"></div>').appendTo(nextCell)
                    element.parents("td:first").ligerTip(); 
                },
                success: function (lable) {
                    var element = $("#" + lable.attr("for"));
                    var nextCell = element.parents("td:first").next("td");
                    if (element.hasClass("l-textarea")) {
                        element.removeClass("l-textarea-invalid");
                    }
                    else if (element.hasClass("l-text-field")) {
                        element.parent().removeClass("l-text-invalid");
                    }
                    nextCell.find("div.l-exclamation").remove();
                },
	              /*调试状态，不会提交数据的*/
	             submitHandler: submitHandler 
	            });
 	return v;
 }