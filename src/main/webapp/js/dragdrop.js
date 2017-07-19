$(function () {
    $("#dragdiv div.thumbnail").draggable();
    ({
//        helper: "clone",
        cursor: "move",

    });
    

    $("div[name='state']").droppable({
        cursor: "move",
        drop: function (event, ui) {
            //ui: element being dragged
            //this: element being dropped into
        	console.log("dragged");
        	draggedOperation(event, ui);

        },
        over: function (event, ui) {
            var $this = $(this);

        },
    });

    initDroppable($("#dropdiv table td"));

    function initDroppable($elements) {
        $elements
            .droppable({
                activeClass: "ui-state-default",
                hoverClass: "ui-drop-hover",
                over: function (event, ui) {
                    var $this = $(this);
                    console.log("dssdf");
                },
                drop: function (event, ui) {
                    var goalId = ui.draggable.text();
                    var goalName = $(ui.draggable).children()[1].innerHTML;
                    goalName = goalName.replace(goalId, "").trim();
                    var id = goalId.replace(goalName, "").trim();

                    $(this)[0].children[0].innerHTML = id;
                    $(this)[0].children[1].innerHTML = goalName;
                    
                    var hiddenLabelId = ($(ui.draggable).children()[0]).id;
                    var nameLabelId = ($(ui.draggable).children()[1]).id;
                  
                    var dragged = $($(ui.draggable).children()[1]).is("a.ui-droppable");
                    console.log("dssdf");

                    cleanContent(dragged, hiddenLabelId, nameLabelId);
                }
            });
    }

    function draggedOperation(event, ui){
    	//var draggedElement = event.srcElement.children[0].children[1];
    }
    
    function cleanContent(dragged, hiddenLabelId, nameLabelId) {
        
    	if(!dragged){
        	hiddenLabelId = '#' + hiddenLabelId;
        	nameLabelId = '#' + nameLabelId;
        	
        	$(nameLabelId)[0].innerHTML = "";
        	$(hiddenLabelId)[0].innerHTML = "";
    	}
    }
});


