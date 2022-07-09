//EX1
function calculateFactorial(value) {
    let result = 1;
    for (let i = 1; i <= value; i++) {
        result = result * i;
    }
    return result;
}
console.log(calculateFactorial(5))

//Ex2
function reverseString(str) {
    let result = "";
    for (let i = str.length; i >= 0; i--) {
        result += str.charAt(i);
    }
    return result;
}
console.log(reverseString("hello"))

//Ex3
function translate(str) {
    switch (str.toUpperCase()) {
        case "VN":
            console.log("Xin Chào")
            break
        case "EN":
            console.log("Hello")
            break
        case "ITA":
            console.log("Ciao")
            break
        case "MEX":
            console.log("Hola")
            break
        case "GER":
            console.log("Holla")
            break
        default:
            console.log("Unknown")
            break
    }
}
translate("en")

//Ex4
function subString(str) {
    let result = "";
    let temp = "...";
    for (let i = 0; i <= str.length; i++) {
        if (i == 10) {
            break;
        }
        result += str.charAt(i);
    }
    result += temp;
    return result;
}

console.log(subString("xinchaocacbandenvoiTechmaster"));

// Oan tu ti
function oneTwoThree(value) {
    if (value < 0 || value > 3) {
        console.log("fail")
    }
    // arr = ["bua","bao","keo"]
    let arr = [1, 2, 3]
    let rand = arr[Math.floor(Math.random() * arr.length)]
    console.log(rand)
    if (value == rand) {
        console.log("Draw")
    } else {
        if (value == 1 && rand == 2 || value == 2 && rand == 3 || value == 3 && rand == 1) {
            console.log("Lose")
        } else {
            console.log("Win")
        }
    }
}

oneTwoThree(2)

