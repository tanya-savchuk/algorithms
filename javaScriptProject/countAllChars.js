function countAllChars(aString){
    var myMap = {}
    for (var i = 0; i < aString.length; i++){
        var currentLetter = aString[i];
        currentLetterCount = myMap[currentLetter] || 0;
        myMap[currentLetter] = currentLetterCount + 1

    }

    return myMap

}

function iterateOverDict(aDict){
    for (var key in aDict){
        console.log(key, aDict[key])
    }
}

testString = "abcabd"
res = countAllChars(testString)
console.log(res)
iterateOverDict(res)

testString = ""
res = countAllChars(testString)
console.log(res)

testString = "aaaa"
res = countAllChars(testString)
console.log(res)