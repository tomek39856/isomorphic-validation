function validateLengthMin(test) {
     if(test == null) {
        return true;
     }
     return test.length>5;
}

function validateLengthMax(test) {
     if(test == null) {
        return true;
     }
     return test.length<10;
}