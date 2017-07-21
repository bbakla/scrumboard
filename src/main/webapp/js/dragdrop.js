$(document).ready(function() {    
// drag and drop table cell "div" elements into and out of "td" elements

    var inputElement; // for entry into mysql database
    
    $('.drag').draggable({
        cursor: "move",
        appendTo: "body",
        revert: "invalid",
        opacity: 0.5,
                
        start: function (event, ui) {
        //store the id and element of the input td when dragging div away, to use in php later
            inputElement=$(this).closest('td').find('div');
            console.log("id is " + $(this).closest('td').find('div').attr('id'));
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