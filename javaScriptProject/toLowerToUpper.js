function alternateCaps(inputString){
    // ascii code - capital letters 65 - 90
    // lowercase - 97 - 122
    const offset = 122-90;
    res = ''
    for (var i = 0; i < inputString.length; i++){
        var charCode = inputString.charCodeAt(i);        
        if (i%2 == 0 && charCode <= 122 && charCode >= 97){
            //capitalize string
            res = res + String.fromCharCode(charCode - offset)
        }
        else if (i%2 == 1 && charCode <= 90 && charCode >= 65){

            res = res + String.fromCharCode(charCode + offset)

        }
        else {
            res = res + String.fromCharCode(charCode)
        }
    }
    return res
}

testString = "giant RED Fox jumps OvER a small black hole"
res = alternateCaps(testString)
console.log(res)

testString = "giant RED Fox jumps OvER: 1. a dog; 2. a chicken 3. a fence? {ййй}"
res = alternateCaps(testString)
console.log(res)