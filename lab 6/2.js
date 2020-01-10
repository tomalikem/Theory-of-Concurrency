
function printAsync(s, cb) {
    var delay = Math.floor((Math.random()*1000)+500);
    setTimeout(function() {
        console.log(s);
        if (cb) cb();
    }, delay);
}

function inparallel(parallel_functions, final_function) {
    var counter = 0;
    for (var f of parallel_functions){
        f(function () {
            counter++;
            if(counter === parallel_functions.length){
                final_function()
            }
        })
    }

}

A = function(cb){printAsync("A",cb);}
B = function(cb){printAsync("B",cb);}
C = function(cb){printAsync("C",cb);}
D = function(cb){printAsync("Done",cb);}

inparallel([A,B,C],D)
