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
      
      drop: function (event, ui) {
        //ui: div element being dragged
        //this: td element being dropped into

        if ($(this).hasClass('hasClass')) { 
          ui.draggable.draggable('option','revert',true);
          return false;  

        } else { 
          var dragged =$(ui.draggable);
          var dropped=$(this);
          
          if(dropped.has(".ui-draggable").length == 0) {
        	  var droppedId = dropped.attr("id").split("-");
              var newDraggedId = dragged.attr("id").split("-")[0] + "-" + droppedId[2];
              dragged.attr("id", newDraggedId);
              
        	  dropped.append(dragged);
          }
           
          //place draggable neatly in droppable; this works
          ui.draggable.position({
            of: $(this),
            my: 'center center', 
            at: 'center center'
          });
        
//          inputElement.val(newVal);
        } 
      }
    });
});