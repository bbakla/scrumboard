$(document).ready(function() {    
    
    $('.drag').draggable({
        cursor: "move",
        appendTo: "body",
        revert: "invalid",
        opacity: 0.5,
                
        start: function (event, ui) {
        //store the id and element of the input td when dragging div away, to use in php later
            var inputElement=$(this).closest('td').find('div');
        }        
    });
    
    $('.drop').droppable({
      accept: ".drag",
      tolerance: "pointer",
      snap: ".drop",
      revert: "invalid",
      drop: function (event, ui) {
        //ui: div element being dragged
        //this: td element being dropped into

          var dragged =$(ui.draggable);
          var dropped=$(this);
          
          if(dropped.has(".ui-draggable").length != 0) {
        	  dragged.draggable({ revert: "valid" });
        	  return;
          }
        	  var droppedId = dropped.attr("id").split("-");
        	  
        	  var status = droppedId[2];
        	  
              var newDraggedId = dragged.attr("id").split("-")[0] + "-" + status;
              dragged.attr("id", newDraggedId);
              
              var classes = dragged.attr("class").split(" ");
              
              $.each(classes, function(index, item) {
            	    if (item.includes('status_')) {
            	        dragged.removeClass(item);
            	    }
            	});
              
              if(status == "NOT_STARTED") {
            	  dragged.addClass("status_not_started");
              } else if (status == "ANALYSED") {
            	  dragged.addClass("status_analysed");
              } else if (status == "IN_PROGRESS") {
            	  dragged.addClass("status_in_progress")
              } else if (status == "COMPLETED") {
            	  dragged.addClass("status_completed");
              } else if (status == "VERIFIED") {
            	  dragged.addClass("status_verified");
              } else if (status == "INTEGRATED") {
            	  dragged.addClass("status_integrated");
              }
              
        	  dropped.append(dragged);
           
          ui.draggable.position({
            of: $(this),
            my: 'center center', 
            at: 'center center'
          });
      }
    });
});